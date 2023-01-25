package be.jonasboon.service;

import lombok.extern.slf4j.Slf4j;

import javax.naming.OperationNotSupportedException;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static be.jonasboon.constants.UIContstants.createTimeStamp;
import static be.jonasboon.utils.TimeUtils.getMonthYearName;


@Slf4j
public class TaskArchiveService {

    FileService fileService = new FileService();

    private void tryOpenFile(String fileName) throws IOException, OperationNotSupportedException {
        File file = new File(fileName);
        Desktop desktop = isDesktopSupported();
        desktop.open(file);
    }

    public void openFileInWindow(String fileName) {
        try {
            tryOpenFile(fileName);
        } catch (IOException e) {
            log.error("Something is wrong with the file");
        } catch (OperationNotSupportedException e) {
            throw new UnsupportedOperationException();
        }
    }

    private Desktop isDesktopSupported() {
        if(!Desktop.isDesktopSupported()){
            log.error("Desktop not supported");
        }
        return Desktop.getDesktop();
    }

    public void addTimeStampToTextInFile(){
        try {
            tryAddTimeStampToTextInFile();
        } catch (IOException e) {
            log.error("Something wrong with the file");
        }
    }
    private void tryAddTimeStampToTextInFile() throws IOException {
        File file = fileService.selectTextFile();
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, true))) {
            bf.write(createTimeStamp());
        }
    }

    public void addTaskToArchive(){
        tryAddTaskToArchive();
    }

    private  void tryAddTaskToArchive() {
        File file = new File("./" + getMonthYearName() + ".txt");
        if (fileService.tryCreateFile(file))
            log.info("File created: {}", file.getName());
        else
            log.info("Adding timestamp to existing {}", file.getName());

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, true))) {
            bf.write(createTimeStamp());
        } catch (IOException e) {
            log.warn("File can not be processed: {}",file.getName());
        }
        openFileInWindow(file.getName());
    }
}
