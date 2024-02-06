/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Denipoti
 */
@Entity
@Table(name = "pets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pet.findAll", query = "SELECT p FROM Pet p"),
    @NamedQuery(name = "Pet.findByIdPets", query = "SELECT p FROM Pet p WHERE p.idPets = :idPets"),
    @NamedQuery(name = "Pet.findByNome", query = "SELECT p FROM Pet p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pet.findByEspecie", query = "SELECT p FROM Pet p WHERE p.especie = :especie"),
    @NamedQuery(name = "Pet.findByRaca", query = "SELECT p FROM Pet p WHERE p.raca = :raca"),
    @NamedQuery(name = "Pet.findByValor", query = "SELECT p FROM Pet p WHERE p.valor = :valor")})
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPets")
    private Integer idPets;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Especie")
    private String especie;
    @Column(name = "Raca")
    private String raca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor")
    private Double valor;

    public Pet() {
    }

    public Pet(Integer idPets) {
        this.idPets = idPets;
    }

    public Integer getIdPets() {
        return idPets;
    }

    public void setIdPets(Integer idPets) {
        this.idPets = idPets;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPets != null ? idPets.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pet)) {
            return false;
        }
        Pet other = (Pet) object;
        if ((this.idPets == null && other.idPets != null) || (this.idPets != null && !this.idPets.equals(other.idPets))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pet[ idPets=" + idPets + " ]";
    }
    
}
