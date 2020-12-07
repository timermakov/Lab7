import ru.ifmo.se.pokemon.*;

public class Clefable extends Clefairy {
    public Clefable(String name, int level) {
        super(name, level);
        setStats(95,70,73,95,90,60);
        setType(Type.GRASS);
        setMove(new Rest(), new Facade(), new DefenseCurl(), new Swagger());
    }
}