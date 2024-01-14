package ie.atu.sw.interfaces;

import ie.atu.sw.records.Question;
import java.util.List;

/**
 * Interface defining the contract for services related to creating and managing questions for examination papers.
 * This interface specifies methods for creating Question instances with various details.
 */
public interface QuestionService {

    /**
     * Creates a Question instance with the specified details.
     * This method is responsible for constructing a Question object, ensuring that the provided information
     * for each part of the question is valid and consistent with the requirements of an examination question.
     *
     * @param number The number of the question in the examination.
     * @param parts A list of labels for each part of the question (e.g., "a", "b", "c").
     * @param marks A list of marks for each part, corresponding to the parts list.
     * @param content A list of content or descriptions for each part, corresponding to the parts list.
     * @return An instance of Question representing the constructed question.
     */
    Question createQuestion(int number, List<String> parts, List<Integer> marks, List<String> content);
}
