import java.util.LinkedHashSet;

public class SearchAT {
    public static Organization search(LinkedHashSet<Organization> org, int annualTurnover){
        for (Organization var:org) {
            if (var.getAnnualTurnover()==annualTurnover) {
                org.remove(var);
                System.out.println("Элемент с таким ежегодным оборотом был удалён: " + annualTurnover);
            }
        }
        return null;
    }
}
