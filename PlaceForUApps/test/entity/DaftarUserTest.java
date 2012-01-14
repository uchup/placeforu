/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.EntityManager;
import junit.framework.TestCase;
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
public class DaftarUserTest extends TestCase {

    private User user1;
    private User user2;
    private User user3;

    DaftarUser daftar = new DaftarUser();

    public DaftarUserTest(String testName) {
        super(testName);
    }

     @Override
    protected void setUp() throws Exception {
        super.setUp();

        user1 = new User();
        user1.setNama("Ika");
        user1.setTipe(1);
        user1.setEmail("reychan05@gmail.com");
        user1.setTelp("085733523276");
        user1.setAlamat("Pacet");
        user1.setHape("085733523276");
        user1.setUsername("ling1");
        user1.setPassword("amalia");


        user2 = new User();
        user2.setNama("Ika");
        user2.setTipe(1);
        user2.setEmail("reychan05@gmail.com");
        user2.setTelp("085733523276");
        user2.setAlamat("Pacet");
        user2.setHape("085733523276");
        user2.setUsername("ling2");
        user2.setPassword("ika");
        user2.setStatus(0);
        long id = 2;
        user2.setId(id);

        user3 = new User();
        user3.setNama("yuni");
        user3.setTipe(1);
        user3.setEmail("yuni@gmail.com");
        user3.setTelp("085733523276");
        user3.setAlamat("sda");
        user3.setHape("085733523276");
        user3.setUsername("yuni");
        user3.setPassword("nene");
        user3.setStatus(1);

// bagian ini dilakukan pengetesan pada method addUser() --> method yg dipakai utk menambah user

        daftar.addUser(user1);
        assertEquals(1, daftar.getUsername("ling1").size());

        try {
            //Checking the duplication of username
            DaftarUser daftarLagi = new DaftarUser();
            daftarLagi.addUser(user2);
        } catch (Exception e) {
            fail("seharusnya itu Eksepsi");
        }
    }

// bagian ini dilakukan pengetesan pada method editUser() --> utk mengedit profil pengguna

   public void testEditUser (){
        System.out.println("EditUser");
        user1 = daftar.getUserFromName(user1.getUsername());
        user1.setNama(user3.getNama());
        user1.setPassword(user3.getPassword());
        user1.setUsername(user3.getUsername());
        daftar.editUser(user1);
        assertEquals(user3.getNama(), daftar.getUserFromName(user1.getUsername()).getNama());

    }

// bagian ini dilakukan pengetesan pada method GetCheck()
    public void testCheck() {
        System.out.println("Check");
        assertTrue(daftar.check(user2.getUsername(),user2.getPassword()));
    }

// bagian ini dilakukan pengetesan pada method GetUsers() --> method yg dipakai utk melihat daftar seluruh pengguna
    public void testGetUsers(){

    System.out.println("getUsers");
    assertEquals(2, daftar.getUsers().size());

    }

// bagian ini dilakukan pengetesan pada method GetUserFromName() --> metod yg dipakai utk mengambil data satu pengguna pada tabel User berdasarkan parameter username
    public void testGetUserFromName(){
        System.out.println("GetUserFromName");
        assertEquals("ling1",daftar.getUserFromName(user1.getUsername()).getUsername());

    }

// bagian ini dilakukan pengetesan pada method CheckUser() --> utk mengecek keberadaan pengguna brdasarkan username -> dipakai pada servlet melihat profil pemilik&penyewa
     public void testCheckUser() {
        System.out.println("CheckUser");
        assertTrue(daftar.checkUser(user2.getUsername()));
    }

// bagian ini dilakukan pengetesan pada method GetUsername()
    public void testGetUsername(){
    System.out.println("getUsername");
    String username = user2.getUsername();
    assertEquals(1, daftar.getUsername(username).size());

    }

// bagian ini dilakukan pengetesan pada method GetUserfromId()
    public void testGetUserfromId(){
    System.out.println("getUserFromId");
    long id = user2.getId();
    assertEquals("Ika", daftar.getUserFromId(id).getNama());


    }


// bagian ini dilakukan pengetesan pada method tearDown()
     @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        System.out.println("deleteUSer");
// bagian ini dilakukan pengetesan pada method deleteUser()--> metod yg dipakai utk menghapus pegguna
        daftar.deleteUser(daftar.getUserFromName(user1.getUsername()).getId());


    }
 // bagian ini dilakukan pengetesan pada method GetUnconfirmedUsers()
    public void testGetUnconfirmedUsers(){

    System.out.println("getUnconfirmedUsers");
    assertEquals(2, daftar.getUnconfirmedUsers().size());

    }
}

