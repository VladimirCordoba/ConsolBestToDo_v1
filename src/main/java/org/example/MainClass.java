package org.example;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.json.JSONObject;

public class MainClass {

    public static void main(String[] args)throws IOException {
      //  System.out.println("Hello world");
     //   System.out.println("Please wait for server response....");


        try {

         //  URL url = new URL("https://api.domainsdb.info/v1/domains/search?limit=50&domain=sportman");
            URL url = new URL("https://api.domainsdb.info/v1/domains/search?limit=2&&country=LV");
          //  URL url = new URL("https://api.domainsdb.info/v1/domains/search?limit=5");

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
             System.out.println(content);



            ObjectMapper mapper = new ObjectMapper();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(content.toString());


            // получение массива
            JSONArray lang= (JSONArray) jsonObject.get("domains");

            // достаем элементы массива каждый элкмент это уже простой JSON
            for(int i=0; i<lang.size(); i++){
              //  System.out.println("The " + i + " element of the array: "+lang.get(i));
                // помещаем элементы в мапу и сразу можем из маты достать конкретное поле в данном случае это domen
                Map<String, Object> map = mapper.readValue(lang.get(i).toString(), Map.class);
                System.out.println("Domen Nr"+ i +" "+ map.get("domain"));
            }





         // System.out.println(content.substring(12, 1+content.indexOf("]")));

            // String json = content.toString();

          /* ObjectMapper mapper = new ObjectMapper();
            ObjectMapper mapper1 = new ObjectMapper();
            String json = content.substring(13, content.indexOf("]"));
            System.out.println("Printing json=" + json);
*/

          //  Map<String, Object> map = mapper.readValue(content.substring(13, content.indexOf("]")), Map.class);
          //  Map<String, Object> map = mapper.readValue(json, Map.class);

          //  System.out.println("Indeks=" + content.indexOf("]"));
          //  System.out.println("Dlinna ctroki=" + content.length());

          //  System.out.println("Printing map");
           // System.out.println(map);
          //  System.out.println(map.get("domain"));



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


          //  in.close();
          //  con.disconnect();

           /* JSONObject json = new JSONObject(content.toString());
            System.out.println(json);*/

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
