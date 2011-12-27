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
 * @author Yuni
 */
@Entity
public class SubGedung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    private Long id_pemilik;
    private Long id_gedung ;
    private String nama_sub_gedung;
    private int tipe_sub_gedung;
    private String harga;
    private int satuan;
    private String kapasitas;
    private String  luas;
    private String fasilitas_sub;
    private String gambar_sub;
    private String deskripsi_sub;
    private int status;
    private String foto;
    private String foto2;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    
    
    public String getDeskripsi_sub() {
        return deskripsi_sub;
    }

    public void setDeskripsi_sub(String deskripsi_sub) {
        this.deskripsi_sub = deskripsi_sub;
    }

    public String getFasilitas_sub() {
        return fasilitas_sub;
    }

    public void setFasilitas_sub(String fasilitas_sub) {
        this.fasilitas_sub = fasilitas_sub;
    }

    public String getGambar_sub() {
        return gambar_sub;
    }

    public void setGambar_sub(String gambar_sub) {
        this.gambar_sub = gambar_sub;
    }

    

    public Long getId_gedung() {
        return id_gedung;
    }

    public void setId_gedung(Long id_gedung) {
        this.id_gedung = id_gedung;
    }

    public Long getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(Long id_pemilik) {
        this.id_pemilik = id_pemilik;
    }

   

    public String getNama_sub_gedung() {
        return nama_sub_gedung;
    }

    public void setNama_sub_gedung(String nama_sub_gedung) {
        this.nama_sub_gedung = nama_sub_gedung;
    }

    public int getSatuan() {
        return satuan;
    }

    public void setSatuan(int satuan) {
        this.satuan = satuan;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

    public int getTipe_sub_gedung() {
        return tipe_sub_gedung;
    }

    public void setTipe_sub_gedung(int tipe_sub_gedung) {
        this.tipe_sub_gedung = tipe_sub_gedung;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof SubGedung)) {
            return false;
        }
        SubGedung other = (SubGedung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SubGedung[id=" + id + "]";
    }

}
