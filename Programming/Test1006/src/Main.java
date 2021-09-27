import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        /*
        Set set = new LinkedHashSet<>();
        set.add(7);
        set.add(5);
        set.add(6);
        set.add(3);
        set.add(4);
        set.add(6);
        set.remove(3);
        System.out.println(set);
         */
        /*
        Stream.of("red", "orange", "yellow", "green", "blue", "indigo",
                "violet")
                .filter(s -> s.length() >= 5)
                .map(s -> delFirst(s))
                .skip(3)
                .sorted()
                .forEachOrdered(System.out::print);

         */
        (Integer i) -> i.toHexString();
    }

    public static String delFirst(String s) {
        return s.substring(1);
    }
}

