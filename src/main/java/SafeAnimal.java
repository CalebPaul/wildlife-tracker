import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public class SafeAnimal extends Animal {
  private String status;
  private String age;

  public static final String TYPE_SAFE = "safe";

  public static final String STATUS_HEALTHY = "healthy";
  public static final String STATUS_ILL = "ill";
  public static final String STATUS_OKAY = "okay";
  public static final String AGE_NEWBORN = "newborn";
  public static final String AGE_YOUNG = "young";
  public static final String AGE_ADULT = "adult";

  public SafeAnimal(String species, int entry_id) {
    this.species = species;
    this.entry_id = entry_id;
    this.type = TYPE_SAFE;
  }

  public String getStatus() {
    return status;
  }

  public String age() {
    return age;
  }

  public static List<SafeAnimal> all() {
    String sql = "SELECT * FROM animals WHERE type='safe'";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
                .throwOnMappingFailure(false)
                .executeAndFetch(SafeAnimal.class);
    }
  }

  public static SafeAnimal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id";
      SafeAnimal object = con.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(SafeAnimal.class);
      return object;
    }
  }

}
