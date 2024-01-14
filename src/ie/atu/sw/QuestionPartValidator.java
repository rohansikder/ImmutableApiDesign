package ie.atu.sw;

import ie.atu.sw.interfaces.ExaminationRuleValidator;
import ie.atu.sw.records.ExaminationPaper;
import ie.atu.sw.records.Question;

/**
 * A validator that checks if each question in an examination paper has an appropriate number of parts.
 * Implements the ExaminationRuleValidator interface.
 */
public class QuestionPartValidator implements ExaminationRuleValidator {
    private final int minParts;
    private final int maxParts;

    /**
     * Constructs a QuestionPartValidator with specified minimum and maximum part limits for each question.
     *
     * @param minParts The minimum number of parts that each question should have.
     * @param maxParts The maximum number of parts that each question should have.
     */
    public QuestionPartValidator(int minParts, int maxParts) {
        this.minParts = minParts;
        this.maxParts = maxParts;
    }

    /**
     * Validates that each question in the given examination paper has an appropriate number of parts.
     * 
     * @param paper The ExaminationPaper to be validated.
     * @return true if all questions have an appropriate number of parts; false otherwise.
     */
    @Override
    public boolean validate(ExaminationPaper paper) {
        for (Question question : paper.questions()) {
            if (question.parts().size() < minParts || question.parts().size() > maxParts) {
                return false;
            }
        }
        return true;
    }
}
