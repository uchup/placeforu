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
public class Administrasi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mediaBayar;
    private Long idPemilik;

    public Long getIdPemilik() {
        return idPemilik;
    }

    public void setIdPemilik(Long idPemilik) {
        this.idPemilik = idPemilik;
    }
    private String noBukti;
    private int jumlahBayar;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tglBayar;
    private Long idSewa;
    private int statusPembayaran;

    public int getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(int statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public Long getIdSewa() {
        return idSewa;
    }

    public void setIdSewa(Long idSewa) {
        this.idSewa = idSewa;
    }

    public int getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(int jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }

    public String getMediaBayar() {
        return mediaBayar;
    }

    public void setMediaBayar(String mediaBayar) {
        this.mediaBayar = mediaBayar;
    }

    public String getNoBukti() {
        return noBukti;
    }

    public void setNoBukti(String noBukti) {
        this.noBukti = noBukti;
    }

    public Date getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(Date tglBayar) {
        this.tglBayar = tglBayar;
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
        if (!(object instanceof Administrasi)) {
            return false;
        }
        Administrasi other = (Administrasi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Administrasi[ id=" + id + " ]";
    }
}
