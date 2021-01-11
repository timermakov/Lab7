public class Main {

/*
Малыш надрывался от хохота.
Потом раздался грохот, сопровождаемый новым взрывом смеха.
Малыш старался быть как можно более спокойным, хотя смех так и клокотал в нём: Карлсон свалился прямо на него и Малыш уже не разбирал, где его ноги, а где ноги Карлсона.
Бетан могла их вот-вот настичь, поэтому они поползли на четвереньках.
В панике ворвались они в комнату Малыша как раз в тот момент, когда Бетан уже норовила их схватить.
Малыш тоже умел очень быстро бегать и, право, сейчас это было необходимо.
Они спаслись, захлопнув дверь перед самым носом Бетан.
Карлсон торопливо повернул ключ и весело засмеялся, в то время, как Бетан изо всех сил колотила в дверь.
Если бы Бетан не так сердилась, она бы услышала, что смеются двое.

КАРЛСОН ДЕРЖИТ ПАРИ

Однажды Малыш вернулся из школы злой, с шишкой на лбу.
Мама хлопотала на кухне.
Увидев шишку, она, как и следовало ожидать, огорчилась.
*/

    public static void main(String[] args) {

        // Создание объектов

        CarlssonImpl carlsson = new CarlssonImpl("Карлсон");
        carlsson.setAge(30);

        EricEricsonImpl ericEricson = new EricEricsonImpl("Малыш");
        ericEricson.setAge(7);

        BetanEricsonImpl betanEricson = new BetanEricsonImpl(1);
        betanEricson.setAge(14);

        MotherImpl mother = new MotherImpl(1);
        mother.setAge(37);

        TheyImpl they = new TheyImpl(2);

        Door door = new Door("дверь");
        Key key = new Key("ключ");

        Sound sound = new Sound("грохот") {
            @Override
            public void happened() {
                System.out.print(Words.THEN.getName() + "раздался " + getName());
            }
        };

        // Вывод первой части текста

        EricEricsonImpl.LaughContainer laughContainer = ericEricson.chooseLaugh();
        laughContainer.laughVeryLoud("надрывался от хохота");
        System.out.println(". ");

        sound.happened();
        System.out.print(", ");
        they.laugh("новым взрывом");
        System.out.println(". ");

        ericEricson.keepCalm();
        laughContainer.laughLoud("клокотал");
        System.out.print(": ");
        carlsson.fallDown("прямо на него");
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

        betanEricson.angry();
        System.out.print(", ");
        betanEricson.hear();
        they.laugh("смеются двое");
        System.out.println(". ");

        System.out.println();

        // Вывод второй части текста (новая глава)

        carlsson.bet();
        System.out.println();

        ericEricson.go("школы");
        ericEricson.angry();
        System.out.println(". ");

        mother.cook("на кухне");
        System.out.println(". ");

        mother.see("шишку");
        System.out.print(", ");
        mother.sad();
        System.out.println(". ");
    }

    @Override
    public String toString() {
        return "Main{}";
    }
}
