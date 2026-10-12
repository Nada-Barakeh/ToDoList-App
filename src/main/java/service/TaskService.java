package service;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private List<Task> tasks;

   public TaskService(List<Task> tasks){
       this.tasks = tasks;
   }
    public void addTask(Task task){
       tasks.add(task);
    }
    public ArrayList<Task> getAllTasks(){
       ArrayList result = new ArrayList<Task>();
       for(int i = 0; i < tasks.toArray().length ; i++){
           result.add(tasks.get(i));
       }
       return result;
    }
    public void markAsCompelted(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.get(i).setCompleted(true);
                return;
            }
        }
    }
    public void deleteTasK(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                return;
                }
            }
        }
    }