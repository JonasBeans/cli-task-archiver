package be.jonasboon.command;

import be.jonasboon.service.FileService;
import be.jonasboon.service.TaskArchiveService;

public class OpenFileInWindowCommand implements Command {

    TaskArchiveService taskArchiveService = new TaskArchiveService();
    FileService fileService = new FileService();

    private final String description = "Open file";

    @Override
    public void execute() {
        taskArchiveService.openFileInWindow(fileService.askFileName());
    }

    @Override
    public String getDescription() {
        return description;
    }
}
