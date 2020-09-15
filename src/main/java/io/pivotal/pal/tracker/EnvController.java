package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String port;
    String memoryLimit;
    String cfInstanceIndex;
    String cfInstanceAddr;

    public EnvController(
            @Value("${port:NOT SET}") String port,
            @Value("${memory.limit:NOT SET}") String memoryLimit,
            @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
            @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr
            ){
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddr = cfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String,String> vars = new HashMap<String, String>();
        vars.put("PORT", this.port);
        vars.put("MEMORY_LIMIT", this.memoryLimit);
        vars.put("CF_INSTANCE_INDEX", this.cfInstanceIndex);
        vars.put("CF_INSTANCE_ADDR", this.cfInstanceAddr);

        return vars;
    }
}
