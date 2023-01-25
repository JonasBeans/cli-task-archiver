package be.jonasboon.service;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

@Slf4j
public class FolderService {

    public void creatFolder() {
        String folderNamer = askFolderName();
        File file = new File(String.format("./%s", folderNamer));
        if (file.mkdir())
            log.info("Folder created");
        else
            log.info("Folder not created");
    }

    protected String askFolderName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Folder name: ");
        String foldername = scanner.nextLine();
        while (foldername.trim().isEmpty()) {
            log.warn("Foldername must not be empty!");
            System.out.print("Folder name: ");
            foldername = scanner.nextLine();
        }
        return foldername.equals("today") ? LocalDate.now().toString() : foldername;
    }
}
