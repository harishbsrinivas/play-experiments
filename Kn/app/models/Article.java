package models;
import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Article extends Model{

  @Id
  public Long id;

  @Required
  public String title;

  public List<String> categories = new ArrayList<String>();
  public List<String> tags = new ArrayList<String>();

  @Required
  public User author;

  @Required
  public  Date createdDate;
  public Date modifiedDate;

  @Required
  public String body;
  public int viewCount;
  public int favCount;
  public int rating;

  public  void create(String title, List<String> categories, List<String> tags, User userName, String body){
    this.title = title;
    this.categories = categories;
    this.tags = tags;
    this.author = userName;
    this.body = body;
  }

  public void addArticle(){

  }

  public void viewArticle(){

  }

  public void deleteArticle(){

  }

  public void search(){

  }
}