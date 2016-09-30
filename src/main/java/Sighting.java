import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public class Sighting {
  private String ranger_name;
  private String notes;
  private Timestamp time_spotted;
  private int id;


  public Sighting(String name, String notes) {
    this.name = name;
    this.notes = notes;
  }

  public String getName() {
    return ranger_name;
  }

  public String getNotes() {
    return notes;
  }

  public Timestamp getTimeSpotted() {
    return time_spotted;
  }

  public int getId() {
    return id;
  }

}
