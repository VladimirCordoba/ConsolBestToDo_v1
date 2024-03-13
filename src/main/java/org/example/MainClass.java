package org.example;

import java.io.*;



public class MainClass {

    public static void main(String[] args)throws IOException {

        System.out.println("1 - show open tasks" );
        try {
            InputStream inputStream = System.in;
            Reader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String choice = bufferedReader.readLine(); //читаем строку с клавиатуры

           int dchoice = Integer.parseInt(choice); //преобразовываем строку в число.
            System.out.println("Get a list of tasks: " );
            if (dchoice==1 ){
                Connect.connectToUrl();
            }else

            bufferedReader.close();
            inputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
