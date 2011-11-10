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
    
    /**
     * Test of getEntityManager method, of class DaftarUser.
     
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarUser instance = new DaftarUser();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of check method, of class DaftarUser.
     
    @Test
    public void testCheck() {
        System.out.println("check");
        String username = "";
        String password = "";
        DaftarUser instance = new DaftarUser();
        boolean expResult = false;
        boolean result = instance.check(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class DaftarUser.
    
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String username = "";
        String password = "";
        DaftarUser instance = new DaftarUser();
        User expResult = null;
        User result = instance.getUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class DaftarUser.
     */
    @Test
    public void testAddUser() {
        
        
        user1 = new User();
        user1.setNama("Ika");
        user1.setTipe(1);
        user1.setEmail("reychan05@gmail.com");
        user1.setTelp("085733523276");
        user1.setAlamat("Pacet");
        user1.setHape("085733523276");
        user1.setUsername("rindang");
        user1.setPassword("rindang");
        
        user2 = new User();
        user2.setNama("Ika");
        user2.setTipe(1);
        user2.setEmail("reychan05@gmail.com");
        user2.setTelp("085733523276");
        user2.setAlamat("Pacet");
        user2.setHape("085733523276");
        user2.setUsername("rindang");
        user2.setPassword("rindang");
        
        DaftarUser daftar = new DaftarUser();
        daftar.addUser(user1);
        
        assertEquals(1, daftar.getUsername("rindang").size());
        
        try{
            //Checking the duplication of username
            DaftarUser daftarLagi = new DaftarUser();
            daftarLagi.addUser(user2);
            //assertEquals(2, daftar.getUsername("rindang").size());
            //fail("seharusnya itu Eksepsi");

        }catch(Exception e){
            fail("seharusnya itu Eksepsi");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getUsers method, of class DaftarUser.
     
    @Test
    public void testGetUsers_0args() {
        System.out.println("getUsers");
        DaftarUser instance = new DaftarUser();
        List expResult = null;
        List result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class DaftarUser.
     
    @Test
    public void testGetUsers_User() {
        System.out.println("getUsers");
        User user = null;
        DaftarUser instance = new DaftarUser();
        instance.getUsers(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     * */
}
