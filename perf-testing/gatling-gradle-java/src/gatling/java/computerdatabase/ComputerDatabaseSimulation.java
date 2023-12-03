package computerdatabase;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class ComputerDatabaseSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://computer-database.gatling.io")
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/118.0");
  
  private Map<CharSequence, String> headers_1 = Map.of("Origin", "http://computer-database.gatling.io");


  private ScenarioBuilder scn = scenario("ComputerDatabaseSimulation")
    .exec(
      http("request_0")
        .get("/computers/381")
    )
    .pause(2)
    .exec(
      http("request_1")
        .post("/computers/381")
        .headers(headers_1)
        .formParam("name", "ACE")
        .formParam("introduced", "")
        .formParam("discontinued", "")
        .formParam("company", "")
    )
    .pause(4)
    .exec(
      http("request_2")
        .get("/computers?f=fg")
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
