package lektion15.quiz;

public abstract class Question {

    String text;

    public Question(String text){
        this.text = text;
    }

    public abstract String generateQuestion();
}