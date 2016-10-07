import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.sql.Timestamp;

public abstract class Animal {
  public int id;
  public String species;
  public String type;
  public int sighting_id;

  public int getId() {
    return id;
  }

  public String getSpecies(){
    return species;
  }

  public int getSightingId() {
    return sighting_id;
  }

  @Override
  public boolean equals(Object otherAnimal){
    if (!(otherAnimal instanceof Animal)) {
      return false;
    } else {
      Animal newAnimal = (Animal) otherAnimal;
      return this.species.equals(newAnimal.species) &&
             this.sighting_id == newAnimal.sighting_id;
    }
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO animals (species, type, sighting_id) VALUES (:species, :type, :sighting_id)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("species", this.species)
      .addParameter("type", this.type)
      .addParameter("sighting_id", this.sighting_id)
      .executeUpdate()
      .getKey();
    }
  }

}
