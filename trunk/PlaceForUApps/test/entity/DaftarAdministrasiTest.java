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
    private SubGedung subgedung1;
    private Sewa sewa;
    DaftarSubGedung sub = new DaftarSubGedung();    
    DaftarAdministrasi da = new DaftarAdministrasi ();
   
    public DaftarAdministrasiTest(String testName) {
        super(testName);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        
        long idAdmin =3;
        long idPemilik = 5;
        long idSewa = 6;
        
        admin1 = new Administrasi();
        admin1.setJumlahBayar(30000);
        admin1.setMediaBayar("transfer bank");
        admin1.setNoBukti("A1117888");
        admin1.setStatusPembayaran(1);
        admin1.setId(idSewa);
        
        admin2 = new Administrasi();
        admin2 = new Administrasi();
        admin2.setJumlahBayar(30000);
        admin2.setMediaBayar("transfer bank");
        admin2.setNoBukti("A1117888");
        admin2.setStatusPembayaran(1);        
    }
 
    @Test
    public void testAddAdministrasi() {
     
       da.addAdministrasi(admin1);

    }
}
