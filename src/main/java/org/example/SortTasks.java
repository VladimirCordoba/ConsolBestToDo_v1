package org.example;

public class SortTasks {

    public static void   allTasksList (Tasks[] tasksArr){
        for (Tasks tasks : tasksArr) {
            System.out.println("id: " + tasks.getId() + ", " + "status: " + tasks.getStatus() +", "+
                    "Tasks:  " + tasks.getTask() +", " + "Priority: " + tasks.getPriority());
        }
    }

    public static void   openTasksList (Tasks[] tasksArr){
        //..........
    }

}
