package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.ArrayList;

/**
 * Класс с методом, добавляющим элемент в коллекцию из файла, при условии, что он ниже по сложности, по сложности, чем ослальные элементы LabWork
 */
public class AddIfMinFromScript implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "ADD_IF_MIN".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        ArrayList<LabWork> tempo = new ArrayList<>();
        (new AddElementFromScript()).execute(tempo, arg);

        boolean canAdd = true;
        for (LabWork labWork : list)
            if (labWork.getDifficulty().compareTo(tempo.get(0).getDifficulty()) < 0) {
                canAdd = false;
                break;
            }

        if (canAdd) list.add(tempo.get(0));
        return true;
    }
}
