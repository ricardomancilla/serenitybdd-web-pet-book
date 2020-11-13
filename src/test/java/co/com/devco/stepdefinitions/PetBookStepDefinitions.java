package co.com.devco.stepdefinitions;


import static co.com.devco.userinterfaces.PetBookPage.IMAGES_LIST;
import static co.com.devco.userinterfaces.PetBookPage.IMAGE_DETAIL;
import static co.com.devco.userinterfaces.PetBookPage.PETBOOK_HOME_PAGE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.devco.tasks.ImageFilter;
import co.com.devco.tasks.PickImage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementsLocated;

public class PetBookStepDefinitions {

    @When("^(.*) selects the \"(.*)\" filter$")
    public void gatoFilter(String actorName,String filter){
        theActorCalled(actorName).attemptsTo(
                Open.url(PETBOOK_HOME_PAGE),
                 ImageFilter.filterImage(filter)
        );
    }
    @Then("^The results should show \"(.*)\" elements$")
    public void resultadoSeleccion(int qty) {
        theActorInTheSpotlight().attemptsTo(
            Ensure.thatTheSetOf(ElementsLocated.by(IMAGES_LIST)).hasSize(2)
        );
    }

    @When("^(.*) selects the \"(.*)\" filter, then picks an image of \"(.*)\"$")
    public void filterThenSelect(String actorName, String filter, String img) {
        theActorCalled(actorName).attemptsTo(
                Open.url(PETBOOK_HOME_PAGE),
                ImageFilter.filterImage(filter),
                PickImage.pickImage(img)
        );
    }
    @Then("^The image should be displayed in real size$")
    public void resultadoSeleccion() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(IMAGE_DETAIL).isDisplayed()
        );
    }

    @And("^after that he changes to the \"(.*)\" filter$")
    public void perroFilter(String filter){
        theActorInTheSpotlight().attemptsTo(
                ImageFilter.filterImage(filter)
        );
    }
    @Then("^selects the \"(.*)\" filter, all images should be displayed$")
    public void allFilterWithSum(String filtro){
        theActorInTheSpotlight().attemptsTo(
            ImageFilter.filterImage(filtro),
            Ensure.thatTheSetOf(ElementsLocated.by(IMAGES_LIST)).hasSize(5)
        );
    }
}