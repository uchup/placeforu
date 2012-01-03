/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import junit.framework.TestCase;
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
public class DaftarAdministrasiTest extends TestCase {

    private User User1;
    private Gedung gedung1;
    private Administrasi admin1;
    private Administrasi admin2;
    private Administrasi admin3;
    private SubGedung subgedung1;
    private Sewa sewa;
    DaftarSubGedung sub = new DaftarSubGedung();
    DaftarAdministrasi da = new DaftarAdministrasi ();

    //int allAdm_Confirmed = da.getAllAdm_Confirmed().size();


    public DaftarAdministrasiTest(String testName) {
        super(testName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        long idAdmin =3;
        long idPemilik = 5;
        long idPemilik2 = 6;
        long idSewa = 6;
        long idSewa2 =7;

        admin1 = new Administrasi();
        admin1.setJumlahBayar(30000);
        admin1.setMediaBayar("transfer bank");
        admin1.setNoBukti("A1117888");
        admin1.setStatusPembayaran(1);
        admin1.setId(idSewa);
        admin1.setIdPemilik(idPemilik);
        admin1.setIdSewa(idSewa);

        admin2 = new Administrasi();
        admin2.setJumlahBayar(30000);
        admin2.setNoBukti("b2227888");

        admin3 = new Administrasi();
        admin3.setJumlahBayar(30000);
        admin3.setMediaBayar("transfer bank");
        admin3.setNoBukti("A1117888");
        admin3.setStatusPembayaran(0);
        admin3.setId(idSewa2);
        admin3.setIdPemilik(idPemilik2);
        admin3.setIdSewa(idSewa2);
    }

    @Test
    public void testAddAdministrasi() {
       da.addAdministrasi(admin1);
       da.addAdministrasi(admin3);

    }

    @Test
    public void testEditAdministrasi(){

        admin1 = da.getAdministrasi(admin1.getId());
        admin1.setNoBukti(admin2.getNoBukti());
        da.editAdministrasi(admin1);
        assertEquals(admin1.getNoBukti(), da.getAdministrasi(admin1.getId()).getNoBukti());

    }

    public void tesAdministrasi_Confirmed(){

                assertEquals(1, da.getAdministrasi_Confirmed(admin1.getIdPemilik()).size());
    }

    public void tesAdministrasi_Unconfirmed(){

                assertEquals(1, da.getAdministrasi_Unconfirmed(admin3.getIdPemilik()).size());
    }

    public void tesAllAdm_Confirmed(){

                assertEquals(1, da.getAllAdm_Confirmed().size());

    }
    }


