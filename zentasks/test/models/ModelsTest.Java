package models;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createAndRetrieveUser() {
        new User("harishbsrinivas@gmail.com", "hari", "supersecretpassword").save();
        User hari = User.find.where().eq("email", "harishbsrinivas@gmail.com").findUnique();
        assertNotNull(hari);
        assertEquals("hari", hari.name);
    }

    @Test
    public void tryAuthenticateUser() {
        new User("harishbsrinivas@gmail.com", "hari", "supersecretpassword").save();
        
        assertNotNull(User.authenticate("harishbsrinivas@gmail.com", "supersecretpassword"));
        assertNull(User.authenticate("harishbsrinivas@gmail.com", "badpassword"));
        assertNull(User.authenticate("tom@gmail.com", "secret"));
    }

    @Test
    public void findProjectsInvolving() {
        new User("harishbsrinivas@gmail.com", "hari", "supersecretpassword").save();
        new User("girishsrinivasamurthy@gmail.com", "giri", "secret").save();

        Project.create("Play 2", "play", "harishbsrinivas@gmail.com");
        Project.create("Play 1", "play", "girishsrinivasamurthy@gmail.com");

        List<Project> results = Project.findInvolving("harishbsrinivas@gmail.com");
        assertEquals(1, results.size());
        assertEquals("Play 2", results.get(0).name);
    }

     @Test
    public void findTodoTasksInvolving() {
        User hari = new User("harishbsrinivas@gmail.com", "hari", "supersecretpassword");
        hari.save();

        Project project = Project.create("Play 2", "play", "harishbsrinivas@gmail.com");
        Task t1 = new Task();
        t1.title = "Write tutorial";
        t1.assignedTo = hari;
        t1.done = true;
        t1.save();

        Task t2 = new Task();
        t2.title = "Release next version";
        t2.project = project;
        t2.save();

        List<Task> results = Task.findTodoInvolving("harishbsrinivas@gmail.com");
        assertEquals(1, results.size());
        assertEquals("Release next version", results.get(0).title);
    }
}