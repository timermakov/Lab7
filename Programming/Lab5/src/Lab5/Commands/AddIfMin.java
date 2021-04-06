package Lab5.Commands;

import Lab5.Exceptions.ValueIsEmptyException;
import Lab5.Source.Difficulty;
import Lab5.Source.LabWork;

import java.util.LinkedList;

/**
 * Класс с методом, добавляющий новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента коллекции LabWork
 */
public class AddIfMin implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "ADD_IF_MIN".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        LinkedList<LabWork> tempo = new LinkedList<>();
        (new AddElement()).execute(tempo, "");

        boolean canAdd = true;
        for (LabWork labWork : list)
            if (labWork.compareTo(tempo.get(0)) < 0) {
                canAdd = false;
                break;
            }

        if (canAdd) list.add(tempo.get(0));
        else System.out.println("Элемент не добавлен");
        return true;
    }
}
