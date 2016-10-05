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
      model.put("safe", SafeAnimal.all());
      model.put("endangered", EndangeredAnimal.all());
      model.put("AnimalClass", Animal.class);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sighting/new", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      String threat = new String(request.queryParams("threat"));
      if (threat.equals('yes')) {
        //do some stuff
      } else if () {
        //do some other stuff
      } else {
        //catch exception
      }

      response.redirect("/");
      return null;
    });

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      //populate w model and logic
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      //populate w model and logic
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      //populate w model and logic
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
