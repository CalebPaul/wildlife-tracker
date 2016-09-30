import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class SightingTest {
  Sighting testSighting;
  Sighting testSighting2;

  @Rule
  public Database database = new DatabaseRule();

  @Before
  public void setUp() {
    testSighting = new Sighting();
    testSighting2 = new Sighting();
  }

  @Test
  public void object_instantiatesCorrectly_true() {
    assertTrue(testSighting instanceof Sighting);
  }

  @Test
  public void getName_personInstantiatesWithName_String() {
    assertEquals("Henry", testPerson.getName());
  }

  @Test
  public void getNotes_personInstantiatesWithNotes_String() {
    assertEquals("henry@henry.com", testPerson.getEmail());
  }
}
