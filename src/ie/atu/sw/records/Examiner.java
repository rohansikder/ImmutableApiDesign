package ie.atu.sw.records;

import java.util.Objects;

/**
 * Represents an examiner, detailing their information.
 * This record is used to store information about both internal and external examiners.
 */
public record Examiner(
    String name,                // The name of the examiner
    String type,                // The type of the examiner (e.g., internal or external)
    String department,          // The department of the examiner
    String schoolOrInstitution, // The school or institution where the examiner works
    String email,               // The email address of the examiner
    int crn                     // The unique identifier (CRN) of the examiner
) {
    /**
     * Constructs an Examiner instance with specified details.
     * Validates the non-nullness and non-emptiness of the provided information.
     *
     * @param name The name of the examiner.
     * @param type The type of the examiner (internal or external).
     * @param department The department associated with the examiner.
     * @param schoolOrInstitution The school or institution of the examiner.
     * @param email The email address of the examiner.
     * @param crn The unique identifier of the examiner.
     * @throws NullPointerException if any of the string inputs are null.
     * @throws IllegalArgumentException if any of the string inputs are blank.
     */
    public Examiner {
        // Validate that none of the string inputs are null or empty
        Objects.requireNonNull(name, "Name must not be null.");
        Objects.requireNonNull(type, "Type must not be null.");
        Objects.requireNonNull(department, "Department must not be null.");
        Objects.requireNonNull(schoolOrInstitution, "School or Institution must not be null.");
        Objects.requireNonNull(email, "Email must not be null.");

        if (name.isBlank()) {
            throw new IllegalArgumentException("Name must not be blank.");
        }
        if (type.isBlank()) {
            throw new IllegalArgumentException("Type must not be blank.");
        }
        if (department.isBlank()) {
            throw new IllegalArgumentException("Department must not be blank.");
        }
        if (schoolOrInstitution.isBlank()) {
            throw new IllegalArgumentException("School or Institution must not be blank.");
        }
        if (email.isBlank()) {
            throw new IllegalArgumentException("Email must not be blank.");
        }
    }
}
