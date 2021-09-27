package logic;

/**
 * Класс, отвечающий за запуск и завершение программы
 */

public class Main {

    public static void main(String[] args) {

        App app;
        try {
            byte[] b = new byte[1024];
            for (int r; (r = System.in.read(b)) != -1; ) {
                app = new App(args[0]);
                app.start();
            }
        }
        catch (Exception e) {
            System.out.println("Программа завершила выполнение");
            //app = new logic.App(args[0]);
            //e.printStackTrace();
        }

    }

}






