package lektion15.quiz;

public class Main {

    public static void main(String[] args){
        Question question = new TextQuestion("Was ist die Hauptstadt von Deutschland?");

        String[] s1  = {"4", "2", "1", "0"};
        Question question2 = new MultipleChoiceQuestion("Wie viele Protonen hat ein Wasserstoff-Atom?", s1);

        Question[] questions = {question, question2};
        Quiz quiz = new Quiz(questions);

        quiz.printQuiz();
    }
}