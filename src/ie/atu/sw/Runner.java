package ie.atu.sw;

import ie.atu.sw.enums.ExaminationAllowance;
import ie.atu.sw.enums.ExaminerAction;
import ie.atu.sw.interfaces.*;
import ie.atu.sw.records.*;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * The main class responsible for running the ATU system for approving examination papers.
 */
public class Runner {
    private static OutputService outputService;
    private static ExaminationPaperService examinationPaperService;
    private static ExternalExaminerActionsService externalExaminerActionsService;


    public static void main(String[] args) {
        initializeServices();

        // Hardcoded Example Implementation
        Examiner internalExaminer = new Examiner("John Healy", "Internal", "Computer Science & Applied Physics", "School of Science & Computing", "john.healy@atu.ie", 322);
        Examiner externalExaminer = new Examiner("Joe Bloggs", "External", "School of Computer Science", "National University of Ireland, Galway", "joe.bloggs@example.com", 123);

        ModuleInfo moduleInfo = new ModuleInfo(
            "GA_KSOAG_H08",
            "Bachelor of Science (Honours) in Software Development",
            2023,
            "SC",
            "COMP",
            "COMP06022",
            "Data Structures and Algorithms",
            81,
            List.of(internalExaminer),
            List.of(externalExaminer)
        );

        Set<ExaminationAllowance> allowances = EnumSet.of(
            ExaminationAllowance.LOG_TABLES, 
            ExaminationAllowance.GRAPH_PAPER
        );
        
        Question question1 = new Question(1, Arrays.asList("a", "b", "c", "d", "e"), Arrays.asList(10, 10, 10, 10, 10), Arrays.asList(
        	    "Explain Space Complexity (10 Marks)",
        	    "Explain Time Complexity (10 Marks)",
        	    "Explain Big-O notation: O(1) (10 Marks)",
        	    "Explain Big-O notation: O(log(n)) (10 Marks)",
        	    "Explain Big-O notation: O(n^2) (10 Marks)"));

        Question question2 = new Question(2, Arrays.asList("a", "b"), Arrays.asList(25, 25), Arrays.asList(
        	    "Describe Algorithm Efficiency (25 Marks)",
        	    "Explain Data Structures (25 Marks)"));
        
        List<Question> questions = Arrays.asList(question1, question2);

        int totalNumberOfQuestions = 2;
        int requiredAnswers = 1;

        // Create ExaminationPaper
        ExaminationPaper examinationPaper = examinationPaperService.createExaminationPaper(allowances, questions, totalNumberOfQuestions, requiredAnswers);

        // Validators
        QuestionCountValidator questionCountValidator = new QuestionCountValidator(2, 6);
        QuestionPartValidator questionPartValidator = new QuestionPartValidator(1, 5);

        // Validation
        if (!questionCountValidator.validate(examinationPaper)) {
            outputService.display("Validation Failed: The number of questions does not meet the required criteria.");
            return;
        }

        if (!questionPartValidator.validate(examinationPaper)) {
            outputService.display("Validation Failed: The number of parts in questions does not meet the required criteria.");
            return;
        }

        // External Examiner Actions
        ExternalExaminerActions externalActions = externalExaminerActionsService.createExternalExaminerActions("Excellent coverage of topics.", ExaminerAction.APPROVE);

        // Display using OutputService
        displaySystemInformation(moduleInfo, examinationPaper, allowances, totalNumberOfQuestions, requiredAnswers, externalActions);
    }

    private static void initializeServices() {
        outputService = new ConsoleOutputService();
        examinationPaperService = new ExaminationPaperServiceImpl();
        externalExaminerActionsService = new ExternalExaminerActionsServiceImpl();
    }

    private static void displaySystemInformation(ModuleInfo moduleInfo, ExaminationPaper examinationPaper, Set<ExaminationAllowance> allowances, int totalNumberOfQuestions, int requiredAnswers, ExternalExaminerActions externalActions) {
        outputService.display("************************************************************************");
        outputService.display("ATU SYSTEM FOR APPROVING EXAMINATION PAPERS");
        outputService.display("************************************************************************");
        outputService.display("Module Info\n------------------------------------------------------------------------");
        outputService.display(moduleInfo.toString());
        outputService.display("Internal Examiner\n------------------------------------------------------------------------");
        outputService.display(moduleInfo.internalExaminers().toString());
        outputService.display("External Examiner\n------------------------------------------------------------------------");
        outputService.display(moduleInfo.externalExaminers().toString());
        outputService.display("Examination Paper\n------------------------------------------------------------------------");
        outputService.display("Allow the following: " + allowances);
        outputService.display("Questions\n• Total Number of Questions: " + totalNumberOfQuestions + "\n• Required Answers: " + requiredAnswers);
        outputService.display(examinationPaper.toString());
        outputService.display("Rules\n------------------------------------------------------------------------");
        outputService.display("• Each paper should have a minimum of 2 questions and a maximum of 6\n• Each question should have a minimum of one part, labelled as (a), and a maximum of 5, labelled as (e).\n• All questions should carry equal marks\n• The total marks for all questions should add up to 100");
        outputService.display("External Examiner Actions\n------------------------------------------------------------------------");
        outputService.display(externalActions.toString());
        outputService.display("------------------------------------------------------------------------");
    }
}
