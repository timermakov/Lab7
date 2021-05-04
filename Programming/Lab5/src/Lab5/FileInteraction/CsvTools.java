package Lab5.FileInteraction;
import Lab5.Source.LabWork;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Вспомогательный класс для работы с csv
 */
public class CsvTools {

    /**
     * Получает сохраненную информацию из строки csv формата
     * @param line Строка csv формата
     * @return Информация из строки
     */
    public static String[] getData(String line) {
        String[] data = line.split(";");
        return data;
    }

    /**
     * Создает строку csv формата
     * @param data Информация csv-строки
     * @return Строка csv формата
     */
    public static String createCsvLine(String ... data) {
        String line = "";
        for (String el: data) {
            line = line + el + ";";
        }
        return line;
    }
}

