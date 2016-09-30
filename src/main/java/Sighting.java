import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public class Sighting {
  private int id;
  private String ranger_name;
  private String notes;
  private Timestamp time_spotted;

  public Sighting(String ranger_name, String notes) {
    this.ranger_name = ranger_name;
    this.notes = notes;
  }

  public int getId() {
    return id;
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



}
