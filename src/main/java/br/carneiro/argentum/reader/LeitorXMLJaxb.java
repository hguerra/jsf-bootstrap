package br.carneiro.argentum.reader;

import br.carneiro.argentum.modelo.Negociacao;
import br.carneiro.argentum.reader.proxy.Negociacoes;
import br.carneiro.argentum.file.ObjectBuilder;
import br.carneiro.argentum.file.XMLBuilderJAXB;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heitor on 02/04/16.
 */
public class LeitorXMLJaxb implements LeitorXML {
    @Override
    public List<Negociacao> carrega(InputStream in) {
        ObjectBuilder xmlBuilder = XMLBuilderJAXB.getInstance();
        Negociacoes negociacoes = xmlBuilder.buildObject(Negociacoes.class, in);

        List<Negociacao> resultado = new ArrayList<>();

        negociacoes.getNegociacoes().forEach(n -> resultado.add(n.getNegociacao()));
        return resultado;
    }
}