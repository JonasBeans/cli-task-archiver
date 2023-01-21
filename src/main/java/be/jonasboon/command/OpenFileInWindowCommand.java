package be.jonasboon.command;

import be.jonasboon.service.TaskArchiveService;

public class OpenFileInWindowCommand implements Command {

    TaskArchiveService taskArchiveService = new TaskArchiveService();

    private final String description = "Open file";

    @Override
    public void execute() {
        taskArchiveService.openFileInWindow();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
