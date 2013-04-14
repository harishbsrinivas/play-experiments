package pages;

import org.fluentlenium.core.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import components.*;
import controllers.*;

public class Login extends FluentPage {
    public String getUrl() {
        return routes.Application.login().url();
    }

    public void isAt() {
        assertThat(find("h1", withText("Sign in"))).hasSize(1);
    }

    public void login(String email, String password) {
        fill("input").with(email, password);
        click("button");
    }
}