package org.web.enpoint;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author czq
 * @date 2024/6/24 10:08
 * @Description:
 */
@Component
public class MyInfo implements InfoContributor {


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("name", "张三");
    }
}
