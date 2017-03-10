package pl.marta.quiz;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class MessagesForPlayer {

    public Integer menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Start");
        System.out.println("2. Results");
        System.out.println("3. End");

        Integer choice = sc.nextInt();
        return choice;
    }

    public void beforeTheStart() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Let's start the game! Press /enter/");

        sc.nextLine();
    }

    public boolean printQuestion (Questions question) {

        System.out.println("Question: ");
        System.out.println(question.getQuestion());

        System.out.println("Answers: ");

        List<String> answers = question.getAnswers();

//        from this place not all is for me clear:

        char prefix = 'a';

//        Consumer interface represents an operation that accepts a single input argument and returns no result.

        answers.forEach(new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        answers.forEach(e -> System.out.println(e));

        for (int i = 0; i < answers.size(); i++) {
            System.out.println((char) (prefix +1) + ". " + answers.get(i));
        }

        System.out.println("Enter your answer: ");

        Scanner sc = new Scanner(System.in);

        String playerAnswer = sc.nextLine();

        if (playerAnswer.equals(question.getCorrectAnswer())) {
            return true;
        } else {
            return false;
        }

    }


    public void correctAnswer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Correct! Press /enter/ for next question");
        sc.nextLine();
    }

    public void incorrectAnswer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Incorrect. Press /enter/ for next question");
        sc.nextLine();
    }

    public Result resultAfterGame(int correctAnswers, int allAnswers) {
        System.out.println("Your result: " + correctAnswers + allAnswers);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        Result result = new Result();
        result.setName(name);
        result.setCorrectAnswers(correctAnswers);
        result.setAllAnswers(allAnswers);

        return result;
    }

    public void resultsView (List<Result> results) {
        System.out.println("Name:\tResult:\tQuestions:");
        System.out.println("________________________________________");

        for(Result result : results) {
            System.out.println(result.getName() + "\t\t" + result.getCorrectAnswers() + "\t\t" + result.getAllAnswers());
        }

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        /*
//      this is not clear for me:
        List<String> strings = Arrays.asList("ad", "ASd");
        strings.forEach(e -> System.out.println(e));
        */


    }
}
