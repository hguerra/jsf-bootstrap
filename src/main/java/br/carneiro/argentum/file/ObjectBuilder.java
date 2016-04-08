package br.carneiro.argentum.file;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by heitor on 02/04/16.
 */
public interface ObjectBuilder {
    <T> T buildObject(Class<?> typeOfClass, InputStream is);
    <T> boolean buildFile(T object, OutputStream os, boolean printOut);
}
