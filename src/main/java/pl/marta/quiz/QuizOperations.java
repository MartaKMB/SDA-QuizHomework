package pl.marta.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface QuizOperations {
    List<Questions> questionsFromFileAsList (File fileQuestions) throws FileNotFoundException;
    void saveResultInFile (File fileResults, Result result) throws IOException;
    List<Result> resultsFromFile (File fileResults) throws FileNotFoundException;
}
