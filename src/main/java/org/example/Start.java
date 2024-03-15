package org.example;

import java.io.*;

public class Start {


    public static void  connectToConsol() throws IOException {

        try {


            InputStream inputStream = System.in;
            Reader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int dchoice = 0;
            System.out.println("1 - show open tasks" );
            System.out.println("2 - add NEW tasks" );
            System.out.println("3 - CLOSE TASK " );
            System.out.println("4 - END the program" );
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
                dchoice = Integer.parseInt(choice); //преобразовываем строку в число.


            }


            if (dchoice == 1 ){

              //  cls(); // Чтобы очистить экран
                System.out.print("\033[H\033[J"); // Чтобы очистить экран
                System.out.println("Get a list of tasks: " );
                SortTasks.allTasksList(Connect.connectToUrl());
                System.out.println("Get a list of OPEN tasks: " );
                SortTasks.openTasksList(Connect.connectToUrl());
               // isSorted = false;
            }else if (dchoice == 2)
            {
                AddTask.addTasksmethod();
            }else if (dchoice == 3)
            {

            CloseTask.closeTasksmethod();

            }else
            {
                System.out.println("Programm is finished");

                bufferedReader.close();
                inputStream.close();
                inputStream.close();
                isSorted = false;
            }



           bufferedReader.close();
          inputStream.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }



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
