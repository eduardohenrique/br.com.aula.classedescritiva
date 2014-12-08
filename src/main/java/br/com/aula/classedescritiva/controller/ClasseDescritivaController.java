package br.com.aula.classedescritiva.controller;

import br.com.aula.classedescritiva.helper.ClasseDescritiva;
import br.com.aula.classedescritiva.service.IClasseDescritivaService;
import br.com.aula.javaweb.util.MensagemUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

@Named
@ViewScoped
public class ClasseDescritivaController implements Serializable{ 

    private ClasseDescritiva classeDescritiva;
    private ClasseDescritiva classeDescritivaSelecionada;

    @EJB
    private IClasseDescritivaService classeDescritivaService;

    public ClasseDescritivaController() {
        this.classeDescritiva = new ClasseDescritiva();
    }

    @PostConstruct
    public void index() { 
        String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("tipo");
        if (param != null && !param.isEmpty()) {
            classeDescritiva.setTipo(param);
            System.out.println("Passou aqui:" + param);
        }
    }

    public void salvar() {

        String erro = classeDescritivaService.salvar(classeDescritiva);

        if (erro == null) {
            MensagemUtil.addMensagemInfo("Marca salva com sucesso");
            this.novo();
        } else {
            MensagemUtil.addMensagemError(erro);
        }

    }
    
    public void editar(){
        this.classeDescritiva =  this.classeDescritivaSelecionada;
    }

    public void novo() {
        classeDescritiva.setDescricao(null);
        classeDescritiva.setId(null);          
    }

    public void excluir() {
        try{
            String erro = classeDescritivaService.excluir(this.classeDescritivaSelecionada);

            if (erro == null) {
                MensagemUtil.addMensagemInfo("Marca excluída com sucesso");
               this.novo();
            } else {
                MensagemUtil.addMensagemError(erro);
            }
        }catch(Exception ex){
          MensagemUtil.addMensagemError("Não é possível excluir. Registro faz referência a outro.");
        }
    }

    public List<ClasseDescritiva> todos() {
        return classeDescritivaService.todos(classeDescritiva.getTipo());
    }

    public ClasseDescritiva getClasseDescritiva() {
        return classeDescritiva;
    }

    public void setClasseDescritiva(ClasseDescritiva classeDescritiva) {
        this.classeDescritiva = classeDescritiva;
    }

    public ClasseDescritiva getClasseDescritivaSelecionada() {
        return classeDescritivaSelecionada;
    }

    public void setClasseDescritivaSelecionada(ClasseDescritiva classeDescritivaSelecionada) {
        this.classeDescritivaSelecionada = classeDescritivaSelecionada;
    }

}
