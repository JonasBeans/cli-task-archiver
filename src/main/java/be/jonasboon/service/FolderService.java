package be.jonasboon.service;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class FolderService {

    public void creatFolder() {
        String folderNamer = askFolderName();
        File file = new File(String.format("./%s", folderNamer));
        if (file.mkdir())
            System.out.println("Folder created");
        else
            System.out.println("Folder not created");
    }

    private String askFolderName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Folder name: ");
        String foldername = scanner.nextLine();
        while (foldername.trim().isEmpty()) {
            System.out.println("Foldername can't be empty!");
            System.out.println("Folder name: ");
            foldername = scanner.nextLine();
        }
        return foldername.equals("today") ? LocalDate.now().toString() : foldername;
    }
}
