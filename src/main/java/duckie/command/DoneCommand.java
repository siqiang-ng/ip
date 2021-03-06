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
 * Command to mark a task as Done.
 */
public class DoneCommand extends Command {
    private int ind;

    /**
     * Instantiates the DoneCommand.
     *
     * @param ind Index of the Task in TaskList to be marked done.
     */
    public DoneCommand(int ind) {
        this.ind = ind;
    }

    /**
     * Marks a required Task as done.
     *
     * @param tasks TaskList containing all the tasks.
     * @param ui Ui to interact with the users.
     * @param storage Storage to write to File.
     * @return output Display the Task that is being marked done.
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

        tasks.markTaskDone(this.ind - 1);
        Task task = tasks.getTaskList().get(this.ind - 1);
        try {
            storage.saveToFile(tasks.getTaskList());
        } catch (DuckieException e) {
            throw e;
        }

        String output = "Quack! I've marked this task as done: \n";
        output += task.toString();
        return output;
    }
}
