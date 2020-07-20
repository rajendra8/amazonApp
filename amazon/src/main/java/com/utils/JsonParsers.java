package com.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import freemarker.core.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JsonParsers {
    public static HashMap<String, String> generateMapDesiredCapabilities(String jsonFileName) {
        try {
            Path path = Paths.get("./src/main/resources/" + jsonFileName + ".json");
            //Reading the OR JSON file
            String json = new String(Files.readAllBytes(path));

            //Needed to have a map of the JSON values
            ObjectMapper mapper = new ObjectMapper();
            //Final map with all JSON values as key pair
            HashMap<String, String> map = new HashMap<String, String>();
            //Parser to parse the JSON file
            JSONParser parser = new JSONParser();
          Object obj=  parser.parse(json);

//            Object obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            String currentExecutionDevice = jsonObject.get("ExecutionDevice").toString();

            map.putAll(mapper.readValue(JsonPath.read(json, "$." + currentExecutionDevice).toString(), new TypeReference<Map<String, String>>() {
            }));

            map.putAll(mapper.readValue(JsonPath.read(json, "$." + "Commons").toString(), new TypeReference<Map<String, String>>() {
            }));

//            Log.info("The desired capabilities map is:\n" + map);
            return map;
        } catch (IOException e) {
//            Log.info("We have encounter an Exception while reading bytes from file and details are : " + e);
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
//            Log.info("We have encounter an Exception while parsing the json and details are : " + e);
            e.printStackTrace();
        } catch (Exception e) {
//            Log.info("We have encounter an Exception and details are : " + e);
            e.printStackTrace();
        }
        return null;
    }
    public static HashMap<String, String> jsontoMap(String jsonFileName) {
        try {
            Path path = Paths.get("./src/main/resources/" + jsonFileName + ".json");
            //Reading the OR JSON file
            String json = new String(Files.readAllBytes(path));

            //Needed to have a map of the JSON values
            ObjectMapper mapper = new ObjectMapper();
            //Final map with all JSON values as key pair
            HashMap<String, String> map = new HashMap<String, String>();
            //Parser to parse the JSON file
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(json);
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) obj;

            //Set to store all the page names from the OR JSON file
            Set<String> mySet = jsonObject.keySet();
            for (String key : mySet) {
                map.putAll(mapper.readValue(JsonPath.read(json, "$." + key).toString(), new TypeReference<Map<String, String>>() {
                }));
                //map = mapper.readValue(JsonPath.read(json, "$."+key).toString(), new TypeReference<Map<String, String>>(){});
            }
            // Log.info("The OR map is:\n" + map);
            return map;
        } catch (IOException e) {
           System.out.println("We have encountered an IOEXception and details are : " + e);
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("We have encountered an ParseException and details are : " + e);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("We have encountered an Exception and details are : " + e);
            e.printStackTrace();
        }
        return null;
    }

    public static DesiredCapabilities setCapabalities(Map<String, String> mapDesiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //iterating the mapDesiredCapabilities and setting the capabilities
        for (Map.Entry<String, String> entry : mapDesiredCapabilities.entrySet())
            capabilities.setCapability(entry.getKey(), entry.getValue());
        return capabilities;
    }

}
