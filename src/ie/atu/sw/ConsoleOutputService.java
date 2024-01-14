package ie.atu.sw;

import ie.atu.sw.interfaces.OutputService;

/**
 * An implementation of the OutputService that outputs messages to the console.
 * This class provides a basic mechanism to display information to the standard output stream,
 * typically a console or command line interface.
 */
public class ConsoleOutputService implements OutputService {

    /**
     * Displays a given message to the console.
     * This method is responsible for outputting the specified message to the standard output stream.
     * 
     * @param message The message to be displayed.
     */
    @Override
    public void display(String message) {
        System.out.println(message);
    }
}
