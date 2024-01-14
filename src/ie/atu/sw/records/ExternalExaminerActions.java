package ie.atu.sw.records;

import ie.atu.sw.enums.ExaminerAction;

/**
 * Represents actions taken by an external examiner on an examination paper.
 * This record encapsulates the examiner's comment and their decision regarding the examination.
 */
public record ExternalExaminerActions(
    String comment, // The comment provided by the external examiner
    ExaminerAction decision // The decision made by the external examiner (e.g., APPROVE, REJECT)
) {}
