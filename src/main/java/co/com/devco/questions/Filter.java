package co.com.devco.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;

import static co.com.devco.userinterfaces.PetBookPage.PERRO_FILTER;

public class Filter implements Question<Boolean> {
    private final String filter;

    public Filter(String filter){
        this.filter = filter;
    }

    public static Filter is(String filtro){
        return new Filter(filtro);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String selectedFilter = Attribute.of(PERRO_FILTER).named("perro").toString();
        return selectedFilter.contains(filter);
    }
}
