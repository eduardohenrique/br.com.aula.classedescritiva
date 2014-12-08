
package br.com.aula.classedescritiva.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "marca",schema = "javaweb")
@NamedQueries({@NamedQuery(name = "marca.findAll",query = "select m from Marca m")})
public class Marca implements Serializable {
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMarca",nullable = false)
    private Short idMarca;

    @NotNull(message = "Informe a descrição")
    @Column(name = "descricao",nullable = false,length = 50)
    private String descricao;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "marca")
    private List<Modelo> modelos;

    public Short getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Short idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Modelo> getModelos() {
        if(this.modelos == null)
            this.modelos = new ArrayList<>();
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idMarca);
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
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.idMarca, other.idMarca)) {
            return false;
        }
        return true;
    }
    
    
   
    
}
