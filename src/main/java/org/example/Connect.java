package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

public  class Connect  {
    public static Tasks[]  connectToUrl() throws IOException {


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


          //  in.close();
          //  con.disconnect();


      //  return content;
   // }
//public static Tasks[]  jsonToPojo(StringBuffer content) throws JsonProcessingException {
    // Create an ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();
    // Deserialize the JSON string into an array of User objects
    Tasks[] tasksArr = objectMapper.readValue(content.toString(), Tasks[].class);
   /* // Print the details of each user
    for (Tasks tasks : tasksArr) {
        System.out.println("id: " + tasks.getId() + ", " + "status: " + tasks.getStatus() +", "+
                "Tasks:  " + tasks.getTask() +", " + "Priority: " + tasks.getPriority());
    }*/
return tasksArr;
}

}
