import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDateTime;

public class TwoClassTest {
  private TwoClassTest one;
  private TwoClassTest two;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before //fix database name
  public void initialize() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);
    one = new TwoClassTest(//add arguments);
    two = new TwoClassTest(//add arguments);
  }

  @Test //fix details
  public void client_instantiatesCorrectly_true() {
    assertTrue(firstClient instanceof Client);
  }

  @Test //fix details
  public void getName_instantiatesCorrectlyWithName_String() {
    assertEquals("Bill", firstClient.getName());
  }

  @Test //fix details
  public void getCut_instantiatesCorrectlyWithCut_String() {
    assertEquals("Buzz", firstClient.getCut());
  }

}
