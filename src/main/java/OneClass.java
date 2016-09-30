import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.text.DateFormat;
import java.sql.Timestamp;

public abstract class OneClass {
  public String name;
  public String notes;
  public int id;
  public Timestamp lastSpotted;

  public static final int MIN_NUMBER_SPOTTED = 1;
  public static final int MAX_NUMBER_SPOTTED = 10;

  public String getName() {
    return name;
  }

  public String getNotes() {
    return notes;
  }
}
