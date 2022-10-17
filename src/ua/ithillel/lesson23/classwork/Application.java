package ua.ithillel.lesson23.classwork;

import ua.ithillel.lesson23.classwork.factory.Cleric;
import ua.ithillel.lesson23.classwork.factory.DwarfBarrack;
import ua.ithillel.lesson23.classwork.factory.Unit;
import ua.ithillel.lesson23.classwork.factory.Warrior;
import ua.ithillel.lesson23.classwork.singleton.SingletonObject;

public class Application {
    public static void main(String[] args) {
        var singletonObject = SingletonObject.getInstance();
        var barrack = new DwarfBarrack();

        var warrior01 = barrack.invoke(Warrior.class);
        var warrior02 = barrack.invoke(Warrior.class);
        var cleric01 = barrack.invoke(Cleric.class);
    }
}
