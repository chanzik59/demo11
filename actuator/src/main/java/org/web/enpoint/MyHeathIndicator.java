package org.web.enpoint;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author czq
 * @date 2024/6/23 15:22
 * @Description:
 */
@Component
public class MyHeathIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        try {
            builder.up();
            builder.withDetail("status", "1");
//            int i = 1 / 0;
        } catch (Exception e) {
            builder.down(e);
        }


    }

    @Override
    public Health getHealth(boolean includeDetails) {
        return super.getHealth(includeDetails);
    }
}
