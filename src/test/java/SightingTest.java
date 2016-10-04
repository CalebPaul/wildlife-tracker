import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class SightingTest {
  Sighting sight;
  Sighting sight2;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void setUp() {
    sight = new Sighting("Aragorn", "saw hobbits", "middle earth");
    sight2 = new Sighting("Walker", "saw boots", "Texas");
  }

  @Test
  public void sight_instantiatesCorrectly_true() {
    assertTrue(sight instanceof Sighting);
  }

  @Test
  public void getName_sightingInstantiatesWithName_String() {
    assertEquals("Aragorn", sight.getName());
  }

  @Test
  public void getNotes_sightingInstantiatesWithNotes_String() {
    assertEquals("saw hobbits", sight.getNotes());
  }

  @Test
  public void all_returnsAllInstancesOfSighting_true() {
    sight.save();
    sight2.save();
    System.out.println("all @ index 0 = " + Sighting.all().get(0).getName());
    System.out.println("all @ index 1 = " + Sighting.all().get(1).getName());
    assertEquals(true, Sighting.all().get(0).equals(sight));
    assertEquals(true, Sighting.all().get(1).equals(sight2));
  }

  @Test
  public void getLocation_personInstantiatesWithLocations_String() {
    assertEquals("middle earth", sight.getLocation());
  }

  @Test
  public void save_assignsIdToSighting() {
    sight.save();
    System.out.println("saveIdTest = " + Sighting.all().get(0));
    sight2 = Sighting.all().get(0);
    assertEquals(sight.getId(), sight2.getId());
  }

  @Test
  public void save_insertsSightingIntoDatabase_Sighting() {
    sight.save();
    //Sighting sight3 = null;
    try(Connection con = DB.sql2o.open()){
      sight2 = con.createQuery("SELECT * FROM sightings WHERE ranger_names='Aragorn'")
      .executeAndFetchFirst(Sighting.class);
    }
    System.out.println("saveDBInsertTest = " + Sighting.all().get(0));
    System.out.println("saveDBInsertTest * = " + sight);
    assertTrue(sight2.equals(sight));
  }

  @Test
  public void find_returnsPostWithSameId_secondPost() {
    sight.save();
    sight2.save();
    assertEquals(Sighting.find(sight2.getId()), sight2);
  }

  @Test
  public void equals_returnsTrueIfPropertiesAreSame_true() {
    Sighting sight3 = new Sighting("Aragorn", "saw hobbits", "middle earth");
    assertTrue(sight.equals(sight3));
  }
 }
