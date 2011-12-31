/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Ika
 */
@Entity
public class Sewa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSewa;
    private Long idGedung;
    private Long idSubGedung;
    private Long idPenyewa;
    private Long idPemilik;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mulai;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sampai;
    private int status;
    private int totalHargaSewa;
    private int sisaBayar;

    public Long getIdSewa() {
        return idSewa;
    }

    public void setIdSewa(Long idSewa) {
        this.idSewa = idSewa;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getIdGedung() {
        return idGedung;
    }

    public void setIdGedung(Long idGedung) {
        this.idGedung = idGedung;
    }

    public Long getIdPenyewa() {
        return idPenyewa;
    }

    public void setIdPenyewa(Long idPenyewa) {
        this.idPenyewa = idPenyewa;
    }
    public Long getIdPemilik() {
        return idPemilik;
    }

    public void setIdPemilik(Long idPemilik) {
        this.idPemilik = idPemilik;
    }

    public Long getIdSubGedung() {
        return idSubGedung;
    }

    public void setIdSubGedung(Long idSubGedung) {
        this.idSubGedung = idSubGedung;
    }

    public Date getMulai() {
        return mulai;
    }

    public void setMulai(Date mulai) {
        this.mulai = mulai;
    }

    public Date getSampai() {
        return sampai;
    }

    public void setSampai(Date sampai) {
        this.sampai = sampai;
    }
    
    public int getTotalHargaSewa() {
        return totalHargaSewa;
    }

    public void setTotalHargaSewa(int TotalSewa) {
        this.totalHargaSewa = TotalSewa;
    }
    
    public int getSisaBayar() {
        return sisaBayar;
    }

    public void setSisaBayar(int SisaBayar) {
        this.sisaBayar = SisaBayar;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSewa != null ? idSewa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sewa)) {
            return false;
        }
        Sewa other = (Sewa) object;
        if ((this.idSewa == null && other.idSewa != null) || (this.idSewa != null && !this.idSewa.equals(other.idSewa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sewa[ id=" + idSewa + " ]";
    }
    
}
