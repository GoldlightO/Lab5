import java.util.LinkedHashSet;
public class FilterPostalAddress{

    public void less (LinkedHashSet <Organization> org, String postalAddress) {
        for (Organization v : org) {
            if (Integer.parseInt(v.getPostalAddress().getZipCode()) < Integer.parseInt(postalAddress)){
                System.out.println(v.getPostalAddress().getZipCode());
            }else{
                System.out.println("Таких данных нет!");
            }
        }
    }

    public void greater (LinkedHashSet <Organization> org, String postalAddress) {
        for (Organization v : org) {
            if (Integer.parseInt(v.getPostalAddress().getZipCode()) > Integer.parseInt(postalAddress)){
                System.out.println(v.getPostalAddress().getZipCode());
            }else{
                System.out.println("Таких данных нет!");
            }
        }
    }
}