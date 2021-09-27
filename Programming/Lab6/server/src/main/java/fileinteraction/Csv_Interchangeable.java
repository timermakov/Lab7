package fileinteraction;

/**
 * Интерфейс-родитель для класов-испочников, позволяющий сохранять их как Csv
 */
public interface Csv_Interchangeable {
    /**
     * Преобразует поля элемента в csv-строку
     * @return Поля элемента, организованные в csv-строку
     */
    String createCsv();
}