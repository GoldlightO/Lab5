import java.util.Comparator;

public class OrganizationComporator {
        public static class ComporatorByName implements Comparator<Organization> {
            public int compare(Organization o1, Organization o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        }
        public static class ComporatorByAnnualTurnover implements Comparator<Organization> {
            public int compare(Organization o1, Organization o2) {
                if(o1.getAnnualTurnover()> o2.getAnnualTurnover())
                    return 1;
                else if(o1.getAnnualTurnover()< o2.getAnnualTurnover())
                    return -1;
                else
                    return 0;
            }
        }
    }


