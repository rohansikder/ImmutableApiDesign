package ie.atu.sw.enums;

/**
 * Enumerates the different types of allowances that can be permitted in an examination setting.
 * This enum defines various materials or tools that may be allowed for use during an examination,
 * such as calculators, tables, or specific types of paper.
 */
public enum ExaminationAllowance {
    LOG_TABLES("Log Tables"),
    ACTUARIAL_TABLES("Actuarial Tables"),
    STATISTICAL_TABLES("Statistical Tables"),
    GRAPH_PAPER("Graph Paper"),
    DICTIONARIES("Dictionaries"),
    ATTACHED_ANSWER_SHEET("Attached Answer Sheet"),
    THERMODYNAMIC_TABLES("Thermodynamic Tables"),
    NON_PROGRAMMABLE_CALCULATORS_ALLOWED("Non-Programmable Calculators Allowed"),
    RATE_TABLES("Rate Tables");

    private final String description;

    /**
     * Constructs an ExaminationAllowance instance with a specified description.
     * 
     * @param description The descriptive name of the examination allowance.
     */
    ExaminationAllowance(String description) {
        this.description = description;
    }

    /**
     * Retrieves the description of the examination allowance.
     * 
     * @return The descriptive name of the allowance.
     */
    public String getDescription() {
        return description;
    }
}
