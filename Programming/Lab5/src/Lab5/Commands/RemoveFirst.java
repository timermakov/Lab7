package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Класс с методом, удаляющим первый элемент из коллекции
 */
public class RemoveFirst implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "REMOVE_FIRST".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        for (int i = 0; i<list.size(); i++)
            if (list.isEmpty()==false){
                list.remove(0);
                System.out.println("Первый элемент удалён из коллекции");
                return true;
            }
        System.out.println("Невозможно удалить первый элемент, т.к. коллекция пуста");
        return false;
    }
}
