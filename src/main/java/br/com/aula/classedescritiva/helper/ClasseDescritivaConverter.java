package br.com.aula.classedescritiva.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClasseDescritivaConverter {

    public static Object converterToClasseDescritiva(ClasseDescritiva classeDescritiva) throws Exception {

        return createObject(classeDescritiva);
    }

    public static List<ClasseDescritiva> converterToClasseDescritiva(List<?> list,String tipo) throws Exception {
        List<ClasseDescritiva> classeDescritivaList = new ArrayList<>();

        for (Object object : list) {
            Object[] values = recoverValues(object.getClass().getDeclaredFields(), object);

            Short id = (Short) values[0];
            String descricao = values[1].toString();

            ClasseDescritiva classeDescritiva = new ClasseDescritiva(id, descricao,tipo);
            classeDescritivaList.add(classeDescritiva);
        }

        return classeDescritivaList;
    }

    private static Object[] recoverValues(Field[] fields, Object object) throws Exception {

        Object[] values = new Object[2];
        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getName().startsWith("id")) {
                values[0] = field.get(object);
            }

            if (field.getName().startsWith("descricao")) {
                values[1] = field.get(object);
            }
        }

        return values;
    }

    private static Object createObject(ClasseDescritiva classeDescritiva) throws Exception {

        Class<?> classe = ClasseDescritivaMap.CLASSESDESCRITIVAS.get(classeDescritiva.getTipo());

        Object[] values = recoverValues(classeDescritiva.getClass().getDeclaredFields(), classeDescritiva);

        Constructor<?> ct = classe.getConstructor();

        Object obj = ct.newInstance();

        Field[] fieldsObj = obj.getClass().getDeclaredFields();

        for (Field field : fieldsObj) {
            field.setAccessible(true);
            if (field.getName().startsWith("id")) {
                field.set(obj, values[0]);
            }

            if (field.getName().startsWith("descricao")) {
                String descricao =values[1] == null || values[1].toString().isEmpty() ? null: values[1].toString();
                field.set(obj, descricao);
            }
        }
        return obj;
    }
}
