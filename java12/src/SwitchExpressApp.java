enum Month{
    JAN("Janunar"),FEB("Februar"),MAR("März"),APR("April"),MAI("Mai"),JUN("Juni"),JUL("Juli"),AUG("August"),SEP("September"),OKT("Oktober"),NOV("November"),DEZ("Dezember");

    String name;

    Month(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

public class SwitchExpressApp {
    final static String JAN = "Januar";
    final static String FEB = "Februar";
    final static String MAR = "März";
    final static String APR = "April";
    final static String MAI = "Mai";
    final static String JUN = "Juni";
    final static String JUL = "Juli";
    final static String AUG = "August";
    final static String SEP = "September";
    final static String OKT = "Oktober";
    final static String NOV = "November";
    final static String DEZ = "Dezember";

    public static void main (String args []){
        SwitchExpressApp app = new SwitchExpressApp();
        app.beforJava12(FEB);
        app.afterJava12(FEB);
        app.switchAssignment(FEB);
        app.switchWithEnum(Month.FEB);
    }

    private void beforJava12(String month) {
        String season = "";
        switch(month){
            case JAN:
            case FEB:
                season = "Winter";
                break;
            case MAR:
            case APR:
            case MAI:
            case JUN:
            case JUL:
            case AUG:
                season = "Sommer";
                break;
            case SEP:
            case OKT:
            case NOV:
            case DEZ:
                season = "Winter";
                break;
            default:
                season = null;

        }
        System.out.println("Monat "+ month + " ist im " + season);
    }

    private void afterJava12(String month) {
        String season = "";
        switch (month){
            case JAN,FEB -> season = "Winter";
            case MAR,APR,MAI,JUN,JUL,AUG -> season = "Sommer";
            case SEP,OKT,NOV,DEZ -> season = "Winter";
        }
        System.out.println("Monat "+ month + " ist im " + season);
    }

    private void switchAssignment(String month) {
        String season = switch (month){
            case JAN,FEB -> "Winter";
            case MAR,APR,MAI,JUN,JUL,AUG -> "Sommer";
            case SEP,OKT,NOV,DEZ -> "Winter";
            default -> null;
        };
        System.out.println("Monat "+ month + " ist im " + season);
    }

    private void switchWithEnum(Month month) {
        String season = switch (month){
            case JAN,FEB -> "Winter";
            case MAR,APR,MAI,JUN,JUL,AUG -> "Sommer";
            case SEP,OKT,NOV,DEZ -> "Winter";
            default -> null;
        };
        System.out.println("Monat "+ month.getName() + " ist im " + season);
    }

}
