package ie.atu.sw.interfaces;

import ie.atu.sw.records.ExaminationPaper;

/**
 * Defines the contract for validators used in validating examination papers.
 * Implementations of this interface should provide specific validation logic 
 * to ensure that examination papers meet certain criteria.
 */
public interface ExaminationRuleValidator {

    /**
     * Validates an examination paper based on specific criteria.
     * Implementations of this method should check whether the given examination paper
     * adheres to a set of predefined rules and return true if it does, or false otherwise.
     * 
     * @param paper The ExaminationPaper to be validated.
     * @return true if the examination paper meets the validation criteria; false otherwise.
     */
    boolean validate(ExaminationPaper paper);
}
