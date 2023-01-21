package be.jonasboon.ui;

import be.jonasboon.service.FileService;
import be.jonasboon.service.FolderService;
import be.jonasboon.service.TaskArchiveService;

import java.util.Scanner;

import static be.jonasboon.constants.UIContstants.UI_POSSIBLE_CHOICES;

public class CLI_UI {

    private FileService fileService = new FileService();
    private FolderService folderService = new FolderService();
    private TaskArchiveService taskArchiveService = new TaskArchiveService();

    public void mainApp(){
        Scanner scanner = new Scanner(System.in);
        do{
            chooseTask(scanner);
        } while (!askToTerminateProgramme(scanner));
    }

    private void chooseTask(Scanner scanner) {
        presentMenu();
        switch (getChoice(scanner)){
            case "1":
                fileService.createTextFile();
                break;
            case "2":
                folderService.creatFolder();
                break;
            case "3":
                fileService.createScreenShotArchiveOfTheDay();
                break;
            case "4":
                taskArchiveService.openFileInWindow();
            case "5":
                taskArchiveService.addTimeStampToTextInFile();
            case "6":
                break;
        }
    }

    private String getChoice(Scanner scanner) {
        String choice = scanner.next();
        while(!isValidChoice(choice)){
            presentMenu();
            choice = scanner.next();
        }
        return choice;
    }

    private boolean isValidChoice(String choice) {
        return UI_POSSIBLE_CHOICES.contains(choice);
    }

    private void presentMenu() {
        StringBuilder choices = new StringBuilder();
        choices.append("1) Create Text File\n");
        choices.append("2) Create Folder\n");
        choices.append("3) Create Screenshot Archive For The Day\n");
        choices.append("4) Open file\n");
        choices.append("5) Add time stamp to exiting file\n");
        choices.append("6) Exit\n");
        choices.append("> ");
        System.out.print(choices);
    }

    private boolean askToTerminateProgramme(Scanner scanner){
        String terminateMessage = "Do you want to terminate programme (y/n): ";

        System.out.print(terminateMessage);
        String terminate =  scanner.next();
        while(!"y".equals(terminate) && !"n".equals(terminate)) {
            System.out.print(terminateMessage);
            terminate = scanner.next();
        }
        return "y".equals(terminate);
    }
}
