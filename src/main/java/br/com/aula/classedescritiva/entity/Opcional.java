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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "opcional")
public class Opcional implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOpcional",nullable = false)
    private Short idOpcional;
    
    @Column(name = "descricao",nullable = false,length = 50)
    @NotNull
    private String descricao;
    
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "opcionais")
    private List<Automovel> automoveis;

    public Short getIdOpcional() {
        return idOpcional;
    }

    public void setIdOpcional(Short idOpcional) {
        this.idOpcional = idOpcional;
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
        hash = 23 * hash + Objects.hashCode(this.idOpcional);
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
        final Opcional other = (Opcional) obj;
        if (!Objects.equals(this.idOpcional, other.idOpcional)) {
            return false;
        }
        return true;
    }
   
    
}
