
package br.com.aula.classedescritiva.service;

import br.com.aula.classedescritiva.helper.ClasseDescritiva;
import java.util.List;


public interface IClasseDescritivaService {
    
    String salvar(ClasseDescritiva classeDescritiva);
    String excluir(ClasseDescritiva classeDescritiva);
    List<ClasseDescritiva> todos(String tipo);
}
