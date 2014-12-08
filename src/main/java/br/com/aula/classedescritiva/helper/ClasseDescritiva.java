package br.com.aula.classedescritiva.helper;
;

public class ClasseDescritiva {

    private Short id;
    private String descricao;
    private String tipo;

    public ClasseDescritiva() {
    }

    public ClasseDescritiva(Short id, String descricao, String tipo) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

}
