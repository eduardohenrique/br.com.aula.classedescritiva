package br.com.aula.classedescritiva.serviceimpl;

import br.com.aula.classedescritiva.helper.ClasseDescritiva;
import br.com.aula.classedescritiva.helper.ClasseDescritivaConverter;
import br.com.aula.classedescritiva.helper.ClasseDescritivaMap;
import br.com.aula.classedescritiva.service.IClasseDescritivaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClasseDescritivaService implements IClasseDescritivaService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public String salvar(ClasseDescritiva classeDescritiva) {

        try {
            Object object = ClasseDescritivaConverter.converterToClasseDescritiva(classeDescritiva);
            em.merge(object);
        } catch (javax.validation.ConstraintViolationException e) {
            for (javax.validation.ConstraintViolation<?> violation : e.getConstraintViolations()) {
                return violation.getMessage();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Ocorreu um erro ao salvar. " + ex.getMessage();

        }
        return null;
    }

    @Override
    public String excluir(ClasseDescritiva classeDescritiva) {
        try {

            em.remove(em.find(ClasseDescritivaMap.CLASSESDESCRITIVAS.get(classeDescritiva.getTipo()), classeDescritiva.getId()));
        } catch (Exception ex) {

            ex.printStackTrace();
            return ex.getMessage();
        }
        return null;
    }


    @Override
    public List<ClasseDescritiva> todos(String tipo) {

        try {
            if(tipo != null){
                List itens = em.createQuery("select x from "+tipo+" as x").getResultList();
                return ClasseDescritivaConverter.converterToClasseDescritiva(itens,tipo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
