import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDateTime;

public class SafeAnimalTest {
  private SafeAnimal dog;
  private SafeAnimal cat;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void initialize() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);
    dog = new SafeAnimal("canine", 1);
    cat = new SafeAnimal("feline", 2);
  }

  @Test
  public void SafeAnimal_instantiatesCorrectly_true() {
    assertTrue(dog instanceof SafeAnimal);
  }

  @Test
  public void getSpecies_instantiatesCorrectlyWithSpecies_String() {
    assertEquals("canine", dog.getSpecies());
  }

  @Test
  public void save_assignsIdToSafeAnimal() {
    dog.save();
    cat = SafeAnimal.all().get(0);
    assertEquals(dog.getId(), cat.getId());
  }

  @Test
  public void save_savesSightingIdIntoDB_true() {
    Sighting testSight = new Sighting("Aragorn", "saw hobbits", "middle earth");
    testSight.save();
    SafeAnimal bird = new SafeAnimal("avian", testSight.getId());
    bird.save();
    SafeAnimal savedBird = SafeAnimal.find(bird.getId());
    assertEquals(savedBird.getSightingId(), testSight.getId());
  }

  @Test
  public void save_insertsSafeAnimalIntoDB_true() {
    dog.save();
    try(Connection con = DB.sql2o.open()) {
      cat = con.createQuery("SELECT * FROM animals WHERE species='canine'")
      .executeAndFetchFirst(SafeAnimal.class);
    }
    assertTrue(cat.equals(dog));
  }


}
