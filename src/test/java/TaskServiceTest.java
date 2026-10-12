import model.Task;
import org.junit.jupiter.api.Test;
import service.TaskService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTask(){
        // arrange
        List<Task> tasks = new ArrayList<>();
        TaskService service = new TaskService(tasks);
        Task task = new Task(1, "Test Task" , "Description");

        //Act
        service.addTask(task);

        //Assert
        assertEquals(1,service.getAllTasks().size());
        assertEquals("Test Task", service.getAllTasks().get(0).getTitle());
    }

    @Test
    public void testMarkAsCompeleted(){
       // Arrange
        List<Task> tasks = new ArrayList<>();
        TaskService service = new TaskService(tasks);
        Task task = new Task(1, "Test Task" , "Description");
        service.addTask(task);
        // Act
        service.markAsCompelted(1);
        //Assert
        assertTrue(service.getAllTasks().get(0).isCompleted());
    }

    @Test
    public void testDeleteTask(){
        List<Task> tasks = new ArrayList<>();
        TaskService service = new TaskService(tasks);
        service.addTask(new Task(1 , "Task 1", "Desc 1"));
        service.addTask(new Task(2, "Task 2 ", "desc 2"));

        service.deleteTasK(1);

        assertEquals(1, service.getAllTasks().size());
        assertEquals(2, service.getAllTasks().get(0).getId());
    }
}
