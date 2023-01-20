package be.jonasboon.service;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TaskArchiveService {

    FileService fileService = new FileService();

    private void tryOpenFile() throws IOException {
        File file = fileService.selectTextFile();
        Desktop desktop = isDesktopSupported();
        desktop.open(file);
    }

    public void openFile() {
        try {
            tryOpenFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Desktop isDesktopSupported() {
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported!");
            throw new RuntimeException("Desktop is not supported");
        }
        return Desktop.getDesktop();
    }

    public void addTimeStampToTextInFile(){

    }
}
