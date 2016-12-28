/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author Anton
 */
@Entity
@Table(name = "YACHTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yachts.findAll", query = "SELECT y FROM Yachts y"),
    @NamedQuery(name = "Yachts.findById", query = "SELECT y FROM Yachts y WHERE y.id = :id"),
    @NamedQuery(name = "Yachts.findByModel", query = "SELECT y FROM Yachts y WHERE y.model = :model")})
public class Yachts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ID")
    private String id;
    @Size(max = 255)
    @Column(name = "MODEL")
    private String model;

    public Yachts() {
    }

    public Yachts(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        if (!(object instanceof Yachts)) {
            return false;
        }
        Yachts other = (Yachts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Yachts[ id=" + id + " ]";
    }
    
}
