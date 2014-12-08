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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "combustivel")
public class Combustivel implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCombustivel",nullable = false)
    private Short idCombustivel;
    
    @Column(name = "descricao",nullable = false,length = 50)
    @NotNull
    private String descricao;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "combustivel")
    private List<Automovel> automoveis;

    public Short getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(Short idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idCombustivel);
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
        final Combustivel other = (Combustivel) obj;
        if (!Objects.equals(this.idCombustivel, other.idCombustivel)) {
            return false;
        }
        return true;
    }
    
 
    
    
}
