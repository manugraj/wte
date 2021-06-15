package tool.wte.model;

import java.util.Map;

public class Rule {

    public Rule() {
    }

    public RuleNode getWhen() {
        return when;
    }

    public Map<String, Object> getData() {
        return data;
    }


    public Map<String, Object> getThen() {
        return then;
    }

    public void setWhen(RuleNode when) {
        this.when = when;
    }

    public void setThen(Map<String, Object> then) {
        this.then = then;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    private  RuleNode when;
    private  Map<String,Object> then;
    private  Map<String,Object> data;

}
