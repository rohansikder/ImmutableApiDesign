package ie.atu.sw.records;

import ie.atu.sw.enums.ExaminationAllowance;
import java.util.List;
import java.util.Set;

/**
 * Represents an examination paper, containing a set of questions and specific allowances.
 * This record includes details such as total marks, number of questions, and required answers.
 */
public record ExaminationPaper(
    Set<ExaminationAllowance> allowances, // Allowances applicable to the examination (e.g., calculators, log tables)
    List<Question> questions,             // List of questions included in the examination paper
    int totalMarks,                       // Total marks for the examination paper
    int totalNumberOfQuestions,           // Total number of questions in the paper
    int requiredAnswers                   // Number of answers required from the examinee
) {
    /**
     * Constructs an ExaminationPaper instance with specified details.
     * Validates the integrity of the examination paper, including the number of questions, their parts, and the total marks.
     *
     * @param allowances The set of specific allowances applicable to the examination.
     * @param questions The list of questions included in the examination paper.
     * @param totalMarks The total marks for the examination paper.
     * @param totalNumberOfQuestions The total number of questions in the paper.
     * @param requiredAnswers The number of answers required from the examinee.
     * @throws IllegalArgumentException if the number of questions or their parts are not within the specified limits,
     *                                  if the total marks do not add up to the expected total,
     *                                  or if the number of questions does not match the specified total number of questions.
     */
    public ExaminationPaper {
        // Validate the total number of questions
        if (questions.size() < 2 || questions.size() > 6) {
            throw new IllegalArgumentException("Each paper must have between 2 and 6 questions.");
        }

        // Validate each question for the number of parts
        for (Question question : questions) {
            if (question.parts().size() < 1 || question.parts().size() > 5) {
                throw new IllegalArgumentException("Each question must have between 1 and 5 parts.");
            }
        }

        // Validate the total marks
        if (totalMarks != 100) {
            throw new IllegalArgumentException("The total marks for all questions should add up to 100.");
        }

        // Calculate and validate that all questions carry equal marks
        if (totalMarks % questions.size() != 0) {
            throw new IllegalArgumentException("All questions should carry equal marks.");
        }
        
        if (questions.size() != totalNumberOfQuestions) {
            throw new IllegalArgumentException("The actual number of questions does not match the specified total number of questions.");
        }
    }
}
