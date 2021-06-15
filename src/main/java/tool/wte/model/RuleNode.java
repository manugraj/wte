package tool.wte.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import tool.wte.manager.Operation;

@JsonPropertyOrder({
        "lhs",
        "operation",
        "rhs",
        "and",
        "or",
        "invert"
})
public class RuleNode {

    private Operation operation;
    private Object rhs;
    private Object lhs;
    private ComposedNode and;
    private ComposedNode or;
    private boolean invert;

    public Object getRhs() {
        return rhs;
    }

    public void setRhs(Object rhs) {
        this.rhs = rhs;
    }

    public Object getLhs() {
        return lhs;
    }

    public void setLhs(Object lhs) {
        this.lhs = lhs;
    }


    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public ComposedNode getAnd() {
        return and;
    }

    public void setAnd(ComposedNode and) {
        this.and = and;
    }

    public ComposedNode getOr() {
        return or;
    }

    public void setOr(ComposedNode or) {
        this.or = or;
    }

    public boolean isInvert() {
        return invert;
    }

    public void setInvert(boolean invert) {
        this.invert = invert;
    }

}
