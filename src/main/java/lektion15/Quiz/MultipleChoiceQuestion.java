package lektion15.quiz;

public class MultipleChoiceQuestion extends Question{

    String[] answers;

    public MultipleChoiceQuestion(String text, String[] answers){
        super(text);
        this.answers = answers;
    }

    @Override
    public String generateQuestion() {
        String result = text + "\nAntwortmöglichkeiten:\n";
        char option = 'A';
        for(String answer : answers){
            result += option + ":" + answer + "\n";
            option++;
        }
        return result;
    }
}