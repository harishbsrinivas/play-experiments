package views;

import org.junit.*;

import play.test.*;
import static play.test.Helpers.*;

import org.fluentlenium.core.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import com.google.common.base.*;

import pages.*;
import components.*;

public class DrawerTest extends WithBrowser {

    public Drawer drawer;
    public Dashboard dashboard;

    @Before
    public void setUp() {
        start();
        Login login = browser.createPage(Login.class);
        login.go();
        login.login("harishbsrinivas@gmail.com", "supersecretpassword");
        drawer = browser.createPage(Dashboard.class).drawer();
    }

    @Ignore
       public void newProject() throws Exception {
           drawer.group("Personal").newProject();
           dashboard.await().until(drawer.group("Tutorials").hasProject("New project"));
       }

   @Ignore
       public void renameProject() throws Exception {
           drawer.group("Tutorials").project("New project").rename("Confidential");
           dashboard.await().until(Predicates.not(drawer.group("Personal").hasProject("Private")));
           dashboard.await().until(drawer.group("Personal").hasProject("Confidential"));
           dashboard.await().until(Predicates.not(drawer.group("Personal").project("Confidential").isInEdit()));
       }
}