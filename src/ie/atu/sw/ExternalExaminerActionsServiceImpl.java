package ie.atu.sw;

import ie.atu.sw.interfaces.ExternalExaminerActionsService;
import ie.atu.sw.records.ExternalExaminerActions;
import ie.atu.sw.enums.ExaminerAction;

/**
 * An implementation of the ExternalExaminerActionsService interface.
 * This class provides functionalities for creating ExternalExaminerActions objects,
 * encapsulating the actions taken by external examiners on examination papers.
 */
public class ExternalExaminerActionsServiceImpl implements ExternalExaminerActionsService {

    /**
     * Creates and returns an ExternalExaminerActions object based on the provided comment and decision.
     * This method is responsible for constructing an ExternalExaminerActions instance, which
     * represents the decision-making process of an external examiner, such as approval or rejection
     * of an examination paper, along with their comments.
     *
     * @param comment The comment provided by the external examiner on the examination paper.
     * @param decision The decision made by the external examiner, represented by the ExaminerAction enum.
     * @return A new ExternalExaminerActions object containing the specified comment and decision.
     */
    @Override
    public ExternalExaminerActions createExternalExaminerActions(String comment, ExaminerAction decision) {
        return new ExternalExaminerActions(comment, decision);
    }
}
