package org.example;

import java.io.*;
import java.util.Objects;

public class Start {


    public static void  connectToConsol() throws IOException {

     //   try {


            InputStream inputStream = System.in;
            Reader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int dchoice ;
            System.out.println("\n \n  ");
            System.out.println("1 - show open tasks");
            System.out.println("2 - add NEW tasks");
            System.out.println("3 - CLOSE TASK ");
            System.out.println("any key - END the program");

         /*
            do{
                String choice = bufferedReader.readLine(); //читаем строку с клавиатуры
                dchoice = Integer.parseInt(choice); //преобразовываем строку в число.
                //  System.out.println("Не верный ввод данных, повторите еще раз: ");
            }while (dchoice != 1 && dchoice != 2 && dchoice !=3 );
            */


            boolean isSorted = false;

            while (!isSorted) {



                isSorted = true;
                String choice = bufferedReader.readLine(); //читаем строку с клавиатуры
              //  dchoice = Integer.parseInt(choice); //преобразовываем строку в число.


                if (Objects.equals(choice, "1")) {

                    cls(); // Чтобы очистить экран
                    System.out.print("\033[H\033[J"); // Чтобы очистить экран
                    //  System.out.println("Get a list of tasks: ");
                     //   SortTasks.allTasksList(Connect.connectToUrl());
                    System.out.println("Get a list of OPEN tasks: ");
                    SortTasks.openTasksList(Connect.connectToUrl());
                    //  isSorted = false;
                } else if (Objects.equals(choice, "2")) {
                    AddTask.addTasksmethod();
                } else if (Objects.equals(choice, "3")) {

                    CloseTask.closeTasksmethod();



                }else {
                    System.out.println("Programm is finished");
                  //  bufferedReader.close();
                  //  inputStream.close();
                    isSorted = false;
                }

               bufferedReader.close();
                inputStream.close();
             //   isSorted = false;
            }  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<



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
