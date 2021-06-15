package tool.wte.manager;

import java.math.BigDecimal;
import java.util.Map;

public enum Operation {
    EQ{
        @Override
        public boolean run(Object lhs, Object rhs) {
            return lhs.equals(rhs);
        }
    },
    GT{
        @Override
        public boolean run(Object lhs, Object rhs) {
            return new BigDecimal(String.valueOf(lhs)).compareTo(new BigDecimal(String.valueOf(rhs)))  > 0;
        }
    },
    LT{
        @Override
        public boolean run(Object lhs, Object rhs) {
            return new BigDecimal(String.valueOf(lhs)).compareTo(new BigDecimal(String.valueOf(rhs))) < 0;
        }
    },
    GTE{
        @Override
        public boolean run(Object lhs, Object rhs) {
            return new BigDecimal(String.valueOf(lhs)).compareTo(new BigDecimal(String.valueOf(rhs))) >= 0;
        }
    },
    LTE {
        @Override
        public boolean run(Object lhs, Object rhs) {
            return new BigDecimal(String.valueOf(lhs)).compareTo(new BigDecimal(String.valueOf(rhs))) <= 0;
        }
    },
    LIKE{
        @Override
        public boolean run(Object lhs, Object rhs) {
            return lhs instanceof String && rhs instanceof String && ((String) lhs).contains((String) rhs);
        }
    }
    ;

    public abstract boolean run(Object lhs, Object rhs);

    private Object getDynamicData(Object arg,Map<String, Object> data){
        if ((arg instanceof String) && ((String) arg).startsWith("$") && ((String) arg).endsWith("$"))
            return data.get(((String) arg).replace("$",""));
        return arg;
    }

    public boolean run(Object lhs, Object rhs, Map<String, Object> data){
        return run(getDynamicData(lhs, data), getDynamicData(rhs, data));
    }
}
