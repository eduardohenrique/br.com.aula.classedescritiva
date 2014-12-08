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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "automovel")
public class Automovel implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutomovel",nullable = false)
    private Integer idAutomovel;
    
    @NotNull(message = "Informe o ano")
    @Column(name = "ano",nullable = false)
    private Integer ano;
   
    @Column(name = "valor",nullable = true)
    private Double valor;
    
    @NotNull(message = "Informe a quantidade de portas")
    @Column(name = "quantidadePortas",nullable = false)
    private Short quantidadePortas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModelo",nullable = false)
    @NotNull(message = "Informe o modelo")
    private Modelo modelo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCor",nullable = false)
    @NotNull(message = "Informe a cor")
    private Cor cor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCombustivel",nullable = false)
    @NotNull(message = "Informe o combustivel")
    private Combustivel combustivel;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AutomovelOpcional",
            joinColumns = @JoinColumn(name = "idAutomovel"),
            inverseJoinColumns = @JoinColumn(name = "idOpcional"))
    private List<Opcional> opcionais;

    public Integer getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Integer idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Short getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Short quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }
    
    public List<Opcional> getOpcionais() {
        if(this.opcionais == null)
            this.opcionais = new ArrayList<>();
        return opcionais;
    }

    public void setOpcionais(List<Opcional> opcionais) {
        this.opcionais = opcionais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idAutomovel);
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
        final Automovel other = (Automovel) obj;
        if (!Objects.equals(this.idAutomovel, other.idAutomovel)) {
            return false;
        }
        return true;
    }
    
    
    
}
