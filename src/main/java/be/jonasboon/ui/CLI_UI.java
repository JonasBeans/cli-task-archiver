package be.jonasboon.ui;

import be.jonasboon.service.FileService;
import be.jonasboon.service.FolderService;

import java.util.Arrays;
import java.util.Scanner;

public class CLI_UI {

    private FileService fileService = new FileService();
    private FolderService folderService = new FolderService();

    public void mainApp(){
        Scanner scanner = new Scanner(System.in);
        do{
            chooseTask(scanner);
        } while (!askToTerminateProgramme(scanner));
    }

    private void chooseTask(Scanner scanner) {
        presentMenu();
        String choice = scanner.next();
        while(!isValidChoice(choice)){
            presentMenu();
            choice = scanner.next();
        }
        switch (choice){
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
                break;
        }
    }

    private boolean isValidChoice(String choice) {
        String[] validChoices = {"1", "2","3","4"};
        return Arrays.asList(validChoices).contains(choice);
    }

    private void presentMenu() {
        StringBuilder choices = new StringBuilder();
        choices.append("1) Create Text File\n");
        choices.append("2) Create Folder\n");
        choices.append("3) Create Screenshot Archive For The Day\n");
        choices.append("4) Exit\n");
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
