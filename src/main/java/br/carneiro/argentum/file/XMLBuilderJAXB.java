package br.carneiro.argentum.file;

/**
 * Created by heitor on 02/04/16.
 */

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.OutputStream;

public class XMLBuilderJAXB implements ObjectBuilder {
    private static ObjectBuilder uniqueInstance;

    private XMLBuilderJAXB() {
    }

    public static ObjectBuilder getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new XMLBuilderJAXB();
        }
        return uniqueInstance;
    }

    @Override
    public synchronized <T> T buildObject(Class<?> typeOfClass, InputStream is) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(typeOfClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (T) jaxbUnmarshaller.unmarshal(is);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public synchronized <T> boolean buildFile(T object, OutputStream os, boolean printOut) {
        boolean success = true;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, os);
            if (printOut)
                jaxbMarshaller.marshal(object, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }
}
