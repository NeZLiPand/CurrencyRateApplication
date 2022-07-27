package ua.open.api.andry.inkin.currencyrate.controller.utility;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public interface CRUDFile {

    public void provideFile(String nameFile,
                                String typeFile,
                                String textToFile);

    public File createFile(String nameFile,
                                  String typeFile);

    public void writeToFile(String nameFile,
                                   String typeFile,
                                   String textToFile);

    public void deleteFile(String nameFile, String typeFile) throws IOException, ParserConfigurationException;
}
