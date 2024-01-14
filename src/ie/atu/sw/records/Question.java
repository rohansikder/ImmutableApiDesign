package ie.atu.sw.records;

import java.util.List;
import java.util.Objects;

/**
 * Represents a question in an examination paper.
 * Each question consists of multiple parts, each with its own marks and content.
 */
public record Question(
    int number, // Question number
    List<String> parts, // Labels for each part of the question, e.g., "a", "b", "c"
    List<Integer> marks, // Marks allotted for each part
    List<String> content // Description or content of each part
) {
    /**
     * Constructs a Question instance with specified details.
     * Validates the integrity of the question data ensuring consistency in the number of parts, marks, and content.
     * 
     * @param number The number of the question in the examination paper.
     * @param parts A list of labels for each part of the question (e.g., "a", "b", "c").
     * @param marks A list of marks for each part, corresponding to the parts list.
     * @param content A list of content or descriptions for each part, corresponding to the parts list.
     * @throws NullPointerException if any of the lists (parts, marks, content) are null.
     * @throws IllegalArgumentException if the sizes of parts, marks, and content lists do not match,
     *                                  if parts are not between 1 and 5,
     *                                  if any part label is blank,
     *                                  if any marks entry is negative,
     *                                  or if any content entry is blank.
     */
    public Question {
        // Validate the inputs
        Objects.requireNonNull(parts, "Parts list must not be null.");
        Objects.requireNonNull(marks, "Marks list must not be null.");
        Objects.requireNonNull(content, "Content list must not be null.");

        // Ensure the parts, marks, and content lists have the same size
        if (parts.size() != marks.size() || parts.size() != content.size()) {
            throw new IllegalArgumentException("Parts, marks, and content lists must be of the same size.");
        }

        // Each question should have a minimum of one part and a maximum of 5 parts
        if (parts.size() < 1 || parts.size() > 5) {
            throw new IllegalArgumentException("Each question must have between 1 and 5 parts.");
        }

        // Validate each part's content and marks
        for (int i = 0; i < parts.size(); i++) {
            if (parts.get(i).isBlank()) {
                throw new IllegalArgumentException("Part labels cannot be blank.");
            }
            if (marks.get(i) == null || marks.get(i) < 0) {
                throw new IllegalArgumentException("Marks for each part must be non-negative.");
            }
            if (content.get(i).isBlank()) {
                throw new IllegalArgumentException("Content for each part cannot be blank.");
            }
        }
    }
}
