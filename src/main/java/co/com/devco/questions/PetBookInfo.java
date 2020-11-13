package co.com.devco.questions;

import static co.com.devco.userinterfaces.PetBookPage.PETBOOK_TITLE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class PetBookInfo implements Question<Boolean> {
    private final String expectedTitle;

    public PetBookInfo(String titulo){
        this.expectedTitle = titulo;
    }

    public static PetBookInfo is(String titulo){
        return new PetBookInfo(titulo);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualTitle= Text.of(PETBOOK_TITLE).viewedBy(actor).asString();
       return actualTitle.equals(expectedTitle);
    }
}
