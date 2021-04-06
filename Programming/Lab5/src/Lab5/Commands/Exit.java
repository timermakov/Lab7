package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.LinkedList;

/**
 * Класс с методом, завершающим работу программы
 */
public class Exit implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "EXIT".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        System.exit(0);
        return true;
    }
}
