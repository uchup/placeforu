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

   
    @Test // bagian ini dilakukan pengetesan pada method addUser() --> method yg dipakai utk menambahkan gedung
    public void testAddGedung() {


        dg.addGedung(gedung1);
    }

    @Test // bagian ini dilakukan pengetesan pada method addUser() --> method yg dipakai utk menambahkan gedung
    public void testEditGedung() {

        gedung1 = dg.getGedung(gedung1.getNamaGedung());
        gedung1.setNamaGedung(gedung2.getNamaGedung());
        dg.editGedung(gedung1);
        assertEquals(gedung2.getNamaGedung(), dg.getGedung(gedung1.getNamaGedung()).getNamaGedung());

    }


     @Test // bagian ini dilakukan pengetesan pada method deleteGedung()--> metod yg dipakai utk menghapus gedung
     public void testDeleteGedung() throws Exception{
        dg.deleteGedung(dg.getGedung(gedung2.getNamaGedung()).getIdGedung());

    }

    
    

    

    
}