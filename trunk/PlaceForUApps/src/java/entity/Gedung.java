/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ika
 */
@Entity
public class Gedung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int id_pemilik;
    private String nama_gedung;
    private int tipe_gedung;
    private int kategori_gedung;
    private String propinsi_gedung;
    private String kota_gedung;
    private String alamat_gedung;
    private String deskripsi_gedung;
    private String fasilitas_gedung;
    private String no_telp_gedung;
    private String email_gedung;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    //getting Nama Gedung
    public String getNamaGedung(){
        return nama_gedung;
    }    

    //setting Nama Gedung
    public void setNamaGedung(String nama_gedung){
        this.nama_gedung = nama_gedung;
    }
    
    //getting Tipe Gedung
    public int getTipeGedung(){
        return tipe_gedung;
    }    

    //setting Tipe Gedung
    public void setTipeGedung(int tipe_gedung){
        this.tipe_gedung = tipe_gedung;
    }
    
    //getting Kategori Gedung
    public int getKategoriGedung(){
        return kategori_gedung;
    }    

    //setting Kategori Gedung
    public void setKategoriGedung(int kategori_gedung){
        this.kategori_gedung = kategori_gedung;
    }
    
    //getting Propinsi Gedung
    public String getPropinsiGedung(){
        return propinsi_gedung;
    }    

    //setting Propinsi Gedung
    public void setPropinsiGedung(String propinsi_gedung){
        this.propinsi_gedung = propinsi_gedung;
    }
    
    //getting Kota Gedung
    public String getKotaGedung(){
        return kota_gedung;
    }    

    //setting Kota Gedung
    public void setKotaGedung(String kota_gedung){
        this.kota_gedung = kota_gedung;
    }
    
    //getting Alamat Gedung
    public String getAlamatGedung(){
        return alamat_gedung;
    }    

    //setting Kota Gedung
    public void setAlamatGedung(String alamat_gedung){
        this.alamat_gedung = alamat_gedung;
    }
    
    //getting Deskripsi Gedung
    public String getDeskripsiGedung(){
        return deskripsi_gedung;
    }    

    //setting Deskripsi Gedung
    public void setDeskripsiGedung(String deskripsi_gedung){
        this.deskripsi_gedung = deskripsi_gedung;
    }
    
    //getting Fasilitas Gedung
    public String getFasilitasGedung(){
        return fasilitas_gedung;
    }    

    //setting Fasilitas Gedung
    public void setFasilitasGedung(String fasilitas_gedung){
        this.fasilitas_gedung = fasilitas_gedung;
    }
    
    //getting No Telp Gedung
    public String getTelpGedung(){
        return no_telp_gedung;
    }    

    //setting No Telp Gedung
    public void setTelpGedung(String no_telp_gedung){
        this.no_telp_gedung = no_telp_gedung;
    }
    
    //getting email Gedung
    public String getEmailGedung(){
        return email_gedung;
    }    

    //setting Email Gedung
    public void setEmailGedung(String email_gedung){
        this.email_gedung = email_gedung;
    }
    
    //getting Deskripsi Gedung
    public int getIdPemilik(){
        return id_pemilik;
    }    

    //setting Deskripsi Gedung
    public void setIdPemilik(int id_pemilik){
        this.id_pemilik = id_pemilik;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gedung)) {
            return false;
        }
        Gedung other = (Gedung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gedung[ id=" + id + " ]";
    }
    
}
