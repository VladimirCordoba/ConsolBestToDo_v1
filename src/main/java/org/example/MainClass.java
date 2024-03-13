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

//import jdk.jfr.snippets.Snippets;
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
          //  URL url = new URL("https://api.domainsdb.info/v1/domains/search?limit=2&&country=LV");
          //  URL url = new URL("https://api.domainsdb.info/v1/domains/search?limit=5");
            URL url = new URL("http://localhost:8080/consol/task/list");


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

            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            // Deserialize the JSON string into an array of User objects
            Tasks[] people = objectMapper.readValue(content.toString(), Tasks[].class);

            // Print the details of each user
            for (Tasks tasks : people) {
                System.out.println("id: " + tasks.getId() + ", " + "status: " + tasks.getStatus() +", "+
                        "Tasks:  " + tasks.getTask() +", " + "Priority: " + tasks.getPriority());
            }


            /*String json = "{" + "\"Example\": [" + "{" + "\"foo\": \"a1\","
                    + "\"bar\": \"b1\"," + "\"fubar\": \"c1\"" + "}," + "{"
                    + "\"foo\": \"a2\"," + "\"bar\": \"b2\"," + "\"fubar\": \"c2\""
                    + "}," + "{" + "\"foo\": \"a3\"," + "\"bar\": \"b3\","
                    + "\"fubar\": \"c3\"" + "}" + "]" + "}\"";
            */

            in.close();
            con.disconnect();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
