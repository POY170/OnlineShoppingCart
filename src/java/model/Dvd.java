/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author POY
 */
@Entity
@Table(name = "DVD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvd.findAll", query = "SELECT d FROM Dvd d"),
    @NamedQuery(name = "Dvd.findById", query = "SELECT d FROM Dvd d WHERE d.id = :id"),
    @NamedQuery(name = "Dvd.findByName", query = "SELECT d FROM Dvd d WHERE d.name = :name"),
    @NamedQuery(name = "Dvd.findByRate", query = "SELECT d FROM Dvd d WHERE d.rate = :rate"),
    @NamedQuery(name = "Dvd.findByYr", query = "SELECT d FROM Dvd d WHERE d.yr = :yr"),
    @NamedQuery(name = "Dvd.findByPrice", query = "SELECT d FROM Dvd d WHERE d.price = :price"),
    @NamedQuery(name = "Dvd.findByQty", query = "SELECT d FROM Dvd d WHERE d.qty = :qty")})
public class Dvd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 80)
    @Column(name = "NAME")
    private String name;
    @Size(max = 80)
    @Column(name = "RATE")
    private String rate;
    @Column(name = "YR")
    private Integer yr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QTY")
    private Integer qty;

    public Dvd() {
    }

    public Dvd(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getYr() {
        return yr;
    }

    public void setYr(Integer yr) {
        this.yr = yr;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
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
        if (!(object instanceof Dvd)) {
            return false;
        }
        Dvd other = (Dvd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.Dvd[ id=" + id + " ]";
    }
    
}
