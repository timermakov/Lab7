package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс с методом, удаляющим из коллекции все элементы, меньшие, чем заданный
 */
public class RemoveLower implements Executable{
    @Override
    public boolean isDesired(String name) {
        return "REMOVE_LOWER".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        while (arg == null || "".equals(arg)){
            System.out.println("Введите id: ");
            arg = new Scanner(System.in).nextLine();
        }
        int argElement = 0;
        try {
            argElement = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод числа");
        }
        for (int i = 0; i<list.size(); i++)
            if (list.get(0).getId() == Integer.parseInt(arg)){
                list.remove(i);
                return true;
            }
    }

}

