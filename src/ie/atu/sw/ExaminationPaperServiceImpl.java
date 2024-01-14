package ie.atu.sw;

import java.util.List;
import java.util.Set;
import ie.atu.sw.enums.ExaminationAllowance;
import ie.atu.sw.interfaces.ExaminationPaperService;
import ie.atu.sw.records.ExaminationPaper;
import ie.atu.sw.records.Question;

/**
 * An implementation of the ExaminationPaperService interface.
 * This class provides functionalities for creating ExaminationPaper objects with specific allowances,
 * questions, and other examination details.
 */
public class ExaminationPaperServiceImpl implements ExaminationPaperService {

    /**
     * Creates and returns an ExaminationPaper object based on the provided parameters.
     * This method encapsulates the logic to construct a new ExaminationPaper instance,
     * calculating the total marks based on the provided questions and assembling all necessary
     * information into an ExaminationPaper object.
     *
     * @param allowances The set of specific allowances applicable to the examination.
     * @param questions The list of questions to be included in the examination paper.
     * @param totalNumberOfQuestions The total number of questions expected in the paper.
     * @param requiredAnswers The number of answers required from the examinee.
     * @return A new ExaminationPaper object containing the specified details.
     */
    @Override
    public ExaminationPaper createExaminationPaper(Set<ExaminationAllowance> allowances, 
                                                   List<Question> questions, 
                                                   int totalNumberOfQuestions, 
                                                   int requiredAnswers) {
        int totalMarks = calculateTotalMarks(questions);
        return new ExaminationPaper(allowances, questions, totalMarks, totalNumberOfQuestions, requiredAnswers);  
    }

    /**
     * Calculates the total marks for a list of questions.
     * This method sums up the marks of all parts of each question in the list.
     *
     * @param questions The list of questions whose total marks are to be calculated.
     * @return The total marks for the questions.
     */
    private int calculateTotalMarks(List<Question> questions) {
        int totalMarks = 0;
        for (Question question : questions) {
            for (int mark : question.marks()) {
                totalMarks += mark;
            }
        }
        return totalMarks;
    }
}
