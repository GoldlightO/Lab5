import java.util.*;
public class RemoveGreater {

    public static LinkedHashSet<Organization> remGr (LinkedHashSet<Organization> set, long id){
        ArrayList<Organization> tableValues = new ArrayList<Organization> (set);
        Comparator<Organization> ocomp= new OrganizationComporator.ComporatorByName().thenComparing(new OrganizationComporator.ComporatorByAnnualTurnover());
        Collections.sort(tableValues,ocomp);
        for(Organization o:tableValues){
            if(tableValues.indexOf(o) < tableValues.indexOf(SearchId.search(set,id))){
                set.remove(o);
            }
        }
        System.out.println("Элементы удалены!");
        return set;
    }
}
