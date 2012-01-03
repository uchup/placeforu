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

    @Before
    public void setUp() throws Exception {
        super.setUp();

        subgedung1 = new SubGedung();
        subgedung1.setNama_sub_gedung("Sahid");
        subgedung1.setTipe_sub_gedung(1);
        subgedung1.setLuas("100");
        subgedung1.setKapasitas("100");
        subgedung1.setHarga("1000");
        subgedung1.setSatuan(1);
        subgedung1.setDeskripsi_sub("lalala");
        subgedung1.setFasilitas_sub("nananna");
        subgedung1.setStatus(1);
        long id = 200;
        subgedung1.setId(id);


        subgedung2 = new SubGedung();
        subgedung2.setNama_sub_gedung("Marriotzz");
        subgedung2.setTipe_sub_gedung(1);
        subgedung2.setLuas("100");
        subgedung1.setKapasitas("500");
        subgedung2.setHarga("1000");
        subgedung2.setSatuan(1);
        subgedung2.setDeskripsi_sub("lalala");
        subgedung2.setFasilitas_sub("nananna");
        subgedung2.setStatus(1);

    }

    @Test // bagian ini dilakukan pengetesan pada method addUser() --> method yg dipakai utk menambahkan gedung
    public void testAddSubGedung() {


        sub.addSubGedung(subgedung1);

    }

    public void testGetSubGedung(){

        assertEquals(subgedung1.getId(), sub.getSubGedung(subgedung1.getNama_sub_gedung()).getId());
    }


    @Test // bagian ini dilakukan pengetesan pada method addUser() --> method yg dipakai utk menambahkan gedung
    public void testEditSubGedung() {

        subgedung1 = sub.getSubGedung(subgedung1.getId());
        subgedung1.setNama_sub_gedung(subgedung2.getNama_sub_gedung());
        sub.editSubGedung(subgedung1);
        assertEquals(subgedung2.getNama_sub_gedung(), sub.getSubGedung(subgedung1.getNama_sub_gedung()).getNama_sub_gedung());
    }

    public void testDaftarSubGedung(){

    assertEquals(1, sub.getDaftarSubGedung().size());

    }


    /*public void testSubGedungfromId(){

     assertEquals(1, sub.getSubGedungfromId(200).size());

    }*/


     @Test // bagian ini dilakukan pengetesan pada method deleteGedung()--> metod yg dipakai utk menghapus gedung
     public void testDeleteSubGedung() throws Exception{
        sub.deleteSubGedung(sub.getSubGedung(subgedung2.getNama_sub_gedung()).getId());
    }











}