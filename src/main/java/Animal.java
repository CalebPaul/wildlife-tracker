import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.text.DateFormat;
import java.sql.Timestamp;

public abstract class Animal {

  public int id;
  public String age;



  public int getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }

  public String age() {
    return age;
  }
}
