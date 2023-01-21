package be.jonasboon.command;

import be.jonasboon.service.FileService;

public class CreateScreenShotArchiveOfTheDayCommand implements Command {

    FileService fileService = new FileService();
    private String description = "Create Screenshot Archive For The Day";

    @Override
    public void execute() {
        fileService.createScreenShotArchiveOfTheDay();
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
