public class EricEricsonImpl extends Human implements ChildrenAbilities {
    private String Name;
    private int Age;

    public EricEricsonImpl(String name) {
        setName(name);
    }

    @Override
    public void keepCalm() {
        System.out.print(getName() + " старался быть" + Words.ASPOSSIBLE.getName() + "спокойным");
    }

    public interface LaughContainer {
        void laughLoud(String how);
        void laughVeryLoud(String how);
    }

    public LaughContainer chooseLaugh() {
        class Laugh implements LaughContainer {
            public void laughLoud(String how) {
                System.out.print(Words.ALTHOUGH.getName() + "смех" + Words.SO.getName() + how + " в нём");
            }
            public void laughVeryLoud(String how) {
                System.out.print(getName() + " " + how);
            }
        }
        return new Laugh();
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
    public void go(String from) {
        System.out.print(Words.ONEDAY.getName() + getName() + " вернулся из " + from);
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
    public void angry() {
        Forehead foreheadEricEricson = this.new Forehead("лбу");
        Forehead.Bump bumpEricEricson = foreheadEricEricson.new Bump("шишкой");
        System.out.print(" злой, с " + bumpEricEricson.getName() + " на " + foreheadEricEricson.getName());
    }

    @Override
    public void hear() {

    }

    @Override
    public String toString() {
        return "EricEricsonImpl{}";
    }
}
