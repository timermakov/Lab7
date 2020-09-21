class FirstLab {
    static final int G_SIZE = 16;
    static final int X_SIZE = 20;
    static final int K_ROWS_SIZE = G_SIZE;
    static final int K_COLUMNS_SIZE = X_SIZE;

    static short[] g = new short[G_SIZE];
    static float[] x = new float[X_SIZE];
    static double[][] k = new double[K_ROWS_SIZE][K_COLUMNS_SIZE];

    // заполняет одномерный массив d типа short числами
    // от 2 до 17 включительно в порядке убывания
    public static void make_g_array() {
        for(short i = G_SIZE-1; i >= 0; i--) {
            g[i] = (short) (i+2);
        }
    }

    // заполняет одномерный массив x типа float
    // 20 случайными числами в диапазоне от -6.0 до 3.0
    public static void make_x_array() {
        for(int i = 0; i < X_SIZE; i++) {
            x[i] = (float) (-6 + Math.random()*9); // случайные дробные числа от -6 до 3
        }
    }

    // заполняет двумерный массив d размером 16x20
    // рядами чисел, посчитанными по трём данным формулам
    public static void make_k_array() {
        for (int i = 0; i < K_ROWS_SIZE; i++) {
            for (int j = 0; j < K_COLUMNS_SIZE; j++) {
                if (i==13) k[i][j]=Math.pow(Math.E, Math.asin((x[j]-1.5)/9.0));
                else if (i==2 || i==4 || i==8 || i==9 || i==10 || i==11 || i==12 || i==14)
                    k[i][j] = Math.cbrt(Math.pow(Math.cbrt(x[j]),3));
                else k[i][j] = Math.tan(Math.log(Math.pow(Math.tan(Math.sin(Math.pow(Math.E,x[j]))),2)));
            }
        }
    }

    // вывод массива в формате с 3 знаками после запятой
    public static void print_k_array() {
        for (int i = 0; i < K_ROWS_SIZE; i++) {
            for (int j = 0; j < K_COLUMNS_SIZE; j++) {
                System.out.printf("%8.3f", k[i][j]);
            }
            System.out.println();
        }
    }

    // main, запускающий методы
    public static void main(String[] args) {
        make_g_array();
        make_x_array();
        make_k_array();
        print_k_array();

    }
}