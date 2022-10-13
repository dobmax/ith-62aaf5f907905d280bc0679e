package ua.ithillel.lesson18.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestRunner {

    private TestRunner() {}

    public static void run(String testClassName) {
        try {
            run(Class.forName(testClassName));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Something went wrong during a test class loading", e);
        }
    }

    public static void run(Class<?> aTestClass) {
        var declaredMethods = Arrays.stream(aTestClass.getDeclaredMethods());
        var testObject = newInstance(aTestClass);


        var beforeSuiteMethodsStream = declaredMethods
                .filter(method -> method.isAnnotationPresent(BeforeSuite.class));

        checkAnnotationQuantity((int) beforeSuiteMethodsStream.count(), BeforeSuite.class.getName());

        var afterSuiteMethodsStream = declaredMethods
                .filter(method -> method.isAnnotationPresent(AfterSuite.class));

        checkAnnotationQuantity((int) afterSuiteMethodsStream.count(), AfterSuite.class.getName());

        beforeSuiteMethodsStream
                .findFirst()
                .ifPresent(executeMethod(testObject));

        declaredMethods.filter(method -> method.isAnnotationPresent(Test.class))
                        .sorted((o1, o2) -> o1.getAnnotation(Test.class).ordering() - o2.getAnnotation(Test.class).ordering())
                        .forEach(executeMethod(testObject));

        afterSuiteMethodsStream
                .findFirst()
                .ifPresent(executeMethod(testObject));

    }

    private static Consumer<Method> executeMethod(Object testObject) {
        return method -> {
            try {
                method.invoke(testObject);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(
                        String.format(
                                "Something went wrong during test method %s execution of object %s",
                                method.getName(),
                                testObject
                        ),
                        e
                );
            }
        };
    }

    private static Object newInstance(Class<?> aTestClass) {
        try {
            return aTestClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Something went wrong during test object instantiation", e);
        }
    }

    private static void checkAnnotationQuantity(int quantity, String annotationName) {
        if (quantity > 1) {
            throw new RuntimeException(annotationName + " annotation must be presented in quantity not more than one");
        }
    }
}
