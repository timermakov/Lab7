import java.util.Objects;

public class MotherImpl extends Human implements ManAbilities {
    public MotherImpl(int form) {
        this.setName(form);
    }

    private String Name;
    private int Age;

    public void setName(int form) {
        if (form == 1) this.Name = "Мама";
        else if (form == 2) this.Name = "она";
    }

    public String getName() {
        return this.Name;
    }
    @Override
    public void fallDown(String how, EricEricsonImpl him) {
    }

    @Override
    public void breakIn(String how, int form, String when) {
    }

    @Override
    public void turn(String how, Door.Key key) {
    }

    @Override
    public void laugh(String how) {
    }

    @Override
    public void bet() {
    }

    @Override
    public void cook(String where) {
        System.out.print(getName() + " хлопотала " + where);
    }

    @Override
    public void see(String what) {
        Forehead foreheadEricEricson = this.new Forehead("лбу");
        Forehead.Bump bumpEricEricson = foreheadEricEricson.new Bump(what);
        System.out.print("Увидев " + bumpEricEricson.getName());
    }

    @Override
    public void sad() {
        setName(2);
        System.out.print(getName() + Words.AS.getName() + "следовало ожидать, огорчилась");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MotherImpl mother = (MotherImpl) o;
        return Objects.equals(Name, mother.Name);
    }

    @Override
    public String toString() {
        return "MotherImpl{" +
                "Name='" + Name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Name);
    }
}
