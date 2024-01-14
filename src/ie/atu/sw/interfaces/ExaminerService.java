package ie.atu.sw.interfaces;

import ie.atu.sw.records.Examiner;

/**
 * Interface defining the contract for services related to creating and managing examiners.
 * This interface specifies methods for creating Examiner instances with various attributes.
 */
public interface ExaminerService {

    /**
     * Creates an Examiner instance with the specified details.
     * This method is responsible for constructing an Examiner object, ensuring all necessary validations
     * and business rules are applied to the data provided.
     *
     * @param name The name of the examiner.
     * @param type The type of the examiner (e.g., internal or external).
     * @param department The department associated with the examiner.
     * @param schoolOrInstitution The school or institution where the examiner works.
     * @param email The email address of the examiner.
     * @param crn The unique identifier (CRN) of the examiner.
     * @return An instance of Examiner representing the created examiner.
     */
    Examiner createExaminer(String name, String type, String department, String schoolOrInstitution, String email, int crn);
}
