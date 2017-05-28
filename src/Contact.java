public abstract class Contact {
    private String name;
    private int id;
    private static int maxId = 0;
    
    public Contact(String contactName) {
        name = contactName;
        id = ++maxId;
    }
    
    public int getId() {
        return id; 
    }
    
    public String getName() {
        return name; 
    }

}