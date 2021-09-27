package commands;

import source.LabWork;

import java.util.LinkedList;

/**
 * Класс с методом, выводящим и удаляющим первый элемент из коллекции
 */
public class RemoveHead implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "REMOVE_HEAD".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        for (int i = 0; i<list.size(); i++)
            if (list.isEmpty()==false) {
                System.out.println("\n№ 1 " + "\n" + list.get(0));
                list.remove(0);
                System.out.println("Первый элемент выведен на экран и удалён из коллекции");
                return true;
            }
        System.out.println("Невозможно удалить первый элемент, т.к. коллекция пуста");
        return false;
    }
}
