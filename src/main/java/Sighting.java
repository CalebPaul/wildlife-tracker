import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public class Sighting {
  private int id;
  private String ranger_name;
  private String notes;
  private Timestamp time_spotted;
  private String location;

  public Sighting(String ranger_name, String notes, String location) {
    this.ranger_name = ranger_name;
    this.notes = notes;
    this.location = location;
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

  // public Timestamp getTimeSpotted() {
  //   return time_spotted;
  // }

  public String getLocation() {
    return location;
  }

  @Override
  public boolean equals(Object otherSighting){
    if (!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.id  == newSighting.id &&
             this.ranger_name.equals(newSighting.ranger_name) &&
             this.notes.equals(newSighting.notes) &&
             this.location.equals(newSighting.location);
    }
  }

  public static List<Sighting> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings";
      return con.createQuery(sql)
                .throwOnMappingFailure(false)
                .executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings where id=:id";
      Sighting sighting = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Sighting.class);
      return sighting;
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (ranger_names, notes, times_spotted, locations) VALUES (:ranger_name, :notes, now(), :location)";
      this.id = (int) con.createQuery(sql, true)
                         .addParameter("ranger_name", this.ranger_name)
                         .addParameter("notes", this.notes)
                         .addParameter("location", this.location)
                         .executeUpdate()
                         .getKey();
    }
  }

}
