public class CarlssonImpl extends Human implements ManAbilities {
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
    public void turn(String how, Key key) {
        System.out.print( getName() + how + "повернул " + key.getName());
    }

    @Override
    public void laugh(String how) {
        System.out.print(how + " засмеялся");
    }

    @Override
    public String toString() {
        return "CarlssonImpl{}";
    }
}
