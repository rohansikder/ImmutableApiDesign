package ie.atu.sw.records;

import java.util.List;
import java.util.Objects;

/**
 * Represents the information of an academic module.
 * This record encapsulates details about a module, including its code, title, associated school and department,
 * as well as information about internal and external examiners.
 */
public record ModuleInfo(
    String programmeCode, // Code for the academic programme
    String title, // Title of the programme
    int year, // Academic year
    String school, // School offering the module
    String department, // Department responsible for the module
    String moduleCode, // Code for the module
    String moduleTitle, // Title of the module
    int registrations, // Number of registrations for the module
    List<Examiner> internalExaminers, // List of internal examiners
    List<Examiner> externalExaminers // List of external examiners
) {
    /**
     * Constructs a ModuleInfo instance with the specified details.
     * Validates the integrity and non-nullness of module information and examiner lists.
     * 
     * @param programmeCode The code of the academic programme.
     * @param title The title of the programme.
     * @param year The academic year of the module.
     * @param school The school offering the module.
     * @param department The department responsible for the module.
     * @param moduleCode The code for the module.
     * @param moduleTitle The title of the module.
     * @param registrations The number of registrations for the module.
     * @param internalExaminers A list of internal examiners for the module.
     * @param externalExaminers A list of external examiners for the module.
     * @throws NullPointerException if any of the string fields or lists are null.
     * @throws IllegalArgumentException if any of the string fields are blank, if year is not positive,
     *                                  if registrations are negative, or if examiner lists are empty.
     */
    public ModuleInfo {
        // Validate that the string fields are not null or empty
        Objects.requireNonNull(programmeCode, "Programme code must not be null.");
        Objects.requireNonNull(title, "Title must not be null.");
        Objects.requireNonNull(school, "School must not be null.");
        Objects.requireNonNull(department, "Department must not be null.");
        Objects.requireNonNull(moduleCode, "Module code must not be null.");
        Objects.requireNonNull(moduleTitle, "Module title must not be null.");
        Objects.requireNonNull(internalExaminers, "Internal examiners list must not be null.");
        Objects.requireNonNull(externalExaminers, "External examiners list must not be null.");

        if (programmeCode.isBlank()) throw new IllegalArgumentException("Programme code cannot be blank.");
        if (title.isBlank()) throw new IllegalArgumentException("Title cannot be blank.");
        if (school.isBlank()) throw new IllegalArgumentException("School cannot be blank.");
        if (department.isBlank()) throw new IllegalArgumentException("Department cannot be blank.");
        if (moduleCode.isBlank()) throw new IllegalArgumentException("ModuleCode cannot be blank.");
        if (moduleTitle.isBlank()) throw new IllegalArgumentException("ModuleTitle cannot be blank.");

        // Validate year and registrations
        if (year <= 0) throw new IllegalArgumentException("Year must be a positive number.");
        if (registrations < 0) throw new IllegalArgumentException("Registrations cannot be negative.");

        // Validate lists
        if (internalExaminers.isEmpty()) throw new IllegalArgumentException("There must be at least one internal examiner.");
        if (externalExaminers.isEmpty()) throw new IllegalArgumentException("There must be at least one external examiner.");
    }
}
