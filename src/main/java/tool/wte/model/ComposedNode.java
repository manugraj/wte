package tool.wte.model;

import java.util.List;

public class ComposedNode {

    public List<RuleNode> getRules() {
        return rules;
    }

    public void setRules(List<RuleNode> rules) {
        this.rules = rules;
    }

    private List<RuleNode> rules;
}
