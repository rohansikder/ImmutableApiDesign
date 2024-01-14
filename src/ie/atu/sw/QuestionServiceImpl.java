package ie.atu.sw;

import ie.atu.sw.interfaces.QuestionService;
import ie.atu.sw.records.Question;
import java.util.List;

/**
 * An implementation of the QuestionService interface.
 * This class provides the functionality to create Question objects with specified details.
 */
public class QuestionServiceImpl implements QuestionService {

    /**
     * Creates and returns a Question object based on the provided parameters.
     * This method encapsulates the logic to construct a new Question instance,
     * ensuring that all the necessary information for a question is properly assembled.
     *
     * @param number The number of the question.
     * @param parts A list of labels for each part of the question (e.g., "a", "b", "c").
     * @param marks A list of marks for each part, corresponding to the parts list.
     * @param content A list of content or descriptions for each part, corresponding to the parts list.
     * @return A new Question object containing the specified information.
     */
    @Override
    public Question createQuestion(int number, List<String> parts, List<Integer> marks, List<String> content) {
        return new Question(number, parts, marks, content);
    }
}
