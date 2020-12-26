public class CarlssonImpl extends Human implements ManAbilities {
    private String Name;
    private int Age;

    public CarlssonImpl(String name) {
        setName(name);
    }
    @Override
    public void fallDown(String how, EricEricsonImpl him) {
        System.out.print(getName() + " свалился " + how + " на " + him.getName());
    }

    @Override
    public void breakIn(String how, int form, String when) {

    }

    @Override
    public void turn(String how, Door.Key key) {
        System.out.print( getName() + how + "повернул " + key.getName());
    }

    @Override
    public void laugh(String how) {
        System.out.print(how + " засмеялся");
    }

    @Override
    public void bet() {
        System.out.println("КАРЛСОН ДЕРЖИТ ПАРИ");
    }

    @Override
    public void cook(String where) {

    }

    @Override
    public void see(String what) {

    }

    @Override
    public void sad() {

    }


    @Override
    public String toString() {
        return "CarlssonImpl{}";
    }
}
