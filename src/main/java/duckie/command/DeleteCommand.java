package duckie.command;

import java.util.ArrayList;

import duckie.Storage;
import duckie.exception.DuckieException;
import duckie.exception.DuckieNoIndexException;
import duckie.exception.DuckieNoListException;
import duckie.task.Task;
import duckie.task.TaskList;
import duckie.ui.Ui;

/**
 * Command to delete a task in the TaskList.
 */
public class DeleteCommand extends Command {
    private int ind;

    /**
     * Instantiates the DeleteCommand.
     *
     * @param ind Index of the Task in TaskList to be deleted.
     */
    public DeleteCommand(int ind) {
        this.ind = ind;
    }

    /**
     * Deletes the required Task.
     *
     * @param tasks TaskList containing all the tasks.
     * @param ui Ui to interact with the users.
     * @param storage Storage to write to File.
     * @return output Display deleted task.
     * @throws DuckieException Throw File Error Exception.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DuckieException {
        ArrayList<Task> lst = tasks.getTaskList();
        if (lst.size() == 0) {
            throw new DuckieNoListException();
        }

        if (lst.size() < ind) {
            throw new DuckieNoIndexException();
        }

        Task task = lst.get(this.ind - 1);
        tasks.deleteTask(ind - 1);
        try {
            storage.saveToFile(tasks.getTaskList());
        } catch (DuckieException e) {
            throw e;
        }

        String output = "Quack! I've remove this task: \n";
        output += task.toString();
        return output;
    }
}
