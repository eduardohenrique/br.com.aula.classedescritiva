package br.com.aula.classedescritiva.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "modelo")
public class Modelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModelo",nullable = false)
    private Short idModelo;
    
    @NotNull(message = "Informe a descrição")
    @Size(min = 1,max = 50, message = "O campo descrição deve ter entre {min} a {max} caracteres")
    @Column(name = "descricao",nullable = false,length = 50)
    private String descricao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMarca",nullable = false)
    @NotNull(message = "Informe a marca")
    private Marca marca;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "modelo")
    private List<Automovel> automoveis;

    public Short getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Short idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
     public List<Automovel> getAutomoveis() {
        if(this.automoveis == null)
            this.automoveis = new ArrayList<>();
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idModelo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.idModelo, other.idModelo)) {
            return false;
        }
        return true;
    }
 
    
}
