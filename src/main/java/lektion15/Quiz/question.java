package lektion15.Quiz;

public abstract class question {

    String question;
    String antwort;

    public question(String question, String antwort){
        this.question = question;
        this.antwort = antwort;
    }

    abstract void askQuestion();

    abstract boolean checkAnswer(String antwort);
}