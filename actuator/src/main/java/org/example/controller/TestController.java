package org.example.controller;

import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czq
 * @date 2024/6/22 17:47
 * @Description:
 */
@RequestMapping("test")
@RestController
public class TestController {


    @RequestMapping("count")
    public String count() throws InterruptedException {
        Metrics.counter("myMetrics", "sum", "count").increment();
        return "success";
    }


    @RequestMapping("gauge")
    public String gauge() throws InterruptedException {
        Metrics.gauge("myMetrics", 10.0);
        return "success";
    }
}
