package org.linker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RWM
 * @date 2018/11/1
 */
@RestController
@RefreshScope
public class InfoController {

    @Autowired
    Environment environment;

    /**
     * http://localhost:1202/actuator/refresh
     * POST该地址后，才能访问到Git修改后的配置
     * @return
     */
    @GetMapping("/info")
    public String info() {
        return environment.getProperty("info.profile");
    }
}
