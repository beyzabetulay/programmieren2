package lektion15.Quiz;

import lektion15.Unternehmen.Abteilung;

public class mcquiz extends question {
    String[] choice;

    public mcquiz(String question, String[] choice, String antwort){
        super(question, antwort);
        this.choice = choice;
    }
    public void askQuestion(){
        System.out.println(question);
        for(String c : choice)
            System.out.println(c);
    }

    public boolean checkAnswer(String antwort){
        return this.antwort.equals(antwort);
    }
}
