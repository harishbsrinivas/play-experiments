package pages;

import org.fluentlenium.core.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import components.*;

public class Dashboard extends FluentPage {
    public String getUrl() {
        return "/";
    }

    public void isAt() {
        assertThat(find("h1", withText("Dashboard"))).hasSize(1);
    }

    public Drawer drawer() {
        return Drawer.from(this);
    }
}