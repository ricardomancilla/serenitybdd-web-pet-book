package co.com.devco.tasks;

import static co.com.devco.exceptions.UnknownFilter.UNKNOWN_FILTER;
import static co.com.devco.userinterfaces.PetBookPage.ALL_FILTER;
import static co.com.devco.userinterfaces.PetBookPage.GATO_FILTER;
import static co.com.devco.userinterfaces.PetBookPage.PERRO_FILTER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.devco.exceptions.UnknownFilter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ImageFilter implements Task {
    private String filter;

    public ImageFilter(String filter) {
        this.filter = filter;
    }

    public static Performable filterImage(String filtro) {
        return instrumented(ImageFilter.class, filtro);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(filter.equals("Perro")){
            actor.attemptsTo(
                Click.on(PERRO_FILTER)
                );}
        else if(filter.equals("Gato")){
            actor.attemptsTo(
                    Click.on(GATO_FILTER)
            );}
        else if(filter.equals("All")){
            actor.attemptsTo(
                     Click.on(ALL_FILTER)
            );}
        else{
            new UnknownFilter(UNKNOWN_FILTER);
        }
    }
}

