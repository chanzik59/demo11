package org.web.controller;


import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.web.entity.Book1;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author czq
 * @date 2024/8/22 16:42
 * @Description:
 */
@RequestMapping("test")
@Controller
@Api(tags = "测试项目")
@Slf4j
public class TestController {


    //    @Value("${spring.test.msg}")
    private String msg;


    @Resource
    private AA aa;


    @Resource
    private RestTemplate template;


    private static ExecutorService pool = Executors.newFixedThreadPool(1);


    @ApiOperation(value = "打印测试")
    @GetMapping("test")
    @ResponseBody
    public String test(String name) {
        return name;

    }

    @ApiOperation(value = "类测试")
    @PostMapping("book")
    @ResponseBody
    public Book1 book(Book1 book) {
        return book;

    }


    @RequestMapping("msg")
    @ResponseBody
    public String getMsg(HttpServletRequest request) {
//        System.out.println("request:"+request);
//        Map<String, String> map = getMap(request);
//        String orderId = map.get("orderId");
        System.out.println(aa);

        return "aa";
    }

    @RequestMapping("mock")
    @ResponseBody
    public String mock(@RequestBody String request) {
        System.out.println(request);
        JSONObject requestJson = JSONObject.parseObject(request);
        JSONObject resp = new JSONObject();
        String orderId = requestJson.getString("orderId");
        String accessType = requestJson.getString("accessType");
        resp.put("orderId", orderId);
        resp.put("accessType", accessType);
        resp.put("tn", orderId);
        resp.put("code", "0000000000");
        resp.put("msg", "交易成功");
        resp.put("subCode", "0000000000");
        resp.put("subMsg", "交易成功");


        pool.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                Object forObject = template.postForObject("http://192.168.28.80:8899/ucpnotify/cufullpostrx.do", resp.toJSONString(), Object.class);
                System.out.println(forObject);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return resp.toJSONString();
    }


    @RequestMapping("mock/cbm")
    @ResponseBody
    @ApiOperation("cmb类方法测试")
    public String cbm(@RequestBody String request) {
        log.info(request);
        String resp = "<?xml version=\"1.0\" encoding=\"GBK\"?><CMBSDKPGK><INFO><DATTYP>2</DATTYP><ERRMSG></ERRMSG><FUNNAM>GetHisNoticeEX</FUNNAM><LGNNAM>yangkaiyue</LGNNAM><RETCOD>0</RETCOD></INFO><DCHISMSGZ><CRTTIM>20250407090646</CRTTIM><EFTDAT>20250407</EFTDAT><EXPDAT>20250417</EXPDAT><MSGNBR>202504070606766763</MSGNBR><MSGTYP>NCCRTTRS</MSGTYP><RCVTIM>20250407090646</RCVTIM></DCHISMSGZ><NCCRTTRSY><ACCNAM>通联支付网络服务股份有限公司</ACCNAM><ACCNBR>121907679110247</ACCNBR><AMTCDR>C</AMTCDR><BBKNBR></BBKNBR><BILNBR></BILNBR><BILTXT></BILTXT><BILTYP></BILTYP><BLVAMT>4372024.45</BLVAMT><BUSNAR></BUSNAR><CCYNBR>10</CCYNBR><GSBACC></GSBACC><GSBADR></GSBADR><GSBBBK></GSBBBK><GSBBBN></GSBBBN><GSBBNK></GSBBNK><GSBNAM></GSBNAM><INFFLG>2</INFFLG><MSGNBR>202504070606766763</MSGNBR><MSGTYP>NCCRTTRS</MSGTYP><NARTXT>250403_250406日银联服务费48210001</NARTXT><NEWBIL></NEWBIL><RPYACC>1100000000</RPYACC><RPYADR></RPYADR><RPYBBK></RPYBBK><RPYBBN></RPYBBN><RPYBNK>中国银联股份有限公司</RPYBNK><RPYNAM>银联卡一级资金清算</RPYNAM><RSV50Z></RSV50Z><RVSTAG>N</RVSTAG><SEQNBR>C06474C0004A4AZ</SEQNBR><TRSAMT>76089.04</TRSAMT><TRSANL></TRSANL><TRSDAT>20250407</TRSDAT><TRSSET></TRSSET><TRSTIM>090645</TRSTIM><VALDAT>20250407</VALDAT><YURREF></YURREF></NCCRTTRSY></CMBSDKPGK>";
        return resp;
    }


    @RequestMapping("port")
    @ResponseBody
    @ApiOperation("cmb类方法测试")
    public String getPort( @Value("${server.port}") String port) {
        log.info(port);
        return port;
    }

    @RequestMapping("port1")
    @ResponseBody
    @ApiOperation("cmb类方法测试")
    public String getPort1( @Value("${server.port}") String port) {
        log.info(port);
        return port;
    }

    @RequestMapping("v1")
    @ResponseBody
    @ApiOperation("v1")
    public String v1( @Value("${server.port}") String port) {
        log.info(port);
        return port+":v1";
    }






    private Map<String, String> getMap(String msg) {
        Map<String, String> map = new HashMap<>();
        String[] split = msg.split("&");
        for (String s : split) {
            String[] split1 = s.split("=");
            map.put(split1[0], split1[1]);
        }
        return map;
    }


}
