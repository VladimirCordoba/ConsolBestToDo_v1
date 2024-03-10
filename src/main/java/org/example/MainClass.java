package org.example;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class MainClass {

    public static void main(String[] args)throws IOException {
      //  System.out.println("Hello world");
     //   System.out.println("Please wait for server response....");

    for ( int i = 0; i < 3; i++) {
        try {

            URL url = new URL("https://api.domainsdb.info/v1/domains/search?limit=50&domain=sportman");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // System.out.println("This is the server response:");
            //   System.out.println(content);
            //  System.out.println(content.substring(13, content.indexOf("]")));

            // String json = content.toString();
            ObjectMapper mapper = new ObjectMapper();
            ObjectMapper mapper1 = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(content.substring(13, content.indexOf("]")), Map.class);
            //Map<String, Object> map = mapper.readValue(content.toString(), Map.class);

            System.out.println(map.get("domain"));
            //   System.out.println(map.get("domains").getClass());
/*
            String s = map.get("domains").toString();
            s = s.substring(2, s.indexOf("}")); //Убираем лишнее
            System.out.println(s);

            Map<String, String> map1 = new HashMap<>();
            Arrays.asList(s)
                    .stream()
                    .map(elem -> elem.split("="))
                    .forEach(elem -> map1.put(elem[0], elem[1]));*/

            // Map<String, Object> map1 = mapper1.readValue(s, Map.class);
            //  System.out.println (map1.get("domain"));

            /*String s = "[77012260000,77012260001,77012260002,77012260003,77012260004,77012260005,77012260006,77012260007].";
            s = s.substring(1, s.indexOf("]")); //Убираем лишнее
            String[] array = s.split(","); //Разбиваем на массив по запятой
            System.out. println(Arrays.toString(array));*/


            in.close();
            con.disconnect();

           /* JSONObject json = new JSONObject(content.toString());
            System.out.println(json);*/

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
System.out.println("Process finished");
    }

}
