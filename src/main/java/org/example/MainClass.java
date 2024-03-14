package org.example;

import java.io.*;



public class MainClass {

    public static void main(String[] args)throws IOException {

      //  System.out.println("1 - show open tasks" );
        try {
            InputStream inputStream = System.in;
            Reader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int dchoice = 0;
            System.out.println("1 - show open tasks" );
            do{

                String choice = bufferedReader.readLine(); //читаем строку с клавиатуры
                 dchoice = Integer.parseInt(choice); //преобразовываем строку в число.
              //  System.out.println("Не верный ввод данных, повторите еще раз: ");
            }while (dchoice != 1);
            System.out.print("\033[H\033[J"); // Чтобы очистить экран
            System.out.println("Get a list of tasks: " );


            SortTasks.allTasksList(Connect.connectToUrl());
            System.out.println("Get a list of OPEN tasks: " );
            SortTasks.openTasksList(Connect.connectToUrl());




            bufferedReader.close();
            inputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
