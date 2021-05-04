package Lab5.Commands;

import Lab5.Source.Difficulty;
import Lab5.Source.LabWork;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Класс с методом, выводящим элементы, у которых значение поля averagePoint больше заданного
 */
public class FilterStartsWithName implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "FILTER_STARTS_WITH_NAME".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        if ((arg != null) && (!arg.equals(""))) {
            LinkedList<LabWork> ending = new LinkedList<>();
            list.forEach(labWork -> {
                if(labWork.getName().startsWith(arg)) ending.add(labWork);
            });

            (new Show()).execute(ending, "");
            return true;
        } else {
            System.out.println("Введите начало поля name для вывода элементов, имя которых начинается с этой подстроки: ");
            boolean tempo = new FilterStartsWithName().execute(list, new Scanner(System.in).nextLine());
            if(!tempo) System.out.println("Некорректный ввод аргумента, попробуйте ещё раз");
            return tempo;
        }

    }
}
