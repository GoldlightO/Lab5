import java.util.LinkedHashSet;

public class SearchId {
    public static Organization search(LinkedHashSet<Organization> org, long id){
        for (Organization var:org) {
            if (var.getId()==id)
                return var;
        }
        return null;
    }
}