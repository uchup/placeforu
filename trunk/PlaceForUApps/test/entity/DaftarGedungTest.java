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
public class DaftarGedungTest extends TestCase{

    private User user1;
    private User user2;
    private Gedung gedung1;
    private Gedung gedung2;
    DaftarGedung dg = new DaftarGedung();

    public DaftarGedungTest(String testName) {
        super(testName);
    }

    @Before
    public void setUp() throws Exception {
         super.setUp();

    gedung1 = new Gedung();

    gedung1.setNamaGedung("Kusuma");
    gedung1.setTipeGedung("indoor");
    gedung1.setAlamatGedung("jl nanas");
    gedung1.setDeskripsiGedung("nanana");
    gedung1.setEmailGedung("a@gmail.com");
    gedung1.setFasilitasGedung("lalalla");
    gedung1.setKategoriGedung("Pernikahan");
    gedung1.setKotaGedung("garut");
    gedung1.setPropinsiGedung("Jawa Barat");
    gedung1.setTelpGedung("7888");
    long idgedung =155;
    gedung1.setId(idgedung);
    gedung1.setIdPemilik(idgedung);

    gedung2 = new Gedung();

    gedung2.setNamaGedung("Keraton");
    gedung2.setTipeGedung("outdoor");
    gedung2.setAlamatGedung("jl nanas");
    gedung2.setDeskripsiGedung("nanana");
    gedung2.setEmailGedung("a@gmail.com");
    gedung2.setFasilitasGedung("lalalla");
    gedung2.setKategoriGedung("Pernikahan");
    gedung2.setKotaGedung("garut");
    gedung2.setPropinsiGedung("Jawa Barat");
    gedung2.setTelpGedung("7888");

    }


    @Test // bagian ini dilakukan pengetesan pada method addGedung() --> method yg dipakai utk menambahkan gedung
    public void testAddGedung() {
    System.out.println("AddGedung");
        dg.addGedung(gedung1);
        dg.addGedung(gedung2);
    }

    @Test // bagian ini dilakukan pengetesan pada method EditGedung() --> method yg dipakai utk menambahkan gedung
    public void testEditGedung() {
    System.out.println("EditGedung");
        gedung1 = dg.getGedung(gedung1.getId());
        gedung1.setNamaGedung(gedung2.getNamaGedung());
        dg.editGedung(gedung1);
        assertEquals(gedung2.getNamaGedung(), dg.getGedung(gedung1.getId()).getNamaGedung());

    }
    /**
     * bagian ini dilakukan pengetesan pada method CheckGedung() --> method yg dipakai utk melakukan pengecekan
       gedung dengan parameter nama gedung dan id pemilik gedung
     */
     @Test
    public void testCheckGedung() {
        System.out.println("checkGedung");
        String namaGedung = gedung1.getNamaGedung();
        long idPemilik = gedung1.getId();
        DaftarGedung instance = new DaftarGedung();
        boolean expResult = dg.cekGedungPemilik(gedung1.getNamaGedung(), gedung1.getId());
        boolean result = instance.cekGedungPemilik(namaGedung, idPemilik);

        assertEquals(expResult, result);
    }

    /**
     * bagian ini dilakukan pengetesan pada method GetDaftarGedung() --> method yg dipakai utk mengambil daftar gedung

     */

     @Test
    public void testGetDaftarGedung_0args() {
        System.out.println("getDaftarGedung");
        assertEquals(2, dg.getDaftarGedung().size());
    }


    /**
     * bagian ini dilakukan pengetesan pada method GetDaftarGedungPemilik() --> method yg dipakai utkmengambil daftar gedung
     berdasarkan id pemilik
     */
    @Test
    public void testGetDaftarGedungPemilik() {
        System.out.println("getDaftarGedungPemilik");
        long idpemilik = gedung1.getIdPemilik();
        assertEquals(1, dg.getDaftarGedungPemilik(idpemilik).size());

    }

    /**
     * bagian ini dilakukan pengetesan pada method GetGedung() --> method yg dipakai utk mendapatkan gedung brdasarkan id gedung
     */
    @Test
    public void testGetGedung() {
        System.out.println("getGedung");
        long idpemilik = gedung1.getIdPemilik();
        assertEquals(gedung1.getEmailGedung(), dg.getGedung(gedung1.getId()).getEmailGedung());

    }

    /**
     * bagian ini dilakukan pengetesan pada method DeleteGedung() --> method yg dipakai utk menghapus gedung brdasarkan id gedung
     */
    @Test
    public void testDeleteGedung() throws Exception {
        System.out.println("deleteGedung");
        dg.deleteGedung(gedung1.getId());
    }

}