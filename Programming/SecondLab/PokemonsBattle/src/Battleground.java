import ru.ifmo.se.pokemon.*;

public class Battleground {

    public static void main(String[] args) {
        Battle field = new Battle();
        field.addAlly(new Spinarak("Petrov", 2));
        field.addAlly(new Giratina("Ivanova", 1));
        field.addAlly(new Ariados("Sidorov", 2));
        field.addFoe(new Cleffa("Smirnova", 3));
        field.addFoe(new Clefairy("Popov", 3));
        field.addFoe(new Clefable("Sokolova", 2));
        field.go();
    }
}