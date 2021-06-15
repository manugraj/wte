package tool.wte.controller;

import tool.wte.manager.RuleService;
import tool.wte.model.Response;
import tool.wte.model.Rules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class RuleController {

    private final RuleService repo;

    @Autowired
    public RuleController(RuleService ruleService)  {
        this.repo = ruleService;
    }


    @PostMapping("/rule/run")
    public ResponseEntity<Response> runRules( @RequestBody Rules rules) {
       return ResponseEntity.ok(new Response(rules.getRules().stream()
               .parallel()
               .map(repo::execute)
               .filter(k-> k != null && !k.isEmpty())
               .collect(Collectors.toList())));
    }

}
