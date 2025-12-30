package org.web;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Unit test for simple App.
 */
@RefreshScope
@SpringBootTest(classes = ConsumerApp.class)
public class AppTest {

    @Value("${bb}")
//    @NacosValue(value = "${bb}",autoRefreshed = true)
    private String aa;
//
//    public static void main(String[] args) throws NacosException, InterruptedException {
//        String host="localhost:8848";
//        String dataId="test";
//        String group="DEFAULT_GROUP";
//        Properties properties = new Properties();
//        properties.setProperty("serverAddr",host);
//        ConfigService configService = NacosFactory.createConfigService(properties);
//        String config = configService.getConfig(dataId, group, 200);
//        configService.publishConfig(dataId,group,"bb=3");
//        System.out.println(config);
//        configService.addListener(dataId, group, new Listener() {
//            @Override
//            public Executor getExecutor() {
//                return null;
//            }
//
//            @Override
//            public void receiveConfigInfo(String configInfo) {
//                System.out.println(configInfo);
//
//            }
//        });
//
//
//        TimeUnit.DAYS.sleep(1);
//
//    }






    @Test
    public void test(){
        System.out.println(aa);
    }

}
