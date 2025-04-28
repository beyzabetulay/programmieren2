package lektion15.quiz;

public class TextQuestion extends Question{

    public TextQuestion(String text){
        super(text);
    }

    @Override
    public String generateQuestion() {
        return text + "\nAntwort:\n\n";
    }
}