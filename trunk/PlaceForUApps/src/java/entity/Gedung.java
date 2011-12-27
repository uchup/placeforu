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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ika
 */
@Entity
public class Gedung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGedung;
    private String namaGedung;
    private String tipeGedung;
    private String kategoriGedung;
    private String propinsiGedung;
    private String kotaGedung;
    private String alamatGedung;
    private String deskripsiGedung;
    private String fasilitasGedung;
    private String noTelpGedung;
    private String emailGedung;
    private String fotoUtamaGedung;
    private String foto1Gedung;
    private String foto2Gedung;
    private String foto3Gedung;

    @ManyToOne
    @JoinColumn(name="IDPEMILIK",referencedColumnName="ID")
    private User user;

    public Long getIdGedung() {
        return idGedung;
    }

    public void setIdGedung(Long idGedung) {
        this.idGedung = idGedung;
    }
    
    //getting Nama Gedung
    public String getNamaGedung(){
        return namaGedung;
    }    

    //setting Nama Gedung
    public void setNamaGedung(String namaGedung){
        this.namaGedung = namaGedung;
    }
    
    //getting Tipe Gedung
    public String getTipeGedung(){
        return tipeGedung;
    }    

    //setting Tipe Gedung
    public void setTipeGedung(String tipeGedung){
        this.tipeGedung = tipeGedung;
    }
    
    //getting Kategori Gedung
    public String getKategoriGedung(){
        return kategoriGedung;
    }    

    //setting Kategori Gedung
    public void setKategoriGedung(String kategoriGedung){
        this.kategoriGedung = kategoriGedung;
    }
    
    //getting Propinsi Gedung
    public String getPropinsiGedung(){
        return propinsiGedung;
    }    

    //setting Propinsi Gedung
    public void setPropinsiGedung(String propinsiGedung){
        this.propinsiGedung = propinsiGedung;
    }
    
    //getting Kota Gedung
    public String getKotaGedung(){
        return kotaGedung;
    }    

    //setting Kota Gedung
    public void setKotaGedung(String kotaGedung){
        this.kotaGedung = kotaGedung;
    }
    
    //getting Alamat Gedung
    public String getAlamatGedung(){
        return alamatGedung;
    }    

    //setting Kota Gedung
    public void setAlamatGedung(String alamatGedung){
        this.alamatGedung = alamatGedung;
    }
    
    //getting Deskripsi Gedung
    public String getDeskripsiGedung(){
        return deskripsiGedung;
    }    

    //setting Deskripsi Gedung
    public void setDeskripsiGedung(String deskripsiGedung){
        this.deskripsiGedung = deskripsiGedung;
    }
    
    //getting Fasilitas Gedung
    public String getFasilitasGedung(){
        return fasilitasGedung;
    }    

    //setting Fasilitas Gedung
    public void setFasilitasGedung(String fasilitasGedung){
        this.fasilitasGedung = fasilitasGedung;
    }
    
    //getting No Telp Gedung
    public String getTelpGedung(){
        return noTelpGedung;
    }    

    //setting No Telp Gedung
    public void setTelpGedung(String noTelpGedung){
        this.noTelpGedung = noTelpGedung;
    }
    
    //getting email Gedung
    public String getEmailGedung(){
        return emailGedung;
    }    

    //setting Email Gedung
    public void setEmailGedung(String emailGedung){
        this.emailGedung = emailGedung;
    }

    public String getFoto1Gedung() {
        return foto1Gedung;
    }

    public void setFoto1Gedung(String foto1Gedung) {
        this.foto1Gedung = foto1Gedung;
    }

    public String getFoto2Gedung() {
        return foto2Gedung;
    }

    public void setFoto2Gedung(String foto2Gedung) {
        this.foto2Gedung = foto2Gedung;
    }

    public String getFoto3Gedung() {
        return foto3Gedung;
    }

    public void setFoto3Gedung(String foto3Gedung) {
        this.foto3Gedung = foto3Gedung;
    }

    public String getFotoUtamaGedung() {
        return fotoUtamaGedung;
    }

    public void setFotoUtamaGedung(String fotoUtamaGedung) {
        this.fotoUtamaGedung = fotoUtamaGedung;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGedung != null ? idGedung.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gedung)) {
            return false;
        }
        Gedung other = (Gedung) object;
        if ((this.idGedung == null && other.idGedung != null) || (this.idGedung != null && !this.idGedung.equals(other.idGedung))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gedung[ id=" + idGedung + " ]";
    }
    
}
