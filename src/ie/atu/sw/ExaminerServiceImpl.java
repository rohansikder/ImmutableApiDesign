package ie.atu.sw;

import ie.atu.sw.interfaces.ExaminerService;
import ie.atu.sw.records.Examiner;

/**
 * An implementation of the ExaminerService interface.
 * This class provides functionalities for creating Examiner objects with specified details.
 */
public class ExaminerServiceImpl implements ExaminerService {

    /**
     * Creates and returns an Examiner object based on the provided parameters.
     * This method encapsulates the logic to construct a new Examiner instance,
     * ensuring that all the necessary information for an examiner is properly assembled.
     *
     * @param name The name of the examiner.
     * @param type The type of the examiner (e.g., internal or external).
     * @param department The department associated with the examiner.
     * @param schoolOrInstitution The school or institution where the examiner works.
     * @param email The email address of the examiner.
     * @param crn The unique identifier (CRN) of the examiner.
     * @return A new Examiner object containing the specified information.
     */
    @Override
    public Examiner createExaminer(String name, String type, String department, 
                                   String schoolOrInstitution, String email, int crn) {
        return new Examiner(name, type, department, schoolOrInstitution, email, crn);
    }
}
