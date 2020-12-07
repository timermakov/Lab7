import ru.ifmo.se.pokemon.*;

public class Cleffa extends Pokemon {
    public Cleffa(String name, int level) {
        super(name, level);
        setStats(50, 25,28, 45, 55, 15);
        setType(Type.FAIRY);
        setMove(new Rest(), new Facade());
    }
}