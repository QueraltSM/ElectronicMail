import org.junit.*;
import static org.junit.Assert.*;

public class MessengerTest{
    private Person p1, p2, p3, p4, p5;
    private Group g1, g2, g3;
    
    @Before
    public void inicializar(){
        p1 = new Person("Belén", "15625178");
        p2 = new Person("", "23425517");  
        p3 = new Person("Daniela", "15699987"); 
        p4 = new Person("","");
        p5 = new Person("Juan", "");
        g1 = new Group("Primos");
        g2 = new Group("Familia");
        g3 = new Group("");
        g1.add(p1);
        g1.add(p2);
        g1.add(p3);
        g2.add(g1);
    }
    
    @After
    public void ending(){
        System.out.println("Test finalizado correctamente.");
    }
    
    /* CLASE: PERSON */
    /* Probando: Constructor de la clase Person. */
    @Test
    public void testConstructorPerson(){
        assertTrue("Prueba 1 Person(): ", (p1.toString().equals("Belén: 15625178")));
        assertTrue("Prueba 2 Person(): ", (p2.toString().equals(": 23425517")));
        assertTrue("Prueba 3 Person(): ", (p4.toString().equals(": ")));
    }
    
    /* Probando: Método toString(). */
    @Test
    public void testToString() {
        assertTrue("Prueba 1 toString(): ", (p4.toString().equals(": ")));
        assertTrue("Prueba 2 toString(): ", (p5.toString().equals("Juan: ")));
        assertEquals("Prueba 3 Person(): ", "Juan: ", p5.toString());
    }
    
    /* CLASE: GROUP */
    /* Probando: Constructor de la clase Group. */
    @Test
    public void testConstructorGroup(){
        assertTrue("Prueba 1 Group(): ",(g1.getName()).equals("Primos"));
        assertFalse("Prueba 2 Group(): ",g2.getName().equals("Tíos"));
        assertEquals("Prueba 3 Group(): ","",g3.getName());
    }
    
    /* Probando: Método isMember(). */
    @Test
    public void testIsMember() {
        assertTrue("Prueba 1 isMember(): ",g1.isMember(p1.getId()));
        assertTrue("Prueba 2 isMember(): ",g2.isMember(p1.getId()));
        assertFalse("Prueba 3 isMember(): ",g1.isMember(p4.getId()));
        assertFalse("Prueba 4 isMember(): ",g2.isMember(p5.getId()));
    }
    
    /* Probando: Método add(). */
    @Test
    public void testAdd() {
        assertEquals("Prueba 1 add(): ",true, g1.isMember(p1.getId()));
        assertEquals("Prueba 2 add(): ",false, g2.isMember(p5.getId()));
        assertEquals("Prueba 3 add(): ", true, g2.isMember(g1.getId()));
    }
    
    /* Probando: Método remove(). */
    @Test
    public void testRemove() {
        g1.remove(p3.getId());
        g2.remove(g1.getId());
        assertEquals("Prueba 1 remove(): ", false, g1.isMember(p3.getId()));
        assertEquals("Prueba 2 remove(): ", false, g2.isMember(g1.getId()));
        assertEquals("Prueba 3 remove(): ", true, g1.isMember(p2.getId()));
    }
   
    /* Probando: Método getContacts(). */
    @Test
    public void testGetContacts() {
        Contact[] auxArray = new Contact[]{p1, p2, p3}; 
        Contact[] auxArray1 = new Contact[]{g1};
        Contact[] auxArray2 = new Contact[0];
        assertArrayEquals("Prueba 1 getContacts(): ", auxArray, g1.getContacts());
        assertArrayEquals("Prueba 2 getContacts(): ", auxArray1, g2.getContacts());
        assertArrayEquals("Prueba 3 getContacts(): ", auxArray2, g3.getContacts());
    }
    
    /* Probando: Método toString(). */
    @Test
    public void getToStringGroup() {
        String result = "Primos\nBelén: 15625178\n: 23425517\nDaniela: 15699987\n";
        String result1 = "Familia\nPrimos\nBelén: 15625178\n: 23425517\nDaniela: 15699987\n\n";
        String result2 = "\n";
        assertEquals("Prueba 1 toString(): ", result, g1.toString());
        assertEquals("Prueba 2 toString(): ", result1, g2.toString());
        assertEquals("Prueba 3 toString(): ", result2, g3.toString());
    }
}