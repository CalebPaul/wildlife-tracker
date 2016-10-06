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
      model.put("safeAnimals", SafeAnimal.class);
      model.put("endangeredAnimals", EndangeredAnimal.class);
      //model.put("animals", Animal.class);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //post page, redirects to homepage
    post("/sighting/new", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      String ranger_name = request.queryParams("ranger_name");
      String species = request.queryParams("species");
      String location = request.queryParams("locations");
      String notes = request.queryParams("notes");
      String threat = request.queryParams("threat");
      String status = request.queryParams("status");
      String age = request.queryParams("age");

      if (request.queryParams("ranger_name").equals("") ||
          request.queryParams("species").equals("") ||
          request.queryParams("locations").equals("") ||
          request.queryParams("notes").equals("")){
        response.redirect("/alert");
      } else {

      Sighting newSighting = new Sighting(ranger_name, notes, location);
      newSighting.save();
      EndangeredAnimal newAnimal = new EndangeredAnimal(species, newSighting.getId());
      SafeAnimal newSafeAnimal = new SafeAnimal(species, newSighting.getId());

      if (threat.equals("yes")) {

       if (newAnimal.completeSetAge(age) && newAnimal.completeSetStatus(status)) {

              newAnimal.save();
              newAnimal.setAge(age);
              newAnimal.setStatus(status);
            } else if ((!threat.equals("yes")) && (!threat.equals("no")) ){
              response.redirect("/alert1");
            }
          }

      if (threat.equals("no")) {
          //newSighting.save();
          newSafeAnimal.save();
          } else {
            response.redirect("/alert");
          }
        }

        response.redirect("/");
        return null;
      });

    //error page, redirects to homepage
    get("/alert", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("template", "templates/alert.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //error page, redirects to homepage
    get("/alert1", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("template", "templates/alert1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
