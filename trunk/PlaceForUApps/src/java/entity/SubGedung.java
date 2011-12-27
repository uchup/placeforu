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
    private long hargaSubGedung;
    private int satuanHargaSubGedung;
    private String kapasitasSubGedung;
    private String luasSubGedung;
    private String fasilitasSubGedung;
    private String deskripsiSubGedung;
    private int statusSubGedung;

    @ManyToOne
    @JoinColumn(name="IDGEDUNG",referencedColumnName="IDGEDUNG")
    private Gedung gedung;

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

    public Gedung getGedung() {
        return gedung;
    }

    public void setGedung(Gedung gedung) {
        this.gedung = gedung;
    }

    public long getHargaSubGedung() {
        return hargaSubGedung;
    }

    public void setHargaSubGedung(long hargaSubGedung) {
        this.hargaSubGedung = hargaSubGedung;
    }

    public Long getIdSubGedung() {
        return idSubGedung;
    }

    public void setIdSubGedung(Long idSubGedung) {
        this.idSubGedung = idSubGedung;
    }

    public String getKapasitasSubGedung() {
        return kapasitasSubGedung;
    }

    public void setKapasitasSubGedung(String kapasitasSubGedung) {
        this.kapasitasSubGedung = kapasitasSubGedung;
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

    public int getSatuanHargaSubGedung() {
        return satuanHargaSubGedung;
    }

    public void setSatuanHargaSubGedung(int satuanHargaSubGedung) {
        this.satuanHargaSubGedung = satuanHargaSubGedung;
    }

    public int getStatusSubGedung() {
        return statusSubGedung;
    }

    public void setStatusSubGedung(int statusSubGedung) {
        this.statusSubGedung = statusSubGedung;
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
