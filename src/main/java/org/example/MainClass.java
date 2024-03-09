package org.example;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class MainClass {

    public static void main(String[] args)throws IOException {
        System.out.println("Hello world");
        System.out.println("Please wait for server response....");


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
            System.out.println("This is the server response:");
               System.out.println(content);
            in.close();
            con.disconnect();
/*
            JSONObject json = new JSONObject(content.toString());
            System.out.println(json);*/

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
