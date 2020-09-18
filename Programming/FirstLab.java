class FirstLab {

    public static void main(String[] args) {
        // одномерный массив d типа short, содержащий числа
        // от 2 до 17 включительно в порядке убывания
        short[] g = new short[16];
        for(short i = 15; i >= 0; i--) {
            g[i] = (short) (i+2);
        }

        // одномерный массив x типа float, содержащий
        // 20 случайных числел в диапазоне от -6.0 до 3.0
        float[] x = new float[20];
        for(int i = 0; i < 20; i++) {
            x[i] = (float) (-6 + Math.random()*9);
        }

        // двумерный массив d размером 16x20, содержащий
        // ряды чисел, посчитанных по трём формулам
        double[][] k = new double[16][20];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 20; j++) {
                if (i==13) k[i][j]=Math.pow(Math.E, Math.asin((x[j]-1.5)/9.0));
                else if (i==2 || i==4 || i==8 || i==9 || i==10 || i==11 || i==12 || i==14)
                    k[i][j] = Math.cbrt(Math.pow(Math.cbrt(x[j]),3));
                else k[i][j] = Math.tan(Math.log(Math.pow(Math.tan(Math.sin(Math.pow(Math.E,x[j]))),2)));
            }
        }

        // вывод массива в формате с 3 знаками после запятой
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.printf("%8.3f", k[i][j]);
            }
            System.out.println();
        }
    }
}