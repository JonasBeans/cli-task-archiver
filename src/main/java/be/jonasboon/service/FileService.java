package be.jonasboon.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class FileService {

    public void createTextFile() {
        File file = new File(String.format("%s/%s.txt", askFolderName(),askFileName()));
        if (tryCreateFile(file))
            System.out.println("File created");
        else
            System.out.println("File not created");
    }

    private String askFolderName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Folder name to put file in: ");
        String foldername = scanner.nextLine();
        while (foldername.trim().isEmpty()) {
            System.out.println("Foldername can't be empty!");
            System.out.println("Folder name: ");
            foldername = scanner.nextLine();
        }
        String folderName = "today".equals(foldername) ? LocalDate.now().toString() : foldername;
        return "this".equals(folderName) ? "./" : folderName ;
    }

    private String askFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Folder name: ");
        String filename = scanner.nextLine();
        while (filename.trim().isEmpty()) {
            System.out.println("File can't be empty!");
            System.out.println("File name: ");
            filename = scanner.nextLine();
        }
        String fileName = "today".equals(filename) ? LocalDate.now().toString() : filename;
        return "this".equals(fileName) ? "./" : fileName ;
    }
    private boolean tryCreateFile(File file){
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createScreenShotArchiveOfTheDay() {
        File file = new File(String.format("%s/%s.docx", askFolderName(), LocalDate.now()));
        if (tryCreateScreenShotArchiveOfTheDay(file))
            System.out.println("File created");
        else
            System.out.println("File not created");
    }

    private boolean tryCreateScreenShotArchiveOfTheDay(File file){
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTimeStampToTextInFile(){

    }
}
