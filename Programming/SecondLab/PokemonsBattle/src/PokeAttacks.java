import ru.ifmo.se.pokemon.*;

class WillOWisp extends PhysicalMove {
    protected WillOWisp() {
        super(Type.FIRE, 0, 75);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.burn(p);
    }

    @Override
    protected String describe(){
        return "Атака Огненного типа, которая поджигает противника";
    }
}

class Psychic extends StatusMove {
    protected Psychic() {
        super(Type.PSYCHIC, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.1) p.setMod(Stat.SPECIAL_DEFENSE, -1);
    }

    @Override
    protected String describe(){
        return "Имеет 10% шанс понизить Спец. Защиту цели на одну ступень";
    }
}

class Rest extends StatusMove {
    protected Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.HP, 100);
        Effect.sleep(p);
        Effect effect = new Effect();
        effect.turns(2);
        p.addEffect(effect);
    }

    @Override
    protected String describe(){
        return "Покемон полностью вылечивает себя и засыпает на два хода";
    }
}

class CrossPoison extends PhysicalMove {
    protected CrossPoison() {
        super(Type.POISON, 70, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage){
        if (Math.random() <= 0.1) def.setMod(Stat.HP, 0);
    }

    @Override
    protected double calcCriticalHit(Pokemon pokemon, Pokemon pokemon1) {
        pokemon.setMod(Stat.SPEED, 1);
        if (Math.random() < pokemon.getStat(Stat.SPEED) / 512) return 2 * pokemon.getStat(Stat.ATTACK);
        else return pokemon.getStat(Stat.ATTACK);
    }

    @Override
    protected String describe(){
        return "Режущая атака ядовитым лезвием, также способная отравить цель. Имеет высокий шанс критического удара";
    }
}


class XScissor extends PhysicalMove {
    protected XScissor() { super(Type.BUG, 80, 100); }

    @Override
    protected String describe(){
        return "Наносит обычные повреждения без дополнительных эффектов";
    }
}

class ScaryFace extends PhysicalMove {
    protected ScaryFace() { super(Type.NORMAL, 0, 100); }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPEED, -2);
    }

    @Override
    protected String describe(){
        return "Понижает Скорость цели на две ступени";
    }
}

class SmartStrike extends PhysicalMove {
    protected SmartStrike() { super(Type.STEEL, 70, 0); }

    @Override
    protected String describe(){
        return "Покемон наносит цели удар в спину острым рогом. Никогда не промахивается";
    }
}

class DefenseCurl extends PhysicalMove {
    protected DefenseCurl() { super(Type.NORMAL, 0, 0); }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.DEFENSE, 1);
    }

    @Override
    protected String describe(){
        return "Покемон сворачивается, пряча уязвимые места и повышая свою Защиту";
    }
}

class Swagger extends StatusMove{
    protected Swagger(){
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
    p.setMod(Stat.ATTACK, 2);
    Effect.confuse(p);
    }

    @Override
    protected String describe(){
        return "Повышает Атаку цели на две ступени и сбивает её с толку";
    }
}

class Facade extends PhysicalMove{
    protected Facade(){
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage){
        Status PokCon = def.getCondition();
        if (PokCon.equals(Status.BURN) || PokCon.equals(Status.POISON) || PokCon.equals(Status.PARALYZE)) {
            def.setMod(Stat.HP, (int) Math.round(damage) * 2);
        }
    }

    @Override
    protected String describe(){
        return "Сила удваивается, если использующий обожжён, парализован или отравлен";
    }
}