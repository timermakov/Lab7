package Lab5.Commands;

import Lab5.Comparators.SortDescending;
import Lab5.Source.LabWork;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Класс с методом, выводящим элементы коллекции в порядеке убывания по алфавиту (от я до а)
 */
public class PrintDescending implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "PRINT_DESCENDING".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        LinkedList<LabWork> tempoList = new LinkedList<>(list);
        tempoList.forEach(labWork -> labWork.setSortBehavior(new SortDescending()));
        Collections.sort(tempoList);
        (new Show()).execute(tempoList, "");
        return true;
    }
}
