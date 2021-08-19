public class Address {
    private String zipCode; //Длина строки не должна быть больше 14, Поле может быть null

    public Address(String zipCode){
        setZipCode(zipCode);
    }

    public void setZipCode(String zipCode){
        try{
            if(zipCode.length()<=14){
                this.zipCode=zipCode;
            }
            else{
                throw new Exception("Слишком длинный адрес!");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getZipCode() {
        return zipCode;
    }
}
