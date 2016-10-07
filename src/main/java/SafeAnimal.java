import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public class SafeAnimal extends Animal {
  private String status;
  private String age;

  public static final String TYPE_SAFE = "safe";

  public SafeAnimal(String species, int sighting_id) {
    this.species = species;
    this.type = TYPE_SAFE;
    this.sighting_id = sighting_id;
  }

  public String getType() {
    return type;
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
