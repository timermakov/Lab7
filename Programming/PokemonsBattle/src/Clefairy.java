import ru.ifmo.se.pokemon.*;

public class Clefairy extends Cleffa {
    public Clefairy(String name, int level) {
        super(name, level);
        setStats(70, 45, 48, 60, 65,35);
        setType(Type.FAIRY);
        setMove(new Rest(), new Facade(), new DefenseCurl());
    }
}