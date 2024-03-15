package org.example;



import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddTask {
 public static Tasks addTasksmethod ()throws IOException {

    // MainClass.cls(); // Чтобы очистить экран
    // System.out.print("\033[H\033[J"); // Чтобы очистить экран
     System.out.println("Введите новый таск");


            InputStream inputStream = System.in;
            Reader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

             String newTask = bufferedReader.readLine(); //читаем строку с клавиатуры



   //  public Object addTasks(@RequestParam String task, Model model) {
        /* Tasks  tasks = new Tasks();
                 tasks.setTask(newTask);
                 tasks.setStatus("OPEN");
                 tasks.setPriority("LOW");*/
Tasks taskNew = new Tasks("OPEN", newTask, "LOW");


     JSONObject jsonObjTaskNew = new JSONObject(taskNew);
     System.out.println( jsonObjTaskNew );


         return  null;
    }

}
