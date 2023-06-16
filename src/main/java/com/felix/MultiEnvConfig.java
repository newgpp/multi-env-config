package com.felix;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @desprication: some desc
 * @author: felix
 * @date: 2023/6/16 14:39
 */
public class MultiEnvConfig {

    public static void main(String[] args) {
        String env = args.length > 0 ? args[0] : "test";
        System.out.println("active.env:" + env);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.KEBAB_CASE);
        InputStream is = MultiEnvConfig.class.getClassLoader().getResourceAsStream(String.format("application-%s.yaml", env));
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonNode);
    }


}
