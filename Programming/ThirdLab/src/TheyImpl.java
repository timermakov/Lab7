import java.util.Objects;

public class TheyImpl extends Human implements ManAbilities, ChildrenAbilities {
    public TheyImpl(int form) {
        this.setName(form);
    }

    private String Name;
    CarlssonImpl carlsson = new CarlssonImpl("Карлсон");

    @Override
    public String toString() {
        return "TheyImpl{" +
                "Name='" + Name + '\'' +
                ", carlsson=" + carlsson +
                ", ericEricson=" + ericEricson +
                ", betanEricson=" + betanEricson +
                '}';
    }

    EricEricsonImpl ericEricson = new EricEricsonImpl("Малыш");
    BetanEricsonImpl betanEricson = new BetanEricsonImpl("Бетан");

    public void setName(int form) {
        if (form == 1) this.Name = "их";
        else if (form == 11) this.Name = "Их";
        else if (form == 2) this.Name = "они";
        else if (form == 22) this.Name = "Они";
    }

    public String getName() {
        return this.Name;
    }

    public void saved(Door door) {
        Nose noseBetanEricson = new Nose("носом ", betanEricson);
        System.out.print(new TheyImpl(22).getName() + " спаслись, " + door.close() + " перед самым " + noseBetanEricson.getName());
    }

    @Override
    public void keepCalm() {

    }

    @Override
    public void laugh() {

    }

    @Override
    public void doNotUnderstand() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TheyImpl they = (TheyImpl) o;
        return Objects.equals(Name, they.Name) &&
                Objects.equals(carlsson, they.carlsson) &&
                Objects.equals(ericEricson, they.ericEricson) &&
                Objects.equals(betanEricson, they.betanEricson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Name, carlsson, ericEricson, betanEricson);
    }

    @Override
    public void crawl(String how) {
        System.out.print(Words.THATISWHY.getName() + new TheyImpl(2).getName() + " поползли " + how);
    }

    @Override
    public void run(String how) {

    }

    @Override
    public void overtake(String when) {

    }

    @Override
    public void grab() {

    }

    @Override
    public void knock(String how, Door door) {

    }

    @Override
    public void fallDown(String how, EricEricsonImpl him) {

    }

    @Override
    public void breakIn(String how, int form, String when) {
        System.out.print(how + "ворвались " + new TheyImpl(form).getName() + new Place().location(new Room("комнату ", new EricEricsonImpl("Малыша"))) + when);
    }

    @Override
    public void turn(String speed, Key key) {

    }

    @Override
    public void laugh(String how) {

    }
}
