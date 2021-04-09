package chatz.res;

public class Number {

    public static double round (double value, int precision) {
        int scale = (int) java.lang.Math.pow(10, precision);
        return (double) java.lang.Math.round(value * scale) / scale;
    }

}
