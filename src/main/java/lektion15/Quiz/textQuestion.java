package lektion15.Quiz;

public class textQuestion extends question{

    public textQuestion(String question, String antwort){
        super(question, antwort);
    }

    public void askQuestion(){
        System.out.println(question);
    }

    public boolean checkAnswer(String antwort){
        return this.antwort.equals(antwort);
    }
}