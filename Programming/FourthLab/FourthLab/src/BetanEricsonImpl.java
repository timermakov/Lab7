public class BetanEricsonImpl extends Human implements ChildrenAbilities {
    public BetanEricsonImpl(int form) {
        this.setName(form);
    }

    private String Name;
    private int Age;

    public void setName(int form) {
        if (form == 1) this.Name = "Бетан";
        else if (form == 2) this.Name = "она";
    }

    public String getName() {
        return this.Name;
    }

    @Override
    public void keepCalm() {

    }

    @Override
    public void doNotUnderstand() {

    }

    @Override
    public void crawl(String how) {

    }

    @Override
    public void breakIn(String how, int form, String when) {

    }

    @Override
    public void run(String how) {

    }

    @Override
    public void go(String where) {

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
}
