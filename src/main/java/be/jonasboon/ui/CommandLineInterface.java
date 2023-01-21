package be.jonasboon.ui;

import be.jonasboon.command.Command;
import be.jonasboon.command.CommandListFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

public class CommandLineInterface {
     List<Command> commadList = CommandListFactory.getCommadList();
     Integer indexAdjustment = 1;


    public void mainApp(){
        Scanner scanner = new Scanner(System.in);
        do{
            chooseTask(scanner);
        } while (!askToTerminateProgramme(scanner));
    }

    private void chooseTask(Scanner scanner) {
        presentMenu();
        Integer choice = getChoice(scanner);
        commadList.get(choice).execute();
    }

    private Integer getChoice(Scanner scanner) {
        String choice = scanner.next();
        while(!isValidChoice(choice)){
            presentMenu();
            choice = scanner.next();
        }

        return Integer.parseInt(choice) - indexAdjustment;
    }

    private boolean isValidChoice(String choice){
        int intChoice;
        if (StringUtils.isBlank(choice))
            return false;
        try {
            intChoice = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            return false;
        }
        if (intChoice > CommandListFactory.getCommadList().size())
           return false;
        if(intChoice < indexAdjustment)
            return false;
        return true;
    }

    private void presentMenu() {
        for (int i = indexAdjustment; i < commadList.size() + indexAdjustment; i++) {
            System.out.println(i + ") " + commadList.get(i - indexAdjustment).getDescription());
        }
        System.out.print("> ");
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
