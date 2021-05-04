package Lab5.Commands;

import Lab5.Comparators.SortAscending;
import Lab5.Source.LabWork;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Класс с методом, выводящим элементы коллекции в порядке возрастания по алфавиту (от а до я)
 */
public class PrintAscending implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "PRINT_ASCENDING".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        LinkedList<LabWork> tempoList = new LinkedList<>(list);
        tempoList.forEach(labWork -> labWork.setSortBehavior(new SortAscending()));
        Collections.sort(tempoList);
        (new Show()).execute(tempoList, "");
        return true;
    }
}
