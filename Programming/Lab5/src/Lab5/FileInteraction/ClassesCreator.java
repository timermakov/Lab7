package Lab5.FileInteraction;

import Lab5.Source.*;
import Lab5.FileInteraction.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
Создает классы элементов, получая на вход экземпляр BufferedReader
 */
public class ClassesCreator {
    public static String[] data;


    public static Coordinates createCoordinates(BufferedReader reader) throws IOException {
        Integer x = Integer.parseInt(data[2]);
        double y = Double.parseDouble(data[3]);
        return new Coordinates(x, y);
    }

    public static Difficulty createDifficulty(BufferedReader reader) throws IOException{
        Difficulty difficulty = Difficulty.valueOf(data[7]);
        return difficulty;
    }

    public static Person createPerson(BufferedReader reader) throws IOException{
        String name = data[8];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZonedDateTime birthday = ZonedDateTime.parse(data[9], formatter);
        float height = Float.parseFloat(data[10]);
        double weight = Double.parseDouble(data[11]);
        String passportID = data[12];
        return new Person(name, birthday, height, weight, passportID);
    }

    public static LabWork createLabWork(BufferedReader reader) throws IOException{

        int id = Integer.parseInt(data[0]);
        String name = data[1];

        Coordinates coordinates = createCoordinates(reader);
        //java.time.localDateTime

        ZonedDateTime creationTime = ZonedDateTime.parse(data[4]);
        //java.time.LocalDateTime creationTime = java.time.LocalDateTime.now();

        //java.time.localDateTime end
        Long minimalPoint = Long.parseLong(data[5]);
        int averagePoint = Integer.parseInt(data[6]);

        Difficulty difficulty = createDifficulty(reader);

        Person author = createPerson(reader);
        reader.readLine();
        return new LabWork(id, name, coordinates, creationTime,
                minimalPoint, averagePoint, difficulty, author);
    }
}
