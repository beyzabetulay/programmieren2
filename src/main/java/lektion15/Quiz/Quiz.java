package lektion15.quiz;


public class Quiz {

    Question[] questions;

    public Quiz(Question[] questions){
        this.questions = questions;
    }

    public void printQuiz(){
        for(int i = 0; i < questions.length; i++){
            System.out.println(questions[i].generateQuestion());
        }
    }
}