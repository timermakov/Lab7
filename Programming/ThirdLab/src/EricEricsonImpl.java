public class EricEricsonImpl extends Human implements ChildrenAbilities {
    public EricEricsonImpl(String name) {
        setName(name);
    }

    @Override
    public void keepCalm() {
        System.out.print(getName() + " старался быть" + Words.ASPOSSIBLE.getName() + "спокойным");
    }

    @Override
    public void laugh() {
        System.out.print("смех" + Words.SO.getName() + "клокотал в нём");
    }

    @Override
    public void doNotUnderstand() {
        Legs legsEricEricson = new Legs("ноги", new EricEricsonImpl("его "));
        Legs legsCarlsson = new Legs("ноги", new CarlssonImpl(" Карлсона"));
        System.out.print(" и " + getName() + Words.ALREADY.getName() + "не разбирал"
                + ", где " + legsEricEricson.getName() + ", а где " + legsCarlsson.getName());
    }

    @Override
    public void crawl(String how) {

    }

    @Override
    public void breakIn(String how, int form, String when) {

    }

    @Override
    public void run(String how) {
        System.out.print(getName() + " тоже умел " + how + " бегать" + Words.ANDRIGHT.getName() + "сейчас это было необходимо");
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
    public String toString() {
        return "EricEricsonImpl{}";
    }
}
