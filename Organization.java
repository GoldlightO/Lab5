public class Organization implements Comparable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Значение этого поля должно быть уникальным, Длина строки не должна быть больше 658, Поле может быть null
    private Long employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле может быть null

    public Organization(long id, String name, Coordinates coordinates, java.util.Date creationDate, int annualTurnover, String fullName, Long employeesCount, OrganizationType type, Address postalAddress) {
        setId(id);
        setName(name);
        setCoordinates(coordinates);
        setCreationDate(creationDate);
        setAnnualTurnover(annualTurnover);
        setFullName(fullName);
        setEmployeesCount(employeesCount);
        setType(type);
        setPostalAddress(postalAddress);
    }

    public void setId(long id) {
        try {
            if (id > 0) {
                this.id = id;
            } else {
                throw new Exception("Неверные данные. ID: \"id\" должен быть > 0.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public long getId() {
        return id;
    }

    public void setName(String name){
        try{
            if(name.length()>0){
                this.name=name;
            }
            else{
                throw new Exception("Неверные данные. В имени: \"name\" должно быть > 0 букв.");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public String getName() {
        return name;
    }

    public void setCoordinates(Coordinates coordinates){
        try{
            if(coordinates!=null){
                this.coordinates=coordinates;
            }
            else{
                throw new Exception("Неверные данные. Координаты: \"coordinates\" не должны равняться null.");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public Coordinates getСoordinates() {
        return coordinates;
    }

    public void setCreationDate(java.util.Date creationDate){
        try{
            if(creationDate!=null){
                this.creationDate=creationDate;
            }
            else{
                throw new Exception("Неверные данные. Дата создания: \"creationDate\" не должна равняться null.");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public void setAnnualTurnover(int annualTurnover){
        try{
            if(annualTurnover>0){
                this.annualTurnover=annualTurnover;
            }
            else{
                throw new Exception("Неверные данные. Введённые данные (annualTurnover): \"annualTurnover\" должны быть > 0.");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public int getAnnualTurnover() {
        return annualTurnover;
    }

    public void setFullName(String fullName){
        try{
            if(fullName.length()<=658){
                this.fullName=fullName;
            }
            else{
                throw new Exception("Неверные данные. Полное имя: \"fullName\" должны занимать < 658 символов и не быть равным null.");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public String getFullName() {
        return fullName;
    }

    public void setEmployeesCount(long employeesCount){
        try{
            if(employeesCount > 0){
                this.employeesCount=employeesCount;
            }
            else{
                throw new Exception("Неверные данные. Введённые данные (employeesCount): \"employeesCount\" должны быть > 0 и не быть равными null.");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public Long getEmployeesCount() {
        return employeesCount;
    }

    public void setType(OrganizationType type) {
        this.type=type;
    }

    public OrganizationType getType(){
        return type;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress=postalAddress;
    }

    public Address getPostalAddress(){
        return postalAddress;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
