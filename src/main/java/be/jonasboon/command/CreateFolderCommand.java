package be.jonasboon.command;

import be.jonasboon.service.FolderService;

public class CreateFolderCommand implements Command {
    FolderService folderService = new FolderService();
    private String description = "Create Folder";

    @Override
    public void execute() {
        folderService.creatFolder();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
