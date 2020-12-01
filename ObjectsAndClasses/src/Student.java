public
class Student {
    private String firstName;
    private String secondName;
    private int age;
    private String city;
//constructor
    public
    Student (String firstName, String secondName, int age, String city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.city = city;
    }


    //getters
    public String getCity(){
        return this.city;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getSecondName(){
        return this.secondName;
    }
    public int getAge(){
        return this.age;
    }

    public
    void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public
    void setSecondName (String secondName) {
        this.secondName = secondName;
    }

    public
    void setAge (int age) {
        this.age = age;
    }

    public
    void setCity (String city) {
        this.city = city;
    }
}
