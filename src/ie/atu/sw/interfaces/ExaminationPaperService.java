package ie.atu.sw.interfaces;

import java.util.List;
import java.util.Set;
import ie.atu.sw.enums.ExaminationAllowance;
import ie.atu.sw.records.ExaminationPaper;
import ie.atu.sw.records.Question;

/**
 * Defines the contract for services that create and manage examination papers.
 * This interface specifies methods for creating examination papers with various parameters.
 */
public interface ExaminationPaperService {

    /**
     * Creates an examination paper with the specified allowances, questions, total number of questions, and required answers.
     * This method is responsible for assembling an examination paper that adheres to the defined criteria and rules.
     * 
     * @param allowances The set of specific allowances applicable to the examination (e.g., calculators, log tables).
     * @param questions The list of questions to be included in the examination paper.
     * @param totalNumberOfQuestions The total number of questions that should be present in the examination paper.
     * @param requiredAnswers The number of answers required from the examinee.
     * @return An instance of ExaminationPaper representing the created examination paper.
     */
    ExaminationPaper createExaminationPaper(Set<ExaminationAllowance> allowances, List<Question> questions, int totalNumberOfQuestions, int requiredAnswers);
}
