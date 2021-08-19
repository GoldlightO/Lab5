import java.util.*;

public class CompareOrganizations {
    public static ArrayList<Organization> compare(LinkedHashSet<Organization> set){
        ArrayList<Organization> tableValues = new ArrayList<Organization> (set);
        Comparator<Organization> ocomp= new OrganizationComporator.ComporatorByName().thenComparing(new OrganizationComporator.ComporatorByAnnualTurnover());
        Collections.sort(tableValues,ocomp);
        for(Organization p: tableValues){
            System.out.println(p.getName() + " " + p.getAnnualTurnover());
        }
        return tableValues;
    }
}