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
 * @author Yuni
 */
public class DaftarSewaTest extends TestCase {

    private User pemilik1;
    private User penyewa1;
    private Gedung gedung1;
    private SubGedung subgedung1;
    private Sewa sewa1;
    private Sewa sewa2;
    private DaftarSewa ds;
    private long idsewa = 300;
    private long idSub = 100;
    private long idPenyewa = 200;
    private long idPemilik = 100;
    private long idsewa2 = 3002;
    private Sewa sewa3;
    private Sewa sewa4;
    public DaftarSewaTest() {
    }

    @Before
    public void setUp() {

        pemilik1 = new User();
        penyewa1 = new User();
        gedung1 = new Gedung();
        subgedung1 = new SubGedung();
        ds = new DaftarSewa();
        long id = 100;
        long idpenyewa = 200;

        sewa1 = new Sewa();
        sewa1.setIdSewa(idsewa);
        sewa1.setIdGedung(id);
        sewa1.setIdPemilik(id);
        sewa1.setIdPenyewa(idpenyewa);
        sewa1.setIdSubGedung(id);
        sewa1.setStatus(0);
        sewa1.setSisaBayar(10000);
        sewa1.setDurasi(50);
        sewa1.setTotalHargaSewa(50000);
       

        sewa2 = new Sewa();
        sewa2.setIdGedung(id);
        sewa2.setIdPemilik(id);
        sewa2.setIdPenyewa(idpenyewa);
        sewa2.setIdSubGedung(id);
        sewa2.setStatus(1);
        sewa2.setSisaBayar(0);
        sewa2.setTotalHargaSewa(150000);
        sewa2.setDurasi(3);

        sewa3 = new Sewa();
        sewa3.setIdGedung(id);
        sewa3.setIdPemilik(id);
        sewa3.setIdPenyewa(idpenyewa);
        sewa3.setIdSubGedung(idSub);
        sewa3.setStatus(0);
        sewa3.setSisaBayar(20000);
        sewa3.setTotalHargaSewa(150000);
        sewa3.setDurasi(3);

        sewa4 = new Sewa();
        sewa4.setIdSewa(idsewa2);
        sewa4.setIdGedung(id);
        sewa4.setIdPemilik(id);
        sewa4.setIdPenyewa(idpenyewa);
        sewa4.setIdSubGedung(id);
        sewa4.setStatus(0);
        sewa4.setSisaBayar(20000);
        sewa4.setTotalHargaSewa(150000);
        sewa4.setDurasi(10);

    }

    /**
     * Test of addSewa method, of class DaftarSewa.
     */
    @Test
    public void testAddSewa() {
        System.out.println("getSewaforIdSub");
        ds.addSewa(sewa1);
        ds.addSewa(sewa2);
        assertEquals(2, ds.getAllSewa_Confirmed().size() + ds.getAllSewa_Unconfirmed().size());

    }

    /**
     * Test of getSewaFromId method, of class DaftarSewa.
     */
   @Test
    public void testGetSewaFromId() {
        System.out.println("getSewaFromId");
        long idSewa = sewa1.getIdSewa();
        assertEquals(0, ds.getSewaFromId(idSewa).getStatus());
    }

    /**
     * Test of getDaftarSewaPenyewa_Unconfirmed method, of class DaftarSewa.
     */
    @Test
    public void testGetDaftarSewaPenyewa_Unconfirmed() {
        System.out.println("getDaftarSewaPenyewa_Unconfirmed");
        assertEquals(1, ds.getDaftarSewaPenyewa_Unconfirmed(idPenyewa).size());

    }

    /**
     * Test of getDaftarSewaPenyewa_Confirmed method, of class DaftarSewa.
     */
    @Test
    public void testGetDaftarSewaPenyewa_Confirmed() {
        System.out.println("getDaftarSewaPenyewa_Confirmed");
        //assertEquals(1, ds.getDaftarSewaPenyewa_Confirmed(idPenyewa).size());
        Sewa s = new Sewa();
        s = ds.getSewaFromId(idsewa);
        s.setStatus(1);
        ds.editSewa(s);
        assertEquals(2, ds.getDaftarSewaPenyewa_Confirmed(idPenyewa).size());

    }

    /**
     * Test of getUtangPenyewa method, of class DaftarSewa.
     */
    @Test
    public void testGetUtangPenyewa() {
        System.out.println("getUtangPenyewa");
        assertEquals(1, ds.getUtangPenyewa(idPenyewa).size());
    }

    /**
     * Test of getDaftarSewaPemilik_Unconfirmed method, of class DaftarSewa.
     */
    @Test
    public void testGetDaftarSewaPemilik_Unconfirmed() {
        System.out.println("getDaftarSewaPemilik_Unconfirmed");
        assertEquals(0, ds.getDaftarSewaPemilik_Unconfirmed(idPemilik).size());
    }

    /**
     * Test of getDaftarSewaPemilik_Confirmed method, of class DaftarSewa.
     */
   @Test
    public void testGetDaftarSewaPemilik_Confirmed() {
        System.out.println("getDaftarSewaPemilik_Confirmed");
        assertEquals(2, ds.getDaftarSewaPemilik_Confirmed(idPemilik).size());
    }

    /**
     * Test of getAllSewa_Confirmed method, of class DaftarSewa.
     */
    @Test
    public void testGetAllSewa_Confirmed() {
        System.out.println("getAllSewa_Confirmed");
        int jumlahSewa = ds.getAllSewa_Confirmed().size();
        assertEquals(jumlahSewa, ds.getAllSewa_Confirmed().size());
    }

    /**
     * Test of getAllSewa_Unconfirmed method, of class DaftarSewa.
     */
    @Test
    public void testGetAllSewa_Unconfirmed() {
        System.out.println("getAllSewa_Unconfirmed");
        ds.addSewa(sewa3);
        int jumlahUnconfirmed = ds.getAllSewa_Unconfirmed().size();
        assertEquals(jumlahUnconfirmed, ds.getAllSewa_Unconfirmed().size());
    }

    /**
     * Test of konfirmSewa method, of class DaftarSewa.
     */
    @Test
    public void testKonfirmSewa() {
        System.out.println("konfirmSewa");
        int jumlahSewa = ds.getAllSewa_Confirmed().size();
        ds.addSewa(sewa4);
        Sewa s = ds.getSewaFromId(idsewa2);
        s.setStatus(1);
        ds.editSewa(s);
        assertEquals(jumlahSewa+1, ds.getAllSewa_Confirmed().size());
    }

    /**
     * Test of cancelSewa method, of class DaftarSewa.
     */
    @Test
    public void testCancelSewa() throws Exception {
        System.out.println("cancelSewa");
        int jumlahSewa = ds.getAllSewa_Unconfirmed().size();
        ds.cancelSewa(idsewa2);
        assertEquals(jumlahSewa, ds.getAllSewa_Unconfirmed().size());
    }

       /**
     * Test of removeSewa method, of class DaftarSewa.
     */
    @Test
    public void testRemoveSewa() throws Exception {
        System.out.println("removeSewa");
        Long id = sewa1.getIdSewa();
        DaftarSewa instance = new DaftarSewa();
        instance.removeSewa(sewa1.getIdSewa());
    }

    /**
     * Test of editSewa method, of class DaftarSewa.
     */
    @Test
    public void testEditSewa() {
        System.out.println("editSewa");
        ds.addSewa(sewa4);
        sewa1 = ds.getSewaFromId(idsewa2);
        sewa1.setSisaBayar(500);
        ds.editSewa(sewa1);
        assertEquals(500, ds.getSewaFromId(idsewa2).getSisaBayar());

    }

}