package Lab5;

/**
 * Класс, отвечающий за запуск и завершение программы
 */

public class Main {

    public static void main(String[] args) {

        App app;
        try {
            byte[] b = new byte[1024];
            for (int r; (r = System.in.read(b)) != -1; ) {
                //String buffer = new String(b, 0, r);
                //System.out.println(buffer);

                app = new App(args[0]);
                app.start();
            }
    } catch (Exception e) {
            System.out.println("Программа завершила выполнение");
        //app = new App(args[0]);
        //e.printStackTrace();
    }

    }

}






