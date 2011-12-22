/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Yuni
 */
@Entity
public class SubGedung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSubGedung;
    
    private String namaSubGedung;
    private int tipeSubGedung;
    private int kategoriGedung;
    private String kapasitasSubGedung;
    private String luasSubGedung;
    private String deskripsiSubGedung;
    private String fasilitasSubGedung;
    private String fotoUtamaSubGedung;
    private String foto1SubGedung;
    private String foto2SubGedung;
    private String foto3SubGedung;
    private long hargaSewaSubGedung;
    private int statusSewaSubGedung;

    @ManyToOne
    @JoinColumn(name="IDGEDUNG",referencedColumnName="IDGEDUNG")
    private Gedung gedung;

    public Long getIdSubGedung() {
        return idSubGedung;
    }

    public void setIdSubGedung(Long idSubGedung) {
        this.idSubGedung = idSubGedung;
    }
    
    public String getDeskripsiSubGedung() {
        return deskripsiSubGedung;
    }

    public void setDeskripsiSubGedung(String deskripsiSubGedung) {
        this.deskripsiSubGedung = deskripsiSubGedung;
    }

    public String getFasilitasSubGedung() {
        return fasilitasSubGedung;
    }

    public void setFasilitasSubGedung(String fasilitasSubGedung) {
        this.fasilitasSubGedung = fasilitasSubGedung;
    }

    public String getFoto1SubGedung() {
        return foto1SubGedung;
    }

    public void setFoto1SubGedung(String foto1SubGedung) {
        this.foto1SubGedung = foto1SubGedung;
    }

    public String getFoto2SubGedung() {
        return foto2SubGedung;
    }

    public void setFoto2SubGedung(String foto2SubGedung) {
        this.foto2SubGedung = foto2SubGedung;
    }

    public String getFoto3SubGedung() {
        return foto3SubGedung;
    }

    public void setFoto3SubGedung(String foto3SubGedung) {
        this.foto3SubGedung = foto3SubGedung;
    }

    public String getFotoUtamaSubGedung() {
        return fotoUtamaSubGedung;
    }

    public void setFotoUtamaSubGedung(String fotoUtamaSubGedung) {
        this.fotoUtamaSubGedung = fotoUtamaSubGedung;
    }

    public Gedung getGedung() {
        return gedung;
    }

    public void setGedung(Gedung gedung) {
        this.gedung = gedung;
    }

    public long getHargaSewaSubGedung() {
        return hargaSewaSubGedung;
    }

    public void setHargaSewaSubGedung(long hargaSewaSubGedung) {
        this.hargaSewaSubGedung = hargaSewaSubGedung;
    }



    public String getKapasitasSubGedung() {
        return kapasitasSubGedung;
    }

    public void setKapasitasSubGedung(String kapasitasSubGedung) {
        this.kapasitasSubGedung = kapasitasSubGedung;
    }

    public int getKategoriGedung() {
        return kategoriGedung;
    }

    public void setKategoriGedung(int kategoriGedung) {
        this.kategoriGedung = kategoriGedung;
    }

    public String getLuasSubGedung() {
        return luasSubGedung;
    }

    public void setLuasSubGedung(String luasSubGedung) {
        this.luasSubGedung = luasSubGedung;
    }

    public String getNamaSubGedung() {
        return namaSubGedung;
    }

    public void setNamaSubGedung(String namaSubGedung) {
        this.namaSubGedung = namaSubGedung;
    }

    public int getStatusSewaSubGedung() {
        return statusSewaSubGedung;
    }

    public void setStatusSewaSubGedung(int statusSewaSubGedung) {
        this.statusSewaSubGedung = statusSewaSubGedung;
    }

    public int getTipeSubGedung() {
        return tipeSubGedung;
    }

    public void setTipeSubGedung(int tipeSubGedung) {
        this.tipeSubGedung = tipeSubGedung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubGedung != null ? idSubGedung.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubGedung)) {
            return false;
        }
        SubGedung other = (SubGedung) object;
        if ((this.idSubGedung == null && other.idSubGedung != null) || (this.idSubGedung != null && !this.idSubGedung.equals(other.idSubGedung))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SubGedung[id=" + idSubGedung + "]";
    }

}
