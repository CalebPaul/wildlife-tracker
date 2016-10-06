import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public class Sighting {
  private int id;
  private String ranger_names;
  private String notes;
  private Timestamp times_spotted;
  private String locations;

  public Sighting(String ranger_names, String notes, String locations) {
    this.ranger_names = ranger_names;
    this.notes = notes;
    this.locations = locations;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return ranger_names;
  }

  public String getNotes() {
    return notes;
  }

  public String getLocation() {
    return locations;
  }

  public Timestamp getTimeSpotted() {
    return times_spotted;
  }

//refactor?
  // public Object getTimeSpotted() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT times_spotted FROM sightings WHERE id=:id";
  //     Object time = con.createQuery(sql)
  //                         .addParameter("id", id)
  //                         .executeAndFetchFirst(Sighting.class);
  //     return time;
  //   }
  // }

  @Override
  public boolean equals(Object otherSighting){
    if (!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.id  == newSighting.id &&
             this.ranger_names.equals(newSighting.ranger_names) &&
             this.notes.equals(newSighting.notes) &&
             this.locations.equals(newSighting.locations);
    }
  }

  public static List<Sighting> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings";
      return con.createQuery(sql)
                //.throwOnMappingFailure(false)
                .executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings where id=:id";
      Sighting sighting = con.createQuery(sql)
        .addParameter("id", id)
      //  .throwOnMappingFailure(false)
        .executeAndFetchFirst(Sighting.class);
      return sighting;
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (ranger_names, notes, times_spotted, locations) VALUES (:ranger_names, :notes, now(), :locations)";
      this.id = (int) con.createQuery(sql, true)
                         .addParameter("ranger_names", this.ranger_names)
                         .addParameter("notes", this.notes)
                         .addParameter("locations", this.locations)
                         //.throwOnMappingFailure(false)
                         .executeUpdate()
                         .getKey();
    }
  }

  public List<SafeAnimal> getSafeAnimals() {
    try(Connection con = DB.sql2o.open()) {
      String joinQuery = "SELECT * FROM animals WHERE sighting_id=:id AND type = 'safe'";
      return con.createQuery(joinQuery)
                .addParameter("id", this.getId())
                .executeAndFetch(SafeAnimal.class);
    }
  }

  public List<EndangeredAnimal> getEndangeredAnimals() {
    try(Connection con = DB.sql2o.open()) {
      String joinQuery = "SELECT * FROM animals WHERE sighting_id=:id AND type = 'endangered'";
      return con.createQuery(joinQuery)
                .addParameter("id", this.getId())
                .executeAndFetch(EndangeredAnimal.class);
    }
  }

}
