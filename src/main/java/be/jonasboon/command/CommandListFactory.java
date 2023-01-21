package be.jonasboon.command;

import java.util.ArrayList;
import java.util.List;

public class CommandListFactory {

    public static List<Command> getCommadList(){
        List<Command> commands = new ArrayList<>();

        Command createFileCommand = new CreateFileCommand();
        Command createFolder = new CreateFolderCommand();
        Command createScreenShotArchiveOfTheDayCommand = new CreateScreenShotArchiveOfTheDayCommand();
        Command openFileInWindowCommand = new OpenFileInWindowCommand();
        Command addTimeStampToTextInFileCommand = new AddTimeStampToTextInFileCommand();

        commands.add(createFileCommand);
        commands.add(createFolder);
        commands.add(createScreenShotArchiveOfTheDayCommand);
        commands.add(openFileInWindowCommand);
        commands.add(addTimeStampToTextInFileCommand);

       return commands;
    }
}
