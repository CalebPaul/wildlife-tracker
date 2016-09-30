import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;
import java.text.DateFormat;
import java.sql.Timestamp;

public class SafeAnimal extends Animal implements DataBaseManagement {
  private String status;
  private String age;

  public static final String STATUS_HEALTHY = "healthy";
  public static final String STATUS_ILL = "ill";
  public static final String STATUS_OKAY = "okay";
  public static final String AGE_NEWBORN = "newborn";
  public static final String AGE_YOUNG = "young";
  public static final String AGE_ADULT = "adult";

  public SafeAnimal(String name, String notes, ) {

  }
}
