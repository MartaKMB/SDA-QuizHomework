package pl.marta.quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperationsFromFile implements QuizOperations {

    @Override
    public List<Questions> questionsFromFileAsList(File fileQuestions) throws FileNotFoundException {
        List<Questions> questions = new ArrayList<>();

        Scanner sc = new Scanner(fileQuestions);

        while (sc.hasNext()) {
            Questions question = new Questions();

            question.setQuestion(sc.nextLine());

            List<String> answers = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                String answer = sc.nextLine();
                answers.add(answer);
            }

            question.setAnswers(answers);

            question.setCorrectAnswer(sc.nextLine());

            questions.add(question);
        }
        return questions;
    }

    @Override
    public void saveResultInFile(File fileResults, Result result) throws IOException {
        try (FileWriter fw = new FileWriter(fileResults, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            String resultAsString = result.toString();
            out.println(resultAsString);
        }
    }

    @Override
    public List<Result> resultsFromFile(File fileResults) throws FileNotFoundException {
        List<Result> results = new ArrayList<>();
        Scanner sc = new Scanner(fileResults);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");

            Result result = new Result();
            result.setName(split[0]);
            result.setAllAnswers(new Integer(split[1]));
            result.setCorrectAnswers(new Integer(split[2]));

            results.add(result);
        }
        return results;
    }
}
