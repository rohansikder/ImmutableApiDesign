package ie.atu.sw;

import java.util.List;
import ie.atu.sw.interfaces.ModuleService;
import ie.atu.sw.records.Examiner;
import ie.atu.sw.records.ModuleInfo;

/**
 * An implementation of the ModuleService interface.
 * This class provides functionalities for creating ModuleInfo objects,
 * encapsulating all relevant details about an academic module.
 */
public class ModuleServiceImpl implements ModuleService {

    /**
     * Creates and returns a ModuleInfo object based on the provided parameters.
     * This method is responsible for constructing a new ModuleInfo instance,
     * ensuring that all the necessary information for an academic module is properly assembled.
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
     * @return A new ModuleInfo object containing the specified module details.
     */
    @Override
    public ModuleInfo createModule(String programmeCode, String title, int year, 
                                   String school, String department, 
                                   String moduleCode, String moduleTitle, 
                                   int registrations, List<Examiner> internalExaminers, 
                                   List<Examiner> externalExaminers) {
        return new ModuleInfo(programmeCode, title, year, school, department, 
                              moduleCode, moduleTitle, registrations, 
                              internalExaminers, externalExaminers);
    }
}
