import java.util.LinkedHashSet;
import java.util.Random;

public class CreatId {
    private static final Random r = new Random();
    public static long randId(LinkedHashSet <Organization> org) {
        long id;
        id = r.nextInt(99999999);
        for (Organization v : org) {
            if (v.getId()==id){
                id=r.nextInt(99999999);
            }
        }
        return id;
    }
}
