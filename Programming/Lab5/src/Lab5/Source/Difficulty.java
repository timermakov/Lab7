package Lab5.Source;

import Lab5.FileInteraction.Csv_Interchangeable;
/**
 * Enum, содержащий уровни сложности
 */
public enum Difficulty implements Csv_Interchangeable {
    VERY_EASY("Очень просто"),
    VERY_HARD("Очень сложно"),
    IMPOSSIBLE("Невозможно"),
    INSANE("Безумно");

    private String name;
    Difficulty(String name){this.name = name;}

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Сложность: " + name;
    }


    @Override
    public String createCsv() {
        return this.name();
    }


}
