package be.jonasboon.service;

import javax.naming.OperationNotSupportedException;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static be.jonasboon.constants.UIContstants.createTimeStamp;

public class TaskArchiveService {

    FileService fileService = new FileService();

    private void tryOpenFile() throws IOException, OperationNotSupportedException {
        File file = fileService.selectTextFile();
        Desktop desktop = isDesktopSupported();
        desktop.open(file);
    }

    public void openFileInWindow() {
        try {
            tryOpenFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private Desktop isDesktopSupported() throws OperationNotSupportedException {
        if(!Desktop.isDesktopSupported()){
            throw new OperationNotSupportedException("Desktop is not supported");
        }
        return Desktop.getDesktop();
    }

    public void addTimeStampToTextInFile(){
        try {
            tryAddTimeStampToTextInFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private  void tryAddTimeStampToTextInFile() throws IOException {
        File file = fileService.selectTextFile();
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, true))) {
            bf.append(createTimeStamp());
        }
    }
}
