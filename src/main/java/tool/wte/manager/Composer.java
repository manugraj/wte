package tool.wte.manager;

import java.util.Arrays;

public enum Composer {
    AND{
        @Override
        public Boolean of(Boolean... args) {
            return Arrays.stream(args).allMatch(k->k);
        }
    },
    OR{
        @Override
        public Boolean of(Boolean... args) {
            return Arrays.stream(args).anyMatch(k->k);
        }
    }

    ;

    public abstract Boolean of(Boolean... args);
}
