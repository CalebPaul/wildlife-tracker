import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDateTime;

public class EndangeredAnimalTest {
  private Animal sabertooth;
  private Animal jackelope;

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
  public void getName_instantiatesCorrectlyWithName_String() {
    assertEquals("tiger", sabertooth.getSpecies());
  }

}
