package pl.marta.quiz;

import java.io.File;

import java.io.IOException;
import java.util.List;

public class Main {

    public static final String PATH_TO_FILE_WITH_QUESTIONS = "C:\\Users\\Muszka\\quiz.txt";
    public static final String PATH_TO_FILE_WITH_RESULTS = "C:\\Users\\Muszka\\results.txt";

    public static void main(String[] args) throws IOException {

        File fileQuestions = new File(PATH_TO_FILE_WITH_QUESTIONS);
        File fileResults = new File(PATH_TO_FILE_WITH_RESULTS);

        MessagesForPlayer messagesForPlayer = new MessagesForPlayer();

        QuizOperations operations = new OperationsFromFile();

        List<Questions> questions = operations.questionsFromFileAsList(fileQuestions);

        boolean flag = true;
        while (flag) {

            Integer choice = messagesForPlayer.menu();

            switch (choice) {

                case 1:
                    messagesForPlayer.beforeTheStart();
                    int correctAnswers = 0;

//                    it doesn't run through this for

                    for (int i = 0; i < questions.size(); i++) {
                        boolean answer = messagesForPlayer.printQuestion(questions.get(i));

                        if (answer) {
                            messagesForPlayer.correctAnswer();
                            correctAnswers++;
                        } else {
                            messagesForPlayer.incorrectAnswer();
                        }
                    }

                    Result result = messagesForPlayer.resultAfterGame(correctAnswers, questions.size());

                    operations.saveResultInFile(fileResults, result);

                    break;

                case 2:

                    List<Result> results = operations.resultsFromFile(fileResults);

                    messagesForPlayer.resultsView(results);

                    break;

                case 3:

                    flag = false;

                    break;

                default:

                    System.out.println("Incorrect option");

                    break;
            }
        }

    }
}
