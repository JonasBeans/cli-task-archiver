package be.jonasboon.command;

import be.jonasboon.service.FileService;

public class CreateFileCommand implements Command {

    private FileService fileService = new FileService();
    private final String description = "Create Text File";

    @Override
    public void execute() {
        fileService.createTextFile();
    }

    public String getDescription() {
        return description;
    }
}
