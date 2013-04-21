package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

import java.util.List;

import play.data.validation.Constraints.*;


public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result addArticle() {
        return ok(addArticle.render(form(AddArticle.class)));
    }

    public static Result validate() {
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

    public static class AddArticle {

        @Required
        public String Title;
        public String Body;
        public List<String> categories;
        public List<String> tags;
        public User author;
    }

}
