package com.taoli.apiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.taoli.apiclientsdk.model.ClientParam;
import com.taoli.apiclientsdk.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;


import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方接口的客户端
 * 统一返回字符串(否则可能会返回转换异常)
 *
 * @author taoli
 */

@Slf4j
public class ApiClient {

    //网关
    private static final String GATEWAY_HOST = "http://localhost:8100";

    private String accessKey;

    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }


    public String getImageUrl(ClientParam clientParam) {
        String result = postBodySet(clientParam, "getImageUrl");
        if(StringUtils.isBlank(result)){
            throw new RuntimeException("获取接口数据为空");
        }
        return result;
    }

    public String getText(ClientParam clientParam) {
        String result = postBodySet(clientParam, "getText");
        if(StringUtils.isBlank(result)){
            throw new RuntimeException("获取接口数据为空");
        }
        return result;
    }


    /**
     * 编辑距离算法（用于计算最相似的两个字符串）
     * @param clientParam
     * @return
     */
    public String minDistance(ClientParam clientParam) {
        String result = postBodySet(clientParam, "minDistance");
        if(StringUtils.isBlank(result)){
            throw new RuntimeException("获取接口数据为空");
        }
        return result;
    }


    /**
     * 固定
     */
    private  String postBodySet(ClientParam clientParam,String method) {
        String body = JSONUtil.toJsonStr(clientParam);
        String url=GATEWAY_HOST + "/api/apiService/"+method;
        HttpResponse httpResponse = HttpRequest.post(url)
                .addHeaders(getHeaderMap(body))
                .body(body)
                .execute();
        log.info("API域名为{}的接口调用响应状态码为{}",url,httpResponse.getStatus());
        String result = httpResponse.body();
        return result;
    }

    /**
     * 封装固定的请求体
     * @return
     */
    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        // 一定不能直接发送密码
        hashMap.put("accessKey", accessKey);
        //随机数
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        //时间戳
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        //输出头像类型[a1（男头）|b1（女头）|c1（动漫头像）|c2（动漫女头）|c3（动漫男头）]默认为c1
        hashMap.put("body", body);
        //签名
        hashMap.put("sign", SignUtils.genSign(body, secretKey));
        return hashMap;
    }


}
