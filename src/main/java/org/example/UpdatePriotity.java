package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdatePriotity {

    public static void updatePriorityMethod ()throws IOException {

        // MainClass.cls(); // Чтобы очистить экран
        // System.out.print("\033[H\033[J"); // Чтобы очистить экран
        System.out.println("enter task id");


        int dnewTaskStatus = 0;
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String tmpId = bufferedReader.readLine(); //читаем строку с клавиатуры
        System.out.println("task id =" + tmpId);
        System.out.println("enter task priority");
        String tmpPriority = bufferedReader.readLine(); //читаем строку с клавиатуры
        System.out.println("task priority=" + tmpPriority);








        try {
            // Создаем URL-адрес для запроса
            URL url = new URL("http://localhost:8080/consol/task/update/priority");

            // Создаем объект HttpURLConnection и настраиваем его
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Создаем тело запроса
          //  String id = "id1=" + tmpId; //*************<<<<<<<<<<<<<<<************************
           // String priority = "priority1=" + tmpPriority;
           // String body1 = "id1=4502&priority1=2";
            String body = "id1="+tmpId+"&"+"priority1="+tmpPriority;  ///<-----------------------
           // String body = "{\"id1\":"+tmpId+","+" + "\"priority1\"\+"+",":"+ tmpPriority;
          //  String body = "{\"id1\":\"4053\",\"priority1\":2}";

            System.out.println("body=" + body);
            // Записываем тело запроса в поток вывода
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
           // writer.write(priority);

            writer.flush();

            // Считываем ответ от сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            //  bufferedReader.close();
            //  inputStream.close();



            // Выводим ответ от сервера
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        Start.connectToConsol();

        //  return  null;

    }




}
