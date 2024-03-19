package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainClass {

    public static void main(String[] args) throws IOException {

        String url = "%7B%22id%22%3Anull%2C%22task%22%3Anull%2C%22status%22%3Anull%2C%22priority%22%3A%22LOW%22%7D=";

System.out.println("URL="+ new String(url.getBytes("UTF8"),"ASCII"));

        String result = java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());

System.out.println("Result=" + result);
        Start.connectToConsol();

    }


}
