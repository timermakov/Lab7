public class Main {

    @Override
    public String toString() {
        return "Main{}";
    }

    public static void main(String[] args) {
        String although = Words.ALTHOUGH.getName();

        CarlssonImpl carlsson = new CarlssonImpl("Карлсон");
        EricEricsonImpl ericEricson = new EricEricsonImpl("Малыш");
        TheyImpl they = new TheyImpl(2);
        BetanEricsonImpl betanEricson = new BetanEricsonImpl("Бетан");
        Door door = new Door("дверь");
        Key key = new Key("ключ");

        ericEricson.keepCalm();
        System.out.print(although);
        ericEricson.laugh();
        System.out.print(": ");
        carlsson.fallDown("прямо", new EricEricsonImpl("него"));
        ericEricson.doNotUnderstand();
        System.out.println(". ");

        betanEricson.overtake(" вот-вот ");
        they.crawl("на четвереньках");
        System.out.println(". ");

        they.breakIn("В панике ", 2, " как раз в тот момент, когда ");
        betanEricson.grab();
        System.out.println(". ");

        ericEricson.run("очень быстро");
        System.out.println(". ");

        they.saved(door);
        System.out.println(". ");

        carlsson.turn(" торопливо ", key);
        System.out.print(" и ");
        carlsson.laugh("весело");
        betanEricson.knock(" изо всех сил ", door);
        System.out.println(". ");
    }
}
