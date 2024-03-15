package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CloseTask {

    public static void closeTasksmethod ()throws IOException {

        // MainClass.cls(); // Чтобы очистить экран
        // System.out.print("\033[H\033[J"); // Чтобы очистить экран
        System.out.println("enter task id");

        int dnewTaskStatus = 0;
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String newTaskStatus = bufferedReader.readLine(); //читаем строку с клавиатуры
       // dnewTaskStatus = Integer.parseInt(newTaskStatus); //преобразовываем строку в число.

        if (!newTaskStatus.equals("CLOSE")){


         bufferedReader.close();
         inputStream.close();

         Start.connectToConsol();
         }


        //  public Object addTasks(@RequestParam String task, Model model) {
        /* Tasks  tasks = new Tasks();
                 tasks.setTask(newTask);
                 tasks.setStatus("OPEN");
                 tasks.setPriority("LOW");*/

/*
Tasks taskNew = new Tasks("OPEN", newTask, "LOW");


     JSONObject jsonObjTaskNew = new JSONObject(taskNew);
     System.out.println( jsonObjTaskNew );
*/




        try {
            // Создаем URL-адрес для запроса
            URL url = new URL("http://localhost:8080/consol/task/close");

            // Создаем объект HttpURLConnection и настраиваем его
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Создаем тело запроса
            String task = "id1=" + newTaskStatus; //*************<<<<<<<<<<<<<<<************************
            System.out.println(task);

            // Записываем тело запроса в поток вывода
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(task);
            writer.flush();

            // Считываем ответ от сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();


            // Выводим ответ от сервера
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        Start.connectToConsol();

        //  return  null;

    }




}
