package Lab5.Commands;

import Lab5.Source.Difficulty;
import Lab5.Source.LabWork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс с методом, выводящим элементы, у которых значение поля averagePoint больше заданного
 */
public class FilterGreaterThanAveragePoint implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "FILTER_GREATER_THAN_AVERAGE_POINT".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        if ((arg != null) && (!arg.equals(""))) {
            int averagePoint = 0;
            try {
                averagePoint = Integer.parseInt(arg);
            }
            catch (Exception e) {
                System.out.println("Некорректный ввод аргумента, попробуйте ещё раз");
            }
            ArrayList<LabWork> ending = new ArrayList<>();
            final int finalAveragePoint = averagePoint;
            list.forEach(labWork -> {
                if(labWork.getAveragePoint() > finalAveragePoint) ending.add(labWork);
            });
            (new Show()).execute(ending, "");
            return true;
        } else {
            System.out.println("Введите средний балл: ");
            boolean tempo = new FilterGreaterThanAveragePoint().execute(list, new Scanner(System.in).nextLine());
            if(!tempo) System.out.println("Некорректный ввод аргумента, попробуйте ещё раз");
            return tempo;
        }

    }
}
