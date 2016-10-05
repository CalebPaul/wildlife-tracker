import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public class EndangeredAnimal extends Animal {
  private String status;
  private String age;

  public static final String TYPE_ENDANGERED = "endangered";

  public static final String STATUS_HEALTHY = "healthy";
  public static final String STATUS_ILL = "ill";
  public static final String STATUS_OKAY = "okay";
  
  public static final String AGE_NEWBORN = "newborn";
  public static final String AGE_YOUNG = "young";
  public static final String AGE_ADULT = "adult";

  public EndangeredAnimal(String species, int entry_id) {
    this.species = species;
    this.entry_id = entry_id;
    this.type = TYPE_ENDANGERED;
  }

  public String getStatus() {
    return status;
  }

  public String age() {
    return age;
  }

  public static List<EndangeredAnimal> all() {
    String sql = "SELECT * FROM animals WHERE type='endangered'";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
                .throwOnMappingFailure(false)
                .executeAndFetch(EndangeredAnimal.class);
    }
  }

  public static EndangeredAnimal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id";
      EndangeredAnimal object = con.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(EndangeredAnimal.class);
      return object;
    }
  }

}
