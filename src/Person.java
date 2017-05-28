public class Person extends Contact {
    private String telNumber; 
    
    public Person(String name, String telNumber){
        super(name);
        this.telNumber = telNumber; 
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.telNumber; 
    }
}