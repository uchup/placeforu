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

    @Test
    public void testAddUser() {


        user1 = new User();
        user1.setNama("Ika");
        user1.setTipe(1);
        user1.setEmail("reychan05@gmail.com");
        user1.setTelp("085733523276");
        user1.setAlamat("Pacet");
        user1.setHape("085733523276");
        user1.setUsername("tuit");
        user1.setPassword("amalia");

        user2 = new User();
        user2.setNama("Ika");
        user2.setTipe(1);
        user2.setEmail("reychan05@gmail.com");
        user2.setTelp("085733523276");
        user2.setAlamat("Pacet");
        user2.setHape("085733523276");
        user2.setUsername("tuit");
        user2.setPassword("amalia");
        
        
        DaftarUser daftar = new DaftarUser();
        
        boolean hasilCheck1 = daftar.checkUser("tuit");
            if (!hasilCheck1) {
               daftar.addUser(user1);
            } else {
                System.out.println("Username sudah ada");
            }
        assertEquals(1, daftar.getUsername("tuit").size());

        try {
            //Checking the duplication of username
            DaftarUser daftarLagi = new DaftarUser();
            boolean hasilCheck = daftarLagi.checkUser("tuit");
            if (!hasilCheck) {
                daftarLagi.addUser(user2);
            } else {
                System.out.println("Username sudah ada");
            }
            //assertEquals(2, daftar.getUsername("rindang").size());
            //fail("seharusnya itu Eksepsi");

        } catch (Exception e) {
            fail("seharusnya itu Eksepsi");
        }
        // TODO review the generated test code and remove the default call to fail.

    }
}
