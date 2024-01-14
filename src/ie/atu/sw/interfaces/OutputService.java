package ie.atu.sw.interfaces;

/**
 * Interface defining the contract for output display services.
 * This interface allows for flexible output display mechanisms, 
 * enabling the application to output messages to various targets such as console, GUI, or files.
 */
public interface OutputService {

    /**
     * Displays a given message.
     * Implementations of this method should handle the actual process of displaying
     * the message to the chosen output medium (e.g., console, graphical user interface).
     * 
     * @param message The message to be displayed.
     */
    void display(String message);
}
