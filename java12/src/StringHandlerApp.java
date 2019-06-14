public class StringHandlerApp {

    public static void main(String[] args){
        indentExample();
        transformExample();
    }

    private static void indentExample() {
        var jff = "Ich lerne Java einfach und direkt \nindem ich Java Fast Forward Videos ansehe";
        System.out.println(jff.indent(60));
        System.out.println(jff.indent(10));
    }


    private static void transformExample() {
        var jff = "Java".transform(s -> s + " Fast Forward");
        System.out.println(jff);
    }
}
