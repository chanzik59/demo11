package org.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author czq
 * @date 2024/9/18 19:06
 * @Description:
 */

@Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class AA {

    @PostConstruct
    public void init() {
        System.out.println("aa");
    }
}
