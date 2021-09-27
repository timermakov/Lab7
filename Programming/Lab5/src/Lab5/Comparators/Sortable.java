package Lab5.Comparators;

import Lab5.Source.LabWork;

/**
 * Интерфейс для сортировики элементов labWork
 */
public interface Sortable {
    /**
     * @param lab Первая лабораторная для сравнения
     * @param lab2 Вторая лабораторная для сравнения
     * @return Результат сравнения
     */
    int sort(LabWork lab, LabWork lab2);
}
