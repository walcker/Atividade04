import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.*;

class ClassTest {

    @Test
    void existsPerson() throws ClassNotFoundException {
        Class<?> clazzPerson = Class.forName("br.ufrn.imd.Person");
        assertNotNull(clazzPerson);
    }

    @Test
    void existsAttrInPerson() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> clazzPerson = Class.forName("br.ufrn.imd.Person");
        Field fieldName = clazzPerson.getField("name");
        Field fieldNameHome = clazzPerson.getField("hometown");

        assertNotNull(fieldName);
        assertEquals("java.lang.String", fieldName.getGenericType().getTypeName());

        assertNotNull(fieldNameHome);
        assertEquals("java.lang.String", fieldNameHome.getGenericType().getTypeName());
    }


    @Test
    void existsMethodInPerson() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzPerson = Class.forName("br.ufrn.imd.Person");
        Method methodHometown = clazzPerson.getMethod("hometown");
        assertNotNull(methodHometown);
        assertEquals(0, methodHometown.getParameterCount());
        assertEquals("java.lang.String", methodHometown.getGenericReturnType().getTypeName());

        Method methodName = clazzPerson.getMethod("name");
        assertNotNull(methodName);
        assertEquals(0, methodName.getParameterCount());
        assertEquals("java.lang.String", methodName.getGenericReturnType().getTypeName());

    }

    @Test
    void existsMusician() throws ClassNotFoundException {
        Class<?> clazzMusician = Class.forName("br.ufrn.imd.Musician");
        assertNotNull(clazzMusician);
    }

    @Test
    void existsAttrInMusician() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> clazzPerson = Class.forName("br.ufrn.imd.Musician");

        Field fieldNameCanImprovise = clazzPerson.getField("canImprovise");
        assertNotNull(fieldNameCanImprovise);
        assertEquals("boolean", fieldNameCanImprovise.getGenericType().getTypeName());

        Field canCompose = clazzPerson.getField("canCompose");
        assertNotNull(canCompose);
        assertEquals("boolean", canCompose.getGenericType().getTypeName());

        Field fieldNamePlayClassicalMusic = clazzPerson.getField("playClassicalMusic");
        assertNotNull(fieldNamePlayClassicalMusic);
        assertEquals("boolean", fieldNamePlayClassicalMusic.getGenericType().getTypeName());

    }

    @Test
    void existsMethodPlayInMusician() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzPerson = Class.forName("br.ufrn.imd.Musician");
        Method method = clazzPerson.getMethod("play");
        System.out.println(method);
        assertNotNull(method);
        assertEquals(0, method.getParameterCount());
        assertEquals("void", method.getGenericReturnType().getTypeName());
    }

    @Test
    void existsGuitarPlayer() throws ClassNotFoundException {
        Class<?> clazzGuitarPlayer = Class.forName("br.ufrn.imd.GuitarPlayer");
        assertNotNull(clazzGuitarPlayer);
    }

    @Test
    void existsMusicianExtendsPerson() throws ClassNotFoundException {
        Class<?> clazzMusician = Class.forName("br.ufrn.imd.Musician");
        Type superClazz = clazzMusician.getGenericSuperclass();
        assertEquals("br.ufrn.imd.Person", superClazz.getTypeName());
    }

    @Test
    void existsGuitarPlayerExtendsMusician() throws ClassNotFoundException {
        Class<?> clazzGP = Class.forName("br.ufrn.imd.GuitarPlayer");
        Type superClazz = clazzGP.getGenericSuperclass();
        assertEquals("br.ufrn.imd.Musician", superClazz.getTypeName());
    }

    @Test
    void existsAttrInGuitarPlayer() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> clazzPerson = Class.forName("br.ufrn.imd.GuitarPlayer");

        Field fieldNameHowMany = clazzPerson.getField("howManyYears");
        assertNotNull(fieldNameHowMany);
        assertEquals("int", fieldNameHowMany.getGenericType().getTypeName());

        Field fieldNamePlayEletricGuitar = clazzPerson.getField("playEletronicGuitar");
        assertNotNull(fieldNamePlayEletricGuitar);
        assertEquals("boolean", fieldNamePlayEletricGuitar.getGenericType().getTypeName());

        Field fieldNamePlayAcousticGuitar = clazzPerson.getField("playAcousticGuitar");
        assertNotNull(fieldNamePlayAcousticGuitar);
        assertEquals("boolean", fieldNamePlayAcousticGuitar.getGenericType().getTypeName());

    }

    @Test
    void existsMethodPlayGuitarInGuitarPlayer() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzPerson = Class.forName("br.ufrn.imd.GuitarPlayer");
        Method method = clazzPerson.getMethod("playGuitar");
        System.out.println(method);
        assertNotNull(method);
        assertEquals(0, method.getParameterCount());
        assertEquals("void", method.getGenericReturnType().getTypeName());
    }

}