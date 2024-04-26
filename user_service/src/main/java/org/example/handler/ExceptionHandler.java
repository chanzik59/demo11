package org.example.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author czq
 * @date 2024/4/26 15:44
 * @Description:
 */
@Slf4j
@Component
public class ExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        log.error("异常",e.getRule());
        if(e instanceof FlowException){
            log.warn("被限流了");
        }
        if(e instanceof DegradeException){
            log.warn("被熔断了");
        }
        if(e instanceof ParamFlowException){
            log.warn("参数限流");
        }
        if(e instanceof SystemBlockException){
            log.warn("系统保护");
        }
        if(e instanceof AuthorityException){
            log.warn("授权不通过");
        }




    }
}
