package fileinteraction;

import source.*;

import java.io.IOException;
import java.time.ZonedDateTime;

/**
Создает классы элементов, получая на вход экземпляр BufferedReader
 */
public class ClassesCreator {
    public static String[] data;


    /**
     * @param data2 Строка с координатой x
     * @param data3 Строка с координатой y
     * @return Объект - координаты
     * @throws IOException
     */
    public static Coordinates createCoordinates(String data2, String data3) throws IOException {
        Integer x = Integer.parseInt(data2);
        double y = Double.parseDouble(data3);
        return new Coordinates(x, y);
    }

    /**
     * @param data7 Строка с уровнем сложности
     * @return Объект - уровень сложности
     * @throws IOException
     */
    public static Difficulty createDifficulty(String data7) throws IOException{
        Difficulty difficulty = Difficulty.valueOf(data7);
        return difficulty;
    }

    /**
     * @param data8 Строка с именем
     * @param data9 Строка с днём рождения
     * @param data10 Строка с высотой
     * @param data11 Строка с массой
     * @param data12 Строка с номером паспорта
     * @return Объект - человек
     * @throws IOException
     */
    public static Person createPerson(String data8, String data9, String data10, String data11, String data12) throws IOException{
        String name = data8;
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZonedDateTime birthday = ZonedDateTime.parse(data9);
        float height = Float.parseFloat(data10);
        double weight = Double.parseDouble(data11);
        String passportID = data12;
        return new Person(name, birthday, height, weight, passportID);
    }

    /**
     * @param data Все данные о лабораторной работе
     * @return Объект - лабораторная работа
     * @throws IOException
     */
    public static LabWork createLabWork(String[] data) throws IOException{

        int id = Integer.parseInt(data[0]);
        String name = data[1];

        Coordinates coordinates = createCoordinates(data[2], data[3]);
        //java.time.localDateTime

        ZonedDateTime creationTime = ZonedDateTime.parse(data[4]);
        //java.time.LocalDateTime creationTime = java.time.LocalDateTime.now();

        //java.time.localDateTime end
        Long minimalPoint = Long.parseLong(data[5]);
        int averagePoint = Integer.parseInt(data[6]);

        Difficulty difficulty = createDifficulty(data[7]);

        Person author = createPerson(data[8], data[9], data[10], data[11], data[12]);
        return new LabWork(id, name, coordinates, creationTime,
                minimalPoint, averagePoint, difficulty, author);
    }
}
