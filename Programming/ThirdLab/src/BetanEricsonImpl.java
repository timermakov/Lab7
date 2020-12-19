public class BetanEricsonImpl extends Human implements ChildrenAbilities {
    public BetanEricsonImpl(String name) {
        setName(name);
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
    public void crawl(String how) {

    }

    @Override
    public void breakIn(String how, int form, String when) {

    }

    @Override
    public void run(String how) {

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
    public String toString() {
        return "BetanEricsonImpl{}";
    }
}
