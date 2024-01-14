package ie.atu.sw.interfaces;

import ie.atu.sw.enums.ExaminerAction;
import ie.atu.sw.records.ExternalExaminerActions;

/**
 * Interface defining the contract for services related to creating and managing external examiner actions.
 * This interface specifies methods for creating ExternalExaminerActions instances based on examiner's decisions and comments.
 */
public interface ExternalExaminerActionsService {

    /**
     * Creates an instance of ExternalExaminerActions with the specified comment and decision.
     * This method is responsible for encapsulating the decision-making process of an external examiner,
     * such as approval or rejection of an examination paper, along with their comments.
     *
     * @param comment A string containing the examiner's comment on the examination paper.
     * @param decision The decision made by the external examiner, represented by the ExaminerAction enum.
     * @return An instance of ExternalExaminerActions representing the actions taken by the external examiner.
     */
    ExternalExaminerActions createExternalExaminerActions(String comment, ExaminerAction decision);
}
