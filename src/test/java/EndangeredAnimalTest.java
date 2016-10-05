import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDateTime;

public class EndangeredAnimalTest {
  private EndangeredAnimal sabertooth;
  private EndangeredAnimal jackelope;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void initialize() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);
    sabertooth = new EndangeredAnimal("tiger", 1);
    jackelope = new EndangeredAnimal("rabbit", 2);
  }

  @Test
  public void endangeredAnimal_instantiatesCorrectly_true() {
    assertTrue(sabertooth instanceof EndangeredAnimal);
  }

  @Test
  public void EndangeredAnimal_instatiantesWithStatusEndangered_true() {
    assertEquals("endangered", sabertooth.getType());
  }

  @Test
  public void getSpecies_instantiatesCorrectlyWithSpecies_String() {
    assertEquals("tiger", sabertooth.getSpecies());
  }

  @Test
  public void save_assignsIdToEndangeredAnimal() {
    sabertooth.save();
    jackelope = EndangeredAnimal.all().get(0);
    assertEquals(sabertooth.getId(), jackelope.getId());
  }

  @Test
  public void save_insertsEndangeredAnimalIntoDB_true() {
    sabertooth.save();
    try(Connection con = DB.sql2o.open()) {
      jackelope = con.createQuery("SELECT * FROM animals WHERE species='tiger'")
      .executeAndFetchFirst(EndangeredAnimal.class);
    }
    assertTrue(jackelope.equals(sabertooth));
  }

  @Test
  public void setAge_assignsAgeToProperty_string() {
    sabertooth.save();
    sabertooth.setAge("young");
    assertEquals("young", sabertooth.getAge());
  }

  @Test
  public void setStatus_assignsStatusToProperty_string() {
    sabertooth.save();
    sabertooth.setStatus("healthy");
    assertEquals("healthy", sabertooth.getStatus());
  }

}
