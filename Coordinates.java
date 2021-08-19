public class Coordinates {
    private long x; //Максимальное значение поля: 855
    private double y; //Максимальное значение поля: 872
    public Coordinates (long x, double y){
        setX(x);
        setY(y);
    }

    public void setX(long x){
        try{
            if(x < 856){
                this.x = x;
            }
            else{
                throw new Exception("Неверные данные. Координата \"x\" должна быть < 856.");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void setY(double y){
        try{
            if(y < 873){
                this.y = y;
            }
            else{
                throw new Exception("Неверные данные. Координата \"y\" должна быть < 873.");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public long getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
