package ua.ithillel.lesson18.classwork;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        doDemo7(null);
    }

    static void doDemo7(Object initValue) {
        var enclosedContainerClass = EnclosedContainer.class;

        var notNullParameter = Arrays.stream(enclosedContainerClass.getDeclaredConstructors())
                .flatMap(constructor -> Arrays.stream(constructor.getParameters()))
                .filter(parameter -> parameter.isAnnotationPresent(NotNull.class))
                .findFirst()
                .orElseThrow();

        var constr = Arrays.stream(enclosedContainerClass.getDeclaredConstructors())
                .filter(constructor -> Arrays.stream(constructor.getParameters())
                        .anyMatch(parameter -> parameter.isAnnotationPresent(NotNull.class)))
                .findFirst()
                .orElseThrow();

        try {
            if (initValue == null) {
                throw new IllegalArgumentException(notNullParameter.getAnnotation(NotNull.class).message());
            }
            var newValue = (EnclosedContainer) constr.newInstance(initValue);
            System.out.println(newValue);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    static void doDemo6() {
        var enclosedContainer = new EnclosedContainer(10);
        var enclosedContainerClass = EnclosedContainer.class;

        Arrays.stream(enclosedContainerClass.getDeclaredConstructors())
                .flatMap(constructor -> Arrays.stream(constructor.getParameters()))
                .filter(parameter -> parameter.isAnnotationPresent(NotNull.class))
                .forEach(System.out::println);

    }

    static void doDemo5() {
        var enclosedContainer = new EnclosedContainer(10);
        var enclosedContainerClass = EnclosedContainer.class;

        var enclosedContainer2 = Arrays.stream(enclosedContainerClass.getDeclaredConstructors())
                .filter(constructor -> Modifier.isPublic(constructor.getModifiers()))
                .map(constructor -> {
                    try {
                        return constructor.newInstance(100);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(EnclosedContainer.class::isInstance)
                .map(EnclosedContainer.class::cast)
                .findFirst()
                .orElseThrow();


        System.out.println("Val => " + enclosedContainer);
        System.out.println("Val => " + enclosedContainer2);
    }

    static void doDemo4() {
        var enclosedContainer = new EnclosedContainer(10);
        var enclosedContainerClass = EnclosedContainer.class;

        var enclosedContainer2 = Arrays.stream(enclosedContainerClass.getDeclaredConstructors())
                .filter(constructor -> Modifier.isPublic(constructor.getModifiers()))
                .map(constructor -> {
                    try {
                        return constructor.newInstance(100);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(EnclosedContainer.class::isInstance)
                .map(EnclosedContainer.class::cast)
                .findFirst()
                .orElseThrow();


        System.out.println("Val => " + enclosedContainer);
        System.out.println("Val => " + enclosedContainer2);
    }

    static void doDemo3() {
        var enclosedContainer = new EnclosedContainer(10);
        var enclosedContainerClass = EnclosedContainer.class;

        Arrays.stream(enclosedContainerClass.getDeclaredMethods())
                .filter(method -> Modifier.isPrivate(method.getModifiers()))
                .forEach(method -> {
                    System.out.println(method.getModifiers());
                    System.out.println(method);

                    method.setAccessible(true);
                    try {
                        method.invoke(enclosedContainer, 11);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    } finally {
                        method.setAccessible(false);
                    }
                });

        System.out.println("Val => " + enclosedContainer);
    }

    static void doDemo2() {
        var enclosedContainer = new EnclosedContainer(10);
        var enclosedContainerClass = EnclosedContainer.class;

        Arrays.stream(enclosedContainerClass.getDeclaredFields())
                .forEach(field -> {
                    if (Modifier.isFinal(field.getModifiers())) {
                        System.out.println(field.getModifiers());
                        System.out.println(field);
                    }
                    try {
                        field.setAccessible(true);
                        var intVal = field.getInt(enclosedContainer);
                        System.out.println("Int Val => " + intVal);
                        field.set(enclosedContainer, 11);
                        field.setAccessible(false);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        System.out.println("Val => " + enclosedContainer);
    }

    static void doDemo1() {
        var applicationClass = Application.class;
        var applicationClass2 = new Application().getClass();
        var stringClass = String.class;
        var stringClass2 = "hello, world".getClass();
        var arrClass = int[].class;
        var integerClass = Integer.class;
        var integerClass2 = Integer.valueOf(1).getClass();
        var voidClass = Void.class;

//        ResponseEntity<Void>
    }
}
