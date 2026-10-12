package model;

public class Task {
    private  int id;
    private String title;
    private String description;
    private boolean isCompleted;

    // Constructur
    public Task(int id , String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = false; // die neu Aufgabe ist noch nicht beherschd
    }
    public int getId(){
        return  id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
}
    public boolean isCompleted(){
        return isCompleted;
    }

    public  void setTitle(String title){
        this.title = title;
    }
    public void  setDescription(String description){
        this.description = description;
    }
    public void setCompleted(boolean completed){
        this.isCompleted = completed;
    }

    @Override
    public String toString() {
        String status = isCompleted() ? "[✔] Done" : "[ ] Pending";
        return status + " ID: " + getId() + " | " + getTitle() + " - " + getDescription();
    }
}

// oder auch so:
// public record Task(int id , String title, String descreption , boolean isCompleted){
