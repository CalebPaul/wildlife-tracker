// import org.sql2o.*;
// import org.junit.*;
// import static org.junit.Assert.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Arrays;
// import java.time.LocalDateTime;
//
// public class EndangeredAnimal {
//   private EndangeredAnimal sabertooth;
//   private EndangeredAnimal jackelope;
//
//   @Rule
//   public DatabaseRule database = new DatabaseRule();
//
//   @Before
//   public void initialize() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);
//     sabertooth = new EndangeredAnimal();//add arguments
//     jackelope = new EndangeredAnimal();//add arguments
//   }
//
//   @Test //fix details
//   public void client_instantiatesCorrectly_true() {
//     assertTrue(sabertooth instanceof EndangeredAnimal);
//   }
//
//   @Test //fix details
//   public void getName_instantiatesCorrectlyWithName_String() {
//     assertEquals("Bill", sabertooth.getName());
//   }
//
//   @Test //fix details
//   public void getCut_instantiatesCorrectlyWithCut_String() {
//     assertEquals("Buzz", sabertooth.getCut());
//   }
//
// }
