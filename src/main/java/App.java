import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    //Home Page
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("sightings", Sighting.all());
      model.put("safe", SafeAnimal.class);
      model.put("endangered", EndangeredAnimal.class);
      //model.put("animals", Animal.class);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sighting/new", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      String ranger_name = request.queryParams("ranger_name");
      String species = request.queryParams("species");
      String location = request.queryParams("locations");
      String notes = request.queryParams("notes");
      String threat = request.queryParams("threat");
      String status = request.queryParams("status");
      String age = request.queryParams("age");
      Sighting newSighting = new Sighting(ranger_name, notes, location);
      newSighting.save();

      if ( (ranger_name.equals("") || species.equals("") || location.equals("") || notes.equals("") || threat.equals("")) ||
          ( (threat.equals("yes")) && (status.equals("") || age.equals(""))) ) {
        response.redirect("/alert"); //replace with try and catch
      } if (threat.equals("yes")) {
            //newSighting.save();
            EndangeredAnimal newAnimal = new EndangeredAnimal(species, newSighting.getId());
            newAnimal.save();
            newAnimal.setAge(age);
            newAnimal.setStatus(status);
          } if (threat.equals("no")) {
            //newSighting.save();
            Animal newAnimal = new SafeAnimal(species, newSighting.getId());
            newAnimal.save();
          }

      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/alert", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      //populate w model and logic
      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<>();
    //   //populate w model and logic
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<>();
    //   //populate w model and logic
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }
}
