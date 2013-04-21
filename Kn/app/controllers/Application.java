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

    public static Result login() {
        return ok(login.render(form(Login.class)));
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

    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return redirect(
                routes.Application.index()
            );
        }
    }




    public static class AddArticle {

        @Required
        public static String Title;
        public static String Body;
        public static List<String> categories;
        public static List<String> tags;
        public static User author;
    }

    public static class  Login {

     @Required
     public static String email;
     public static String password;

     public static  Result validateLogin(){
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (User.authenticate(email, password) == null) {
              return "Invalid user or password";
            }
            return null;
     }




    }

}
