package tool.wte.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import tool.wte.model.ComposedNode;
import tool.wte.model.Rule;
import tool.wte.model.RuleNode;
import tool.wte.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RuleService {

    private final ObjectMapper mapper;

    @Autowired
    public RuleService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Map<String, Object> execute(Rule rule) {
        try {
            if (processSingleNode(rule.getWhen(), rule.getData() == null ? Map.of() : Maps.flatten(rule.getData()))) {
                return rule.getThen();
            }
            return Map.of();
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("error", e.getMessage());
        }
    }

    private boolean processSingleNode(RuleNode ruleNode, Map<String, Object> data) {
        boolean and = ruleNode.getAnd() == null || processAnd(ruleNode.getAnd(), data);
        boolean or = ruleNode.getOr() != null && processOr(ruleNode.getOr(), data);
        return ruleNode.isInvert() != (and && ruleNode.getOperation().run(ruleNode.getLhs(), ruleNode.getRhs(), data) || or);
    }

    private boolean processOr(ComposedNode composedNode, Map<String, Object> data) {
        return Composer.OR.of(composedNode.getRules().stream().map(k -> processSingleNode(k, data)).toArray(Boolean[]::new));
    }

    private boolean processAnd(ComposedNode composedNode, Map<String, Object> data) {
        return Composer.AND.of(composedNode.getRules().stream().map(k -> processSingleNode(k, data)).toArray(Boolean[]::new));
    }
}
