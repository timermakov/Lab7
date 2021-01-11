import java.util.Objects;

public class BetanEricsonImpl extends Human implements BetanEricsonAbilities {
    public BetanEricsonImpl(int form) {
        this.setName(form);
    }

    private String name;
    private int age;

    public void setName(int form) {
        if (form == 1) this.name = "Бетан";
        else if (form == 2) this.name = "она";
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void overtake(String when) {
        System.out.print(getName() + " могла " + new TheyImpl(1).getName() + when + "настичь");
    }

    @Override
    public void grab() {
        System.out.print(getName() + Words.ALREADY.getName() + "норовила " + new TheyImpl(1).getName() + " схватить");
    }

    @Override
    public void knock(String how, Door door) {
        System.out.print(Words.WHILE.getName() + getName() + how + "колотила в " + door.getName());
    }

    @Override
    public void angry() {
        System.out.print(Words.IF.getName() + getName() + Words.NOTSO.getName() + "сердилась");
    }

    @Override
    public void hear() {
        this.setName(2);
        System.out.print(this.getName() + Words.WOULD.getName() + "услышала");
    }

    @Override
    public String toString() {
        return "BetanEricsonImpl{}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BetanEricsonImpl that = (BetanEricsonImpl) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, age);
    }
}
