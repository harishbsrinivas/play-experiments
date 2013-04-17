package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result addArticle(Long Id) {
        return TODO;
    }

    public static Result viewArticle(Long Id) {
        return TODO;
    }

    public static Result editArticle(Long Id) {
        return TODO;
    }

    public static Result deleteArticle(Long Id) {
        return TODO;
    }

    public static Result search(String  term) {
        return TODO;
    }

}
