import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatApp {
    private static final long NUMBER = 1000;

    public static void main(String[] args){
        display1K(NUMBER);
        displayDE(NUMBER);

        longUS(NUMBER);
        longDE(NUMBER);
    }

    private static void display1K(long sor) {
        NumberFormat snf = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        var res = snf.format(sor);
        System.out.println("dargestellt in K " + sor + " -> " + res);
    }

    private static void displayDE(long number) {
        NumberFormat snf = NumberFormat.getCompactNumberInstance(new Locale("de","DE"), NumberFormat.Style.SHORT);
        var res = snf.format(number);
        System.out.println("dargestellt in de " + number + " -> " + res);
    }

    private static void longUS(long number) {
        NumberFormat snf = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        var res = snf.format(number);
        System.out.println("dargestellt in K " + number + " -> " + res);
    }

    private static void longDE(long number) {
        NumberFormat snf = NumberFormat.getCompactNumberInstance(new Locale("de","DE"), NumberFormat.Style.LONG);
        var res = snf.format(number);
        System.out.println("dargestellt in de " + number + " -> " + res);
    }
}
