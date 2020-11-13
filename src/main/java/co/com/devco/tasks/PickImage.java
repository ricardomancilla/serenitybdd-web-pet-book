package co.com.devco.tasks;

import static co.com.devco.exceptions.UnknownImage.UNEXPECTED_IMAGE;
import static co.com.devco.userinterfaces.PetBookPage.GATO_1_IMAGE;
import static co.com.devco.userinterfaces.PetBookPage.IMAGE_DETAIL;
import static co.com.devco.userinterfaces.PetBookPage.PERRO_2_IMAGE;
import static co.com.devco.userinterfaces.PetBookPage.IMAGE_CONTAINER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.devco.exceptions.UnknownImage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

public class PickImage implements Task {
    private String img;

    public PickImage(String img) {
        this.img = img;
    }

    public static Performable pickImage(String img) {
        return instrumented(PickImage.class, img);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
         if(img.equals("perro")) {
            actor.attemptsTo(
                Click.on(PERRO_2_IMAGE),
                Ensure.that(IMAGE_DETAIL).containsElements(IMAGE_CONTAINER));
        }else if(img.equals("gato")){
            actor.attemptsTo(
                    Click.on(GATO_1_IMAGE),
                    Ensure.that(IMAGE_DETAIL).containsElements(IMAGE_CONTAINER));
        }else{
            new UnknownImage(UNEXPECTED_IMAGE);
        }
    }
}
