import java.util.Objects;

public class TheyImpl extends Human implements TheyAbilities {
    public TheyImpl(int form) {
        this.setName(form);
    }

    private String name;

    CarlssonImpl carlsson = new CarlssonImpl("Карлсон");

    EricEricsonImpl ericEricson = new EricEricsonImpl("Малыш");

    BetanEricsonImpl betanEricson = new BetanEricsonImpl(1);

    public void setName(int form) {
        if (form == 1) this.name = "их";
        else if (form == 11) this.name = "Их";
        else if (form == 2) this.name = "они";
        else if (form == 22) this.name = "Они";
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void saved(Door door) {
        Nose noseBetanEricson = new Nose("носом ", betanEricson);
        System.out.print(new TheyImpl(22).getName() + " спаслись, " + door.close() + " перед самым " + noseBetanEricson.getName());
    }

    @Override
    public void laugh(String how) {
        if (how.equals("новым взрывом")) System.out.print("сопровождаемый " + how + " смеха");
        if (how.equals("смеются двое")) System.out.print(Words.THAT.getName() + how);
    }

    @Override
    public void crawl(String how) {
        System.out.print(Words.THATISWHY.getName() + new TheyImpl(2).getName() + " поползли " + how);
    }

    @Override
    public void breakIn(String how, int form, String when) {
        System.out.print(how + "ворвались " + new TheyImpl(form).getName() + new Place().location(new Room("комнату ", new EricEricsonImpl("Малыша"))) + when);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TheyImpl they = (TheyImpl) o;
        return Objects.equals(name, they.name) &&
                Objects.equals(carlsson, they.carlsson) &&
                Objects.equals(ericEricson, they.ericEricson) &&
                Objects.equals(betanEricson, they.betanEricson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, carlsson, ericEricson, betanEricson);
    }

    @Override
    public String toString() {
        return "TheyImpl{" +
                "name='" + name + '\'' +
                ", carlsson=" + carlsson +
                ", ericEricson=" + ericEricson +
                ", betanEricson=" + betanEricson +
                '}';
    }
}
