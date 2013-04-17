package models;
import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Article{

  @Id
  public Long id;

  @Required
  public String title;

  public List<String> categories;
  public List<String> tags;

  @Required
  public String author;

  @Required
  public String createdDate;
  public String modifiedDate;

  @Required
  public String body;
  public int viewCount;
  public int favCount;
  public int rating;

  public static void create(){

  }

  public static void addArticle(){

  }

  public static void viewArticle(){

  }

  public static void deleteArticle(){

  }

  public static void search(){

  }
}