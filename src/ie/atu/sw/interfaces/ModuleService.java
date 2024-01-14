package ie.atu.sw.interfaces;

import java.util.List;
import ie.atu.sw.records.Examiner;
import ie.atu.sw.records.ModuleInfo;

/**
 * Interface defining the contract for services related to creating and managing academic modules.
 * This interface specifies methods for creating ModuleInfo instances with detailed attributes.
 */
public interface ModuleService {

    /**
     * Creates a ModuleInfo instance with the specified details.
     * This method is responsible for constructing a ModuleInfo object, encapsulating information
     * about an academic module, including its code, title, associated school and department, as well
     * as information about internal and external examiners.
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
     * @return An instance of ModuleInfo representing the created academic module.
     */
    ModuleInfo createModule(String programmeCode, String title, int year, 
                            String school, String department, 
                            String moduleCode, String moduleTitle, 
                            int registrations, List<Examiner> internalExaminers, 
                            List<Examiner> externalExaminers);
}
