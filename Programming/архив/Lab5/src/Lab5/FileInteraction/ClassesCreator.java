package Lab5.FileInteraction;

import Lab5.Source.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;

/**
Создает классы элементов, получая на вход экземпляр BufferedReader
 */
public class ClassesCreator {
    public static Coordinates createCoordinates(BufferedReader reader) throws IOException {
        Integer x = Integer.parseInt(XmlTools.getData(reader.readLine()));
        double y = Double.parseDouble(XmlTools.getData(reader.readLine()));
        reader.readLine();

        return new Coordinates(x, y);
    }

    public static Difficulty createDifficulty(BufferedReader reader) throws IOException{
        Difficulty difficulty = Difficulty.valueOf(reader.readLine());
        reader.readLine();
        return difficulty;
    }

    public static Person createPerson(BufferedReader reader) throws IOException{
        String name = XmlTools.getData(reader.readLine());
        ZonedDateTime birthday = ZonedDateTime.parse(XmlTools.getData(reader.readLine()));
        float height = Float.parseFloat(XmlTools.getData(reader.readLine()));
        double weight = Double.parseDouble(XmlTools.getData(reader.readLine()));
        String passportID = XmlTools.getData(reader.readLine());
        return new Person(name, birthday, height, weight, passportID);
    }

    public static LabWork createLabWork(BufferedReader reader) throws IOException{

        int id = Integer.parseInt(XmlTools.getData(reader.readLine()));
        String name = XmlTools.getData(reader.readLine());
        reader.readLine();
        Coordinates coordinates = createCoordinates(reader);
        //java.time.localDateTime

        ZonedDateTime creationTime = ZonedDateTime.parse(XmlTools.getData(reader.readLine()));
        //java.time.LocalDateTime creationTime = java.time.LocalDateTime.now();

        //java.time.localDateTime end
        Long minimalPoint = Long.parseLong(XmlTools.getData(reader.readLine()));
        int averagePoint = Integer.parseInt(XmlTools.getData(reader.readLine()));
        reader.readLine();
        Difficulty difficulty = createDifficulty(reader);
        reader.readLine();
        Person author = createPerson(reader);
        reader.readLine();
        return new LabWork(id, name, coordinates, creationTime,
                minimalPoint, averagePoint, difficulty, author);
    }
}
