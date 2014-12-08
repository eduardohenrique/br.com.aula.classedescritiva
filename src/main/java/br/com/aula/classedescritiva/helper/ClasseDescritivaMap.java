package br.com.aula.classedescritiva.helper;

import br.com.aula.classedescritiva.entity.Combustivel;
import br.com.aula.classedescritiva.entity.Cor;
import br.com.aula.classedescritiva.entity.Marca;
import br.com.aula.classedescritiva.entity.Opcional;
import java.util.HashMap;
import java.util.Map;

public class ClasseDescritivaMap {

    public static final Map<String, Class<?>> CLASSESDESCRITIVAS;

    private ClasseDescritivaMap() {
    }

    static {
        CLASSESDESCRITIVAS = new HashMap<>();
        CLASSESDESCRITIVAS.put("Combustivel", Combustivel.class);
        CLASSESDESCRITIVAS.put("Cor", Cor.class);
        CLASSESDESCRITIVAS.put("Marca", Marca.class);
        CLASSESDESCRITIVAS.put("Opcional", Opcional.class);
    }

}
