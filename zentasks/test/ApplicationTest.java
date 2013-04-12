import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import models.Project;
import models.Task;

import com.avaje.ebean.Ebean;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/


public class ApplicationTest {

    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase(), fakeGlobal()));
        Ebean.save((List) Yaml.load("test-data.yml"));
    }

    @Test
    public void renderTemplate() {
        List<Project> p = new ArrayList<Project>();
        Project tmpProj = Project.create("Play1","Personal","harishbsrinivas@gmail.com");
        p.add(tmpProj);


        List<Task> t = new ArrayList<Task>();
        Task tmpTask = new Task();
        tmpTask.title = "fix unit tests";

        t.add(Task.create(tmpTask,tmpProj.id,"Personal"));

        Content html = views.html.index.render(p,t);
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("fix unit tests");
    }


}
