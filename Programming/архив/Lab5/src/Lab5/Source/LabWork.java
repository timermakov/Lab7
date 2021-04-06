package Lab5.Source;


import Lab5.Comparators.SortDescending;
import Lab5.Comparators.Sortable;
import Lab5.Exceptions.InvalidNumberException;
import Lab5.Exceptions.NotPositiveNumberException;
import Lab5.Exceptions.ValueIsEmptyException;
import Lab5.FileInteraction.XmlTools;
import Lab5.FileInteraction.Xml_Interchangeable;

import java.time.ZonedDateTime;

public class LabWork implements Xml_Interchangeable, Comparable<LabWork>{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    private int averagePoint; //Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле не может быть null
    private Person author; //Поле не может быть null

    private Sortable sortBehavior = new SortDescending();

    public LabWork(){}

    public LabWork(String name, Coordinates coordinates, Long minimalPoint, int averagePoint,
                   Difficulty difficulty, Person author) {
        if (name == null || name.equals("")
                || coordinates == null
                || minimalPoint <= 0
                || averagePoint <= 0
                || difficulty == null
                || author == null)
            throw new IllegalArgumentException();
        id = (int)(Math.random() * 1000000);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.minimalPoint = minimalPoint;
        this.averagePoint = averagePoint;
        this.difficulty = difficulty;
        this.author = author;
    }

    public LabWork(int id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate,
                   Long minimalPoint, int averagePoint,
                   Difficulty difficulty, Person author) {

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.minimalPoint = minimalPoint;
        this.averagePoint = averagePoint;
        this.difficulty = difficulty;
        this.author = author;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Long getMinimalPoint() {
        return minimalPoint;
    }

    public int getAveragePoint() {
        return averagePoint;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Person getAuthor() {
        return author;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public void setAveragePoint(int averagePoint) {
        this.averagePoint = averagePoint;
    }

    public void setMinimalPoint(Long minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setSortBehavior(Sortable sortBehavior) {
        this.sortBehavior = sortBehavior;
    }

    @Override
    public String toString() {
        return "\n*****\nЛабораторная работа:\n\n" + "id: " + id + "\nНазвание: " + name + "\n" + coordinates +
                "\nВремя создания: " + creationDate
                + "\nПроходной балл: " + minimalPoint +
                "\nСредний балл: " + averagePoint + "\n" + difficulty + "\n" + author + "\n*****";
    }

    /**здесь заюзан StringBuilder*/
    @Override
    public String createXml() {
        StringBuilder line = new StringBuilder("<LabWork>\n");
        line.append(XmlTools.createXmlLine("id", String.valueOf(id)));
        line.append(XmlTools.createXmlLine("name", name));
        line.append(coordinates.createXml());
        //line.append(creationDate);

        line.append(XmlTools.createXmlLine("creationDate", creationDate.toString()  ));

        //end of creation date creation
        line.append(XmlTools.createXmlLine("minimalPoint", String.valueOf(minimalPoint)));
        line.append(XmlTools.createXmlLine("averagePoint", String.valueOf(averagePoint)));
        line.append(difficulty.createXml());
        line.append(author.createXml());
        return line.append("</LabWork>\n").toString();
    }

    @Override
    public int compareTo(LabWork labWork) {
        return sortBehavior.sort(this, labWork);
    }
}
