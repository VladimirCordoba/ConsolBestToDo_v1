package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class SortTasks {

    public static void allTasksList(Tasks[] tasksArr) {
        for (Tasks tasks : tasksArr) {
            System.out.println("id: " + tasks.getId() + ", " + "status: " + tasks.getStatus() + ", " +
                    "Tasks:  " + tasks.getTask() + ", " + "Priority: " + tasks.getPriority());
        }
    }

    public static void openTasksList(Tasks[] tasksArr) {
        List<Tasks> listTMP = new ArrayList<Tasks>();
        //  List<Tasks> tasksList = new ArrayList<>(Arrays.asList(tasksArr));
        for (int i = 0; i < tasksArr.length; i++) {

            if (!Objects.equals(tasksArr[i].getStatus(), "CLOSED")) {
                listTMP.add(tasksArr[i]);
            }
            Tasks[] sortedTasks = new Tasks[listTMP.size()];
            sortedTasks = listTMP.toArray(sortedTasks);

            for (Tasks tasks : sortedTasks) {
                System.out.println("id: " + tasks.getId() + ", " + "status: " + tasks.getStatus() + ", " +
                        "Tasks:  " + tasks.getTask() + ", " + "Priority: " + tasks.getPriority());
            }

/*
        for (Tasks tasks : tasksArr) {
          if (!Objects.equals(tasks.getStatus(), "CLOSED")){
              tasksList.remove(IndexOf(tasks))
              listTMP.add();

          }



            System.out.println("id: " + tasks.getId() + ", " + "status: " + tasks.getStatus() +", "+
                    "Tasks:  " + tasks.getTask() +", " + "Priority: " + tasks.getPriority());
        }*/

       /* List<Tasks> tasksList = new ArrayList<>(Arrays.asList(tasksArr));
        tasksList.removeIf(n -> n == tasksList.);
        //..........*/
        }

    }
}