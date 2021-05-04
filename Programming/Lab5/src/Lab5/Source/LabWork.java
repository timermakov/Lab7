package Lab5.Source;


import Lab5.Comparators.SortAscending;
import Lab5.Comparators.Sortable;
import Lab5.FileInteraction.Csv_Interchangeable;
import Lab5.FileInteraction.CsvTools;


import java.time.ZonedDateTime;

public class LabWork implements Csv_Interchangeable, Comparable<LabWork>{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    private int averagePoint; //Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле не может быть null
    private Person author; //Поле не может быть null

    private Sortable sortBehavior = new SortAscending();

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
        this.id = id;
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
        return "*****\nЛабораторная работа\n" + "id: " + id + "\nНазвание: " + name + "\n" + coordinates +
                "\nВремя создания: " + creationDate
                + "\nПроходной балл: " + minimalPoint +
                "\nСредний балл: " + averagePoint + "\n" + difficulty + "\n" + author + "\n*****";
    }

    /**здесь заюзан StringBuilder*/
    @Override
    public String createCsv() {
        StringBuilder line = new StringBuilder("");
        line.append(CsvTools.createCsvLine(String.valueOf(this.id), name,
                coordinates.getX().toString(), String.valueOf(coordinates.getY()), creationDate.toString(),
                String.valueOf(minimalPoint), String.valueOf(averagePoint), difficulty.createCsv(),
                author.name, author.birthday.toString(), String.valueOf(author.height),
                String.valueOf(author.weight), String.valueOf(author.passportID)));
        return line.toString();
    }

    @Override
    public int compareTo(LabWork labWork) {
        return sortBehavior.sort(this, labWork);
    }
}
