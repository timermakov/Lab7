package Lab5.Comparators;

import Lab5.Source.LabWork;

/**
 * Реализует сортировку по возрастанию (сортирует названия лабораторных по алфавиту)
 */
public class SortAscending implements Sortable {
    /**
     * @param lab первая лабораторная для сравнения
     * @param lab2 вторая лабораторная для сравнения
     * @return результат сравнения
     */
    @Override
    public int sort(LabWork lab, LabWork lab2) {
        return lab.getName().compareTo(lab2.getName());
    }
}
