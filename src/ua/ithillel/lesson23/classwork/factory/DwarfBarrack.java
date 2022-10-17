package ua.ithillel.lesson23.classwork.factory;

import java.util.Arrays;
import java.util.function.Supplier;

public class DwarfBarrack implements Barrack {
    @Override
    public <T extends Unit> Unit invoke(Class<T> type) {
        return UnitHatchery.resolve(type).newInstance();
    }

    private static enum UnitHatchery {
        WARRIOR(Warrior.class, () -> {
            return new Warrior();
        }),
        ARCHER(Archer.class, Archer::new),
        CLERIC(Cleric.class, Cleric::new),
        ;

        private final Class<? extends Unit> type;
        private final Supplier<? extends Unit> newInstance;

        UnitHatchery(Class<? extends Unit> type, Supplier<? extends Unit> newInstance) {
            this.type = type;
            this.newInstance = newInstance;
        }

        public <T extends Unit> T newInstance() {
            return (T) newInstance.get();
        }

        public static <T extends Unit> UnitHatchery resolve(Class<T> type) {
            return Arrays.stream(values())
                    .filter(unitHatchery -> unitHatchery.type.equals(type))
                    .findFirst()
                    .orElseThrow(
                            () -> new IllegalArgumentException(
                                    String.format(
                                            "Unknown type %s of cannot be applied for %s",
                                            type,
                                            DwarfBarrack.class
                                    )
                            ));
        }
    }
}
