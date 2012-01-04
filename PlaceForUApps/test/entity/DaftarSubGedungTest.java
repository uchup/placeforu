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
public class DaftarSubGedungTest extends TestCase {


    private SubGedung subgedung1;
    private SubGedung subgedung2;
    DaftarSubGedung sub = new DaftarSubGedung();

    private User User1;
    private User User2;
    private Gedung gedung1;
    private Gedung gedung2;

    public DaftarSubGedungTest(String testName) {
        super(testName);
    }

    // bagian ini dilakukan untuk mensetting nilai parameter
    @Before
    public void setUp() throws Exception {
        super.setUp();
        subgedung1 = new SubGedung();
        subgedung1.setNama_sub_gedung("Sahid");
        subgedung1.setTipe_sub_gedung("indoor");
        subgedung1.setLuas("100");
        subgedung1.setKapasitas("100");
        subgedung1.setHarga("1000");
        subgedung1.setSatuan("IDR");
        subgedung1.setDeskripsi_sub("lalala");
        subgedung1.setFasilitas_sub("nananna");
        subgedung1.setStatus("tersedia");
        long idsubgedung = 200;
        long idgedung = 100;
        subgedung1.setId(idsubgedung );
        subgedung1.setId_gedung(idgedung);

        subgedung2 = new SubGedung();
        subgedung2.setNama_sub_gedung("Marriotzz");
        subgedung2.setTipe_sub_gedung("outdoor");
        subgedung2.setLuas("100");
        subgedung1.setKapasitas("500");
        subgedung2.setHarga("1000");
        subgedung2.setSatuan("IDR");
        subgedung2.setDeskripsi_sub("lalala");
        subgedung2.setFasilitas_sub("nananna");
        subgedung2.setStatus("tersedia");
    }

    @Test // bagian ini dilakukan pengetesan pada method addUser() --> method yg dipakai utk menambahkan gedung
    public void testAddSubGedung() {
        System.out.println("AddGedung");
        sub.addSubGedung(subgedung1);
        sub.addSubGedung(subgedung2);
    }

    @Test // bagian ini dilakukan pengetesan pada method GetSubGedung() --> method yg dipakai utk mendapatkan subgedung berdasarkan id
    public void testGetSubGedung(){
        System.out.println("GetSubGedung");
        long idsubgedung  = subgedung1.getId();

        assertEquals(subgedung1.getKapasitas(), sub.getSubGedung(subgedung1.getId()).getKapasitas());
    }

    @Test // bagian ini dilakukan pengetesan pada method EditSubGedung() --> method yg dipakai utk mengedit gedung
    public void testEditSubGedung() {
        System.out.println("EditSubGedung");
        subgedung1 = sub.getSubGedung(subgedung1.getId());
        subgedung1.setNama_sub_gedung(subgedung2.getNama_sub_gedung());
        sub.editSubGedung(subgedung1);
        assertEquals(subgedung2.getNama_sub_gedung(), sub.getSubGedung(subgedung1.getId()).getNama_sub_gedung());
    }

    @Test // bagian ini dilakukan pengetesan pada method DaftarSubGedung()
    public void testDaftarSubGedung(){
        System.out.println("DaftarSubGedung");
        assertEquals(2, sub.getDaftarSubGedung().size());

    }

   @Test // bagian ini dilakukan pengetesan pada method deleteGedung()--> metod yg dipakai utk menghapus gedung
     public void testDeleteSubGedung() throws Exception{
        System.out.println("DeleteSubGedung");
        sub.deleteSubGedung(subgedung1.getId());

    }


}