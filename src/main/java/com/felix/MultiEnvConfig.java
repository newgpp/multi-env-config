package com.felix;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @desprication: some desc
 * @author: felix
 * @date: 2023/6/16 14:39
 */
public class MultiEnvConfig {

    private static ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public static void main(String[] args) {

        String env = extracted("application.yaml", "env");

        String address = extracted(String.format("application-%s.yaml", env), "address");

        System.out.println("active.env:" + env + ", address:" + address);


    }

    private static String extracted(String fileName, String field) {
        InputStream is = MultiEnvConfig.class.getClassLoader().getResourceAsStream(fileName);
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonNode.get(field).asText();
    }


}
