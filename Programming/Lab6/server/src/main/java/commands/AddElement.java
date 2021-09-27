package commands;

import source.*;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Класс с методом, добавляющим элемент в коллекцию из консоли
 */
public class AddElement implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "ADD".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {

        Scanner scanner;
        String line = null;
        LabWork labWork = new LabWork();
        String labName = null;
        Integer x = 0;
        Double y = 0.0;
        Coordinates coordinates = null;
        Long minimalPoint = null;
        Integer averagePoint = null;
        Difficulty difficulty = null;
        Person author;
        String authorName = null;
        ZonedDateTime authorBirthday = null;
        Float authorHeight = null;
        Double authorWeight = null;
        String authorPassportID = null;

        scanner = new Scanner(System.in);

        String regexWord = "^\\w+$";
        String regexPassport = "^\\d+$";

        for(;;) {
            System.out.print("Введите имя: ");
            line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            if (!line.matches(regexWord)) {
                System.out.println("Можно вводить только буквы латинского алфавита, цифры и подчёркивание");
                continue;
            }
            labName = line;
            System.out.println("Имя: " + labName);
            break;
        }

        for(;;) {
            System.out.print("\nВведите координату x: ");
            line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            try {
                x = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод числа");
                continue;
            }
            System.out.println("x: " + x);
            break;
        }

        for(;;) {
            System.out.print("\nВведите координату y: ");
            line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            try {
                y = Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод числа");
                continue;
            }
            System.out.println("y: " + y);
            break;
        }
        coordinates = new Coordinates(x, y);
        System.out.println("Координаты: " + coordinates);


        for(;;) {
            System.out.print("\nВведите минимальный балл: ");
            line = scanner.nextLine();
            try {
                minimalPoint = Long.parseLong(line);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод числа");
                continue;
            }
            if (minimalPoint <= 0) {
                System.out.println("Значение поля должно быть больше 0");
                minimalPoint = null;
                continue;
            }
            System.out.println("Минимальный балл: " + minimalPoint);
            break;
        }

        for(;;) {
            System.out.print("\nВведите средний балл: ");
            line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            try {
                averagePoint = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод числа");
                continue;
            }
            if (averagePoint <= 0) {
                System.out.println("Значение поля должно быть больше 0");
                minimalPoint = null;
                continue;
            }
            System.out.println("Средний балл: " + averagePoint);
            break;
        }

        for(;;) {
            System.out.print("\nВведите сложность: (на английском)\n");
            for (Difficulty dif : Difficulty.values()) System.out.println(dif + " " + dif.name());
            line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            try {
                difficulty = Difficulty.valueOf(line.toUpperCase());
            }
            catch(Exception e) {
                System.out.println("Некорректный ввод уровня сложности");
            }
            boolean notFound = true;
            for (Difficulty dif : Difficulty.values())
                if (dif.equals(difficulty)) {
                    notFound = false;
                    break;
                }
            if (notFound) {
                System.out.println("Некорректный ввод уровня сложности");
                continue;
            };
            System.out.println(difficulty);
            break;
        }


        for(;;) {
            System.out.print("Введите имя автора: ");
            line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            if (!line.matches(regexWord)) {
                System.out.println("Можно вводить только буквы латинского алфавита, цифры и подчёркивание");
                continue;
            }
            authorName = line;
            System.out.println("Имя автора: " + authorName);
            break;
        }

        for(;;) {
            System.out.print("\nВведите дату рождения автора: ");
            line = scanner.nextLine();
            if (line.equals("")){
                System.out.println("Поле не может быть пустым");
                continue;
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                authorBirthday = LocalDate.parse(line, dtf).atStartOfDay(ZoneOffset.UTC);
            } catch (Exception e) {
                System.out.println("Некорректный ввод даты. Введите в формате YYYY-MM-DD");
                continue;
            }
            System.out.println("Дата рождения автора: " + authorBirthday);
            break;
        }

        for(;;) {
            System.out.print("\nВведите рост автора: ");
            line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            try {
                authorHeight = Float.parseFloat(line);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод числа");
                continue;
            }
            if (authorHeight <= 0) {
                System.out.println("Значение поля должно быть больше 0");
                authorHeight = null;
                continue;
            }
            System.out.println("Рост автора: " + authorHeight);
            break;
        }

        for(;;) {
            System.out.print("\nВведите вес автора: ");
            line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            try {
                authorWeight = Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод числа");
                continue;
            }
            if (authorWeight <= 0) {
                System.out.println("Значение поля должно быть больше 0");
                authorWeight = null;
                continue;
            }
            System.out.println("Вес автора: " + authorWeight);
            break;
        }

        for(;;) {
            System.out.print("\nВведите номер паспорта: ");
            line = scanner.nextLine();
            if (line.equals("")) {
                System.out.println("Поле не может быть пустым");
                continue;
            }
            if (!line.matches(regexPassport)) {
                System.out.println("Можно вводить только цифры");
                continue;
            }
            authorPassportID = line;
            System.out.println("Номер паспорта: " + authorPassportID);
            break;
        }

        author = new Person(authorName, authorBirthday, authorHeight, authorWeight, authorPassportID);

        list.add(new LabWork(labName, coordinates, minimalPoint, averagePoint, difficulty, author));

        return true;
    }

}
