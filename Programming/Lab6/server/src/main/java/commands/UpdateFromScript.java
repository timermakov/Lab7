package commands;

import source.LabWork;

import java.util.LinkedList;

/**
 * Класс с методом, переписывающем элемент коллекции по id из файла
 */
public class UpdateFromScript implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "UPDATE".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {

        for (LabWork labWork : list)
            if ((labWork.getId() == Integer.parseInt(arg))){

                int id = labWork.getId();
                int position = list.indexOf(labWork);
                (new AddElementFromScript()).execute(list, "");
                list.get(list.size()-1).setId(id);
                list.set(position, list.get(list.size()-1));
                list.remove(list.size()-1);
                return true;
            }

        return false;
    }
}
