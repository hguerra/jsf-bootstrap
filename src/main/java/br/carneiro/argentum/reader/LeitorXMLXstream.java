package br.carneiro.argentum.reader;

import br.carneiro.argentum.modelo.Negociacao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.InputStream;
import java.util.List;

/**
 * Created by heitor on 03/04/16.
 */
public class LeitorXMLXstream implements  LeitorXML {
    @Override
    public List<Negociacao> carrega(InputStream in) {
        XStream stream = new XStream(new DomDriver());
        stream.alias("cadastrar", Negociacao.class);
        return (List<Negociacao>) stream.fromXML(in);
    }
}
