package Lab5.Comparators;

import Lab5.Source.LabWork;

/**
 * Интерфейс для сортировики элементов labWork
 */
public interface Sortable {
    /**
     * @param lab
     * @param lab2
     * @return
     */
    int sort(LabWork lab, LabWork lab2);
}
