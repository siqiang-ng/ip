package duckie.command;

import duckie.Storage;
import duckie.task.TaskList;
import duckie.ui.Ui;

/**
 * Command to signify the exit of the chatbot.
 */
public class ByeCommand extends Command {
    /**
     * Checks if the Command is exiting.
     *
     * @return true.
     */
    @Override
    public boolean isExit() {
        return true;
    }

    /**
     * Displays the ending message and end the chatbot.
     *
     * @param tasks TaskList containing all the tasks.
     * @param ui Ui to interact with the users.
     * @param storage Storage to write to File.
     * @return String String to say goodbye.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return "Quack! Hope to see you again!";
    }
}
