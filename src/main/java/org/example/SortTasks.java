package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class SortTasks {

    public static void allTasksList(Tasks[] tasksArr) throws IOException {
        for (Tasks tasks : tasksArr) {
            System.out.println(
                    "id: " + tasks.getId() + ", "+
                    "Tasks:  " + tasks.getTask().substring(0,30) + "..., " +
                    "status: "  + tasks.getStatus() + ", " +
                    "Priority: " + tasks.getPriority());
        }
        Start.connectToConsol();
    }

    public static void openTasksList(Tasks[] tasksArr) throws IOException {
        List<Tasks> listTMP = new ArrayList<Tasks>();
        //  List<Tasks> tasksList = new ArrayList<>(Arrays.asList(tasksArr));
        for (int i = 0; i < tasksArr.length; i++) {

            if (Objects.equals(tasksArr[i].getStatus(), "OPEN")) {
                listTMP.add(tasksArr[i]);

            }

        }
        Tasks[] sortedTasks = new Tasks[listTMP.size()];
        sortedTasks = listTMP.toArray(sortedTasks);


            for (Tasks tasks : sortedTasks) {
                System.out.println(
                        "id: " + tasks.getId() + ", "+
                                "Tasks:  " + tasks.getTask().substring(0,30) + "..., " +
                                "status: "  + tasks.getStatus() + ", " +
                                "Priority: " + tasks.getPriority());
            }

        Start.connectToConsol();


    }
}