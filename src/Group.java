public class Group extends Contact{
    private Contact[] contactList;
    
    public Group(String nombre){
        super(nombre);
        contactList=new Contact[150];
    }
    
    public boolean isMember(int id){
        int i = 0;
        while(i<contactList.length && contactList[i]!=null){

            if (contactList[i] instanceof Group){
                if(((Group)contactList[i]).isMember(id)){
                    return true;
                }
            }
            if (contactList[i].getId()==id){
                return true;
            }
            i++;
        }
        return false;
    }
    
    public boolean add(Contact nuevo){
        if (!isMember(nuevo.getId())) {
            int i = 0;
            while (contactList[i]!=null) {
                i++;
            }
            contactList[i] = nuevo;
            return true;
        }
        return false;
    }
    
    public boolean remove(int id){
        if (isMember(id)) {
            int i = 0;
            while (contactList[i].getId()!=id) {
                i++;
            }
            contactList[i] = null;
            return true;
        }
        return false;
    }
    
    public Contact[] getContacts(){
        int count = 0;
        while (contactList[count]!=null) {
            count++;
        }

        Contact[] res = new Contact[count];
        int i = 0;
        while (contactList[i]!=null) {
            res[i] = contactList[i];
            i++;
        }
        return res;
    }
    
    @Override
    public String toString(){
        String res=getName()+"\n";
        for(int i=0;i<this.getContacts().length;i++){
            if (this.getContacts()[i]!=null) res += this.getContacts()[i]+"\n";
        }
        return res;
    }
}