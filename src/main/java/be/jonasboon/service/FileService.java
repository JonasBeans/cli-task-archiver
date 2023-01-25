package be.jonasboon.service;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

@Slf4j
public class FileService {

    public void createTextFile() {
        File file = new File(String.format("%s/%s.txt", askFolderName(),askFileName()));
        if (tryCreateFile(file))
            log.info("File created: " + file.getName());
        else
            log.info("File not created");
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
        String folderName = "today".equals(foldername) ? LocalDate.now().toString() : foldername;
        return "this".equals(folderName) ? "./" : folderName ;
    }

    public String askFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File name: ");
        String filename = scanner.nextLine();
        while (filename.trim().isEmpty()) {
            log.warn("Filename must not be empty!");
            System.out.print("File name: ");
            filename = scanner.nextLine();
        }
        return "today".equals(filename) ? LocalDate.now().toString() : filename;
    }

    protected File selectTextFile(){
        File file = new File(String.format("%s/%s.txt", askFolderName(), askFileName()));
        if (!file.exists()){
            log.warn("File doesn't exist");
        }
        return file;
    }

    protected boolean tryCreateFile(File file){
        try {
            return file.createNewFile();
        } catch (IOException e) {
            log.error("Something is wrong with the file");
            return false;
        }
    }

    public void createScreenShotArchiveOfTheDay() {
        File file = new File(String.format("%s/%s.docx", askFolderName(), LocalDate.now()));
        if (tryCreateScreenShotArchiveOfTheDay(file))
            log.info("File created");
        else
            log.info("File not created");
    }

    private boolean tryCreateScreenShotArchiveOfTheDay(File file){
        try {
            return file.createNewFile();
        } catch (IOException e) {
            log.error("Something is wrong with the file");
            return false;
        }
    }
}
