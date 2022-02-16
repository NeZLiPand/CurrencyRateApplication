package ua.open.api.andry.inkin.currencyrate.provider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TempFileProviderImpl implements TempFileProvider {

    @Override
    public void provideTempFile(String nameFile,
                                String typeFile,
                                String textToFile) {
        createFile(nameFile, typeFile);
        writeToFile(nameFile, typeFile, textToFile);
    }

    @Override
    public void writeToFile(String nameFile,
                            String typeFile,
                            String textToFile) {
        try {
            FileWriter myWriter = new FileWriter(nameFile
                                                 + "."
                                                 + typeFile);
            myWriter.write(textToFile);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File createFile(String nameFile,
                           String typeFile) {
        return new File(nameFile
                        + "."
                        + typeFile);
    }

    public File createFile(String nameFile,
                           String typeFile,
                           String directory) {
        return new File(directory
                        + nameFile
                        + "."
                        + typeFile);
    }

    @Override
    public void deleteFile(String nameFile,
                           String typeFile) throws IOException {
        if (new File(nameFile
                     + "."
                     + typeFile).delete()) {
            System.out.println("File "
                               + nameFile
                               + "."
                               + typeFile
                               + "deleted");
        }
    }

}
