package com.taoli.apiinterface.service;

import com.taoli.apicommon.dubboService.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import com.taoli.apicommon.model.entity.ClientParam;
/**
 * @author taoli
 */
@Slf4j
@Service
public class ApiServiceImpl implements ApiService {

    @Override
    public String getImageUrl(ClientParam clientParam) {
        //第三方接口自动获取图片url:https://api.btstu.cn/
        String niceImageGiver = "https://api.btstu.cn/sjtx/api.php?lx=c1&format=json";
        Map<String, String> map = getFood(niceImageGiver, "imgurl","code");
        if (StringUtils.isBlank(map.get("imgurl"))){
            return null;
        }
        return map.get("imgurl");
    }

    @Override
    public String getText(ClientParam clientParam) {
        //第三方获取毒鸡汤接口:https://api.btstu.cn/
        String niceImageGiver = "https://api.btstu.cn/yan/api.php?charset=utf-8&encode=json";
        Map<String, String> map = getFood(niceImageGiver, "text");
        if (StringUtils.isBlank(map.get("text"))){
            return null;
        }
        return map.get("text");
    }

    private Map<String, String> getFood(String niceImageGiver, String... targetNameList) {
        HashMap<String, String> resultMap = new HashMap<>(targetNameList.length);
        try {
            if (StringUtils.isBlank(niceImageGiver)) {
                return new HashMap<>(targetNameList.length);
            }
            URL obj = new URL(niceImageGiver);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject jsonResponse = new JSONObject(response.toString());
            for (String s : targetNameList) {
                String childResult = jsonResponse.getString(s);
                resultMap.put(s, childResult);
            }

            log.info("result生成");
            return resultMap;
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return resultMap;
    }
}
