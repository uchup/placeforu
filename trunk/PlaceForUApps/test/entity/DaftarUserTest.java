/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ika
 */
public class DaftarUserTest {
    
    private User user1;
    private User user2;
    DaftarUser daftar = new DaftarUser();
    
    public DaftarUserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAddUser() {
        
        
        user1 = new User();
        user1.setNama("Ika");
        user1.setTipe(1);
        user1.setEmail("reychan05@gmail.com");
        user1.setTelp("085733523276");
        user1.setAlamat("Pacet");
        user1.setHape("085733523276");
        user1.setUsername("ling");
        user1.setPassword("amalia");
        
        user2 = new User();
        user2.setNama("Ika");
        user2.setTipe(1);
        user2.setEmail("reychan05@gmail.com");
        user2.setTelp("085733523276");
        user2.setAlamat("Pacet");
        user2.setHape("085733523276");
        user2.setUsername("ling");
        user2.setPassword("amalia");
        
        
        
        daftar.addUser(user1);
        
        assertEquals(1, daftar.getUsername("ling").size());
        
        try {
            //Checking the duplication of username
            DaftarUser daftarLagi = new DaftarUser();
            daftarLagi.addUser(user2);
        } catch (Exception e) {
            fail("seharusnya itu Eksepsi");
        }
        // TODO review the generated test code and remove the default call to fail.

    }
    
    public void testCheck() {
        String usr = "ling";
        String pwd = "amalia";
        
        daftar.check(usr, pwd);
        assertEquals(1,daftar.check(usr, pwd));
    }
    
    public void testGetUser(){
        String usr = "ling";
        String pwd = "amalia";
        
        assertEquals(1,daftar.getUser(usr, pwd));
    }

  /** public void testEditUser (){
        user1 = uq.getUser(user1.getUsername());
        user1.setNama(user2.getNama());
        uq.editUser(user1);
        assertEquals(user2.getNama(), uq.getUser(user1.getUsername()).getNama());
    }**/



}
