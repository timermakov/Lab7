package commands;

import source.LabWork;

import java.util.LinkedList;

/**
 * Класс с методом, отображающем все элекменты коллекции
 */
public class Show implements Executable{

    @Override
    public boolean isDesired(String name) {
        return "SHOW".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        if (list.isEmpty()){
            System.out.println("Коллекция пуста");

        }
        else {
            System.out.println("Элементы LinkedList представлены ниже: ");

            for (int i = 0; i < list.size(); i++) System.out.println("\n№ " + (i+1) + "\n" + list.get(i));
        }
        return true;
    }
}
