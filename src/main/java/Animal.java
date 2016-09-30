import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.text.DateFormat;
import java.sql.Timestamp;

public class Animal {
  public String species;
  public int id;
  public int entry_id;

  public String getSpecies(){
    return species;
  }

  public int getId() {
    return id;
  }

  public int getEntryId() {
    return entry_id;
  }

  public String age() {
    return age;
  }

  public String getStatus() {
    return status;
  }


}
