package commands;

import fileinteraction.ClassesCreator;
import source.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 * Класс с методом, добавляющим элемент в коллекцию из файла
 */

public class AddElementFromScript implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "ADD".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String args) {

        String[] data = args.split(" ");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

        LabWork labWork;
        ClassesCreator classesCreator = new ClassesCreator();

        String labName = data[0];
        Coordinates coordinates = null;
        try {
            coordinates = classesCreator.createCoordinates(data[1], data[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Long minimalPoint = Long.parseLong(data[3]);
        Integer averagePoint = Integer.parseInt(data[4]);
        Difficulty difficulty = null;
        try {
            difficulty = classesCreator.createDifficulty(data[5]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String authorName = data[6];
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZonedDateTime authorBirthday = LocalDate.parse(data[7], dtf).atStartOfDay(ZoneOffset.UTC);;
        Float authorHeight = Float.parseFloat(data[8]);
        Double authorWeight = Double.parseDouble(data[9]);
        String authorPassportID = data[10];

        Person author = new Person(authorName, authorBirthday, authorHeight, authorWeight, authorPassportID);
        labWork = new LabWork(labName, coordinates, minimalPoint, averagePoint, difficulty, author);
        list.add(labWork);


/*
        list.add(new LabWork(args[0],
                new Coordinates(Integer.parseInt(args[1]), Double.parseDouble(args[2])),
                ZonedDateTime.parse(args[3]),
                Long.parseLong(args[4]),
                Integer.parseInt(args[5]),
                Double.parseDouble(args[6]),
                new Difficulty(),
                new Person(args[7], Long.parseLong(args[8]),
                        new Location(Float.parseFloat(args[9]),
                                Integer.parseInt(args[10]),
                                Long.parseLong(args[11])
                ))));*/
        return true;
    }
}
