package ie.atu.sw;

import ie.atu.sw.interfaces.ExaminationRuleValidator;
import ie.atu.sw.records.ExaminationPaper;

/**
 * A validator that checks if the number of questions in an examination paper 
 * is within a specified range.
 * Implements the ExaminationRuleValidator interface.
 */
public class QuestionCountValidator implements ExaminationRuleValidator {
    private final int minQuestions;
    private final int maxQuestions;

    /**
     * Constructs a QuestionCountValidator with specified minimum and maximum question limits.
     *
     * @param minQuestions The minimum number of questions that the examination paper should have.
     * @param maxQuestions The maximum number of questions that the examination paper should have.
     */
    public QuestionCountValidator(int minQuestions, int maxQuestions) {
        this.minQuestions = minQuestions;
        this.maxQuestions = maxQuestions;
    }

    /**
     * Validates that the number of questions in the given examination paper is within the specified range.
     * 
     * @param paper The ExaminationPaper to be validated.
     * @return true if the number of questions is within the specified range; false otherwise.
     */
    @Override
    public boolean validate(ExaminationPaper paper) {
        int questionCount = paper.questions().size();
        return questionCount >= minQuestions && questionCount <= maxQuestions;
    }
}
