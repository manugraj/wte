package tool.wte.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public class RuleRequest {

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public Map<String, String> getRules() {
        return rules;
    }

    public void setRules(Map<String, String> rules) {
        this.rules = rules;
    }

    private Map<String,String> rules;
    private JsonNode data;

}
