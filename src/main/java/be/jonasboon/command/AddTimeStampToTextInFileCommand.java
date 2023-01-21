package be.jonasboon.command;

import be.jonasboon.service.TaskArchiveService;

public class AddTimeStampToTextInFileCommand implements Command {
    TaskArchiveService taskArchiveService = new TaskArchiveService();
    private String description = "Add time stamp to exiting file";

    @Override
    public void execute() {
        taskArchiveService.addTimeStampToTextInFile();
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
