package org.example;

import model.Task;
import service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Task> tasksList = new ArrayList<>();
        TaskService taskService = new TaskService(tasksList);


        Scanner scanner = new Scanner(System.in);
        int idCounter = 1;
        while (true) {
            System.out.println("\n--- To-Do List App ---");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();

                    Task newTask = new Task(idCounter++, title, description);
                    taskService.addTask(newTask);
                    System.out.println("✅ Task added successfully!");
                    break;

                case 2:
                    System.out.println("--- Your Tasks ---");
                    List<Task> allTasks = taskService.getAllTasks();
                    if (allTasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        for (Task t : allTasks) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task ID to mark as completed: ");
                    int idToComplete = scanner.nextInt();
                    taskService.markAsCompelted(idToComplete);
                    System.out.println(" Task marked as completed!");
                    break;

                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    taskService.deleteTasK(idToDelete);
                    System.out.println(" Task deleted!");
                    break;

                case 5:
                    System.out.println("Goodbye! ");
                    scanner.close();
                    return;

                default:
                    System.out.println(" Invalid option. Try again.");
            }
        }
    }
}