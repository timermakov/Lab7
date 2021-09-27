package commands;

import fileinteraction.FileInteractor;
import source.LabWork;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Класс с методом, сохраняющим коллекцию в файл
 */
public class Save implements Executable{

    @Override
    public boolean isDesired(String name) {
        return "SAVE".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        try {
            FileInteractor.getInstance().writeData(list);
        }catch(IOException e) {
            System.out.println("Ошибка сохранения в файл");
            return false;
        }
        return true;
    }
}
