public class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRole() {
        return "Community Member";
    }
    
    public String toString() {
        return getRole() + ": " + name;
    }
}
