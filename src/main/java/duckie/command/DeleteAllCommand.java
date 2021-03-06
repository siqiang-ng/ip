package duckie.command;

import java.util.ArrayList;

import duckie.Storage;
import duckie.exception.DuckieException;
import duckie.exception.DuckieNoListException;
import duckie.task.Task;
import duckie.task.TaskList;
import duckie.ui.Ui;

/**
 * Command to delete all tasks in the TaskList.
 */
public class DeleteAllCommand extends Command {
    /**
     * Deletes all Tasks in TaskList.
     *
     * @param tasks TaskList containing all the tasks.
     * @param ui Ui to interact with the users.
     * @param storage Storage to write to File.
     * @return String Message to indicate that all tasks in the list are cleared.
     * @throws DuckieException Throw FileError Exception.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DuckieException {
        ArrayList<Task> lst = tasks.getTaskList();
        if (lst.size() == 0) {
            throw new DuckieNoListException();
        }

        tasks.deleteAllTasks();
        try {
            storage.saveToFile(tasks.getTaskList());
        } catch (DuckieException e) {
            throw e;
        }

        return "Quack! All tasks are cleared in the list!";
    }
}
