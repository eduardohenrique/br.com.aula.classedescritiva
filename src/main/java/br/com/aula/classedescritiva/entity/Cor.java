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
@Table(name = "cor")
public class Cor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCor", nullable = false)
    private Short idCor;

    @Column(name = "descricao", nullable = false, length = 50)
    @NotNull
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cor")
    private List<Automovel> automoveis;

    public Short getIdCor() {
        return idCor;
    }

    public void setIdCor(Short idCor) {
        this.idCor = idCor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Automovel> getAutomoveis() {
        if (this.automoveis == null) {
            this.automoveis = new ArrayList<>();
        }
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idCor);
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
        final Cor other = (Cor) obj;
        if (!Objects.equals(this.idCor, other.idCor)) {
            return false;
        }
        return true;
    }

    
}
