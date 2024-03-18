package org.example;

import java.io.*;
import java.util.Objects;

public class Start {


    public static void  connectToConsol() throws IOException {

     //   try {
            int dchoice ;
            System.out.println("\n \n  ");
            System.out.println("1 - show open tasks");
            System.out.println("2 - add NEW tasks");
            System.out.println("3 - CLOSE TASK ");
            System.out.println("4 - show ALL tasks ");
            System.out.println("5 - Priority ");

            System.out.println("any key - END the program");




            InputStream inputStream = System.in;
            Reader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String choice = bufferedReader.readLine(); //читаем строку с клавиатуры
        //  dchoice = Integer.parseInt(choice); //преобразовываем строку в число.



                if (Objects.equals(choice, "1")) {

                  //  cls(); // Чтобы очистить экран
                  //  System.out.print("\033[H\033[J"); // Чтобы очистить экран

                    System.out.println("Get a list of OPEN tasks: ");
                    SortTasks.openTasksList(Connect.connectToUrl());

                } else if (Objects.equals(choice, "2")) {

                    Start.cls(); // Чтобы очистить экран
                    System.out.print("\033[H\033[J"); // Чтобы очистить экран

                    AddTask.addTasksmethod();

                } else if (Objects.equals(choice, "3")) {

                    Start.cls(); // Чтобы очистить экран
                    System.out.print("\033[H\033[J"); // Чтобы очистить экран

                    CloseTask.closeTasksmethod();

                }else if (Objects.equals(choice, "4"))   {

                    cls(); // Чтобы очистить экран
                    System.out.print("\033[H\033[J"); // Чтобы очистить экран
                     System.out.println("Get a list of tasks: ");
                       SortTasks.allTasksList(Connect.connectToUrl());

                }else if (Objects.equals(choice, "5"))   {

                    cls(); // Чтобы очистить экран
                    System.out.print("\033[H\033[J"); // Чтобы очистить экран
                    UpdatePriotity.updatePriorityMethod();


                }else {
                    System.out.println("Programm is finished");
                  //  bufferedReader.close();
                  //  inputStream.close();

                }

               bufferedReader.close();
                inputStream.close();
             //   isSorted = false;


     //   } catch (Exception ex) {
         //   ex.printStackTrace();
      //  }


      //  bufferedReader.close();
      //  inputStream.close();
    }


    // код для очистки экрана
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }


}
