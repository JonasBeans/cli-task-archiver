package be.jonasboon.command;

import be.jonasboon.service.TaskArchiveService;

import java.awt.color.CMMException;

public class AddTaskToArchive implements Command {

    TaskArchiveService taskArchiveService = new TaskArchiveService();
    String description = "Add task to archive";

    @Override
    public void execute() {
        taskArchiveService.addTaskToArchive();
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
