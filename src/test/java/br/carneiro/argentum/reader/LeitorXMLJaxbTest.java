package br.carneiro.argentum.reader;

import br.carneiro.argentum.file.ObjectBuilder;
import br.carneiro.argentum.file.XMLBuilderJAXB;
import br.carneiro.argentum.modelo.Negociacao;
import br.carneiro.argentum.reader.proxy.Negociacoes;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by heitor on 02/04/16.
 */
public class LeitorXMLJaxbTest {
    @Test
    public void carregaXmlComUmaNegociacaoEmListaUnitaria() throws FileNotFoundException {
        InputStream in = new FileInputStream(new File("argentum.xml"));

        LeitorXMLJaxb leitorXML = new LeitorXMLJaxb();
        List<Negociacao> negociacoes = leitorXML.carrega(in);

        Assert.assertEquals(2, negociacoes.size());

    }

    @Test
    public void salvarXmlComUmaNegociacaoEmListaUnitaria() throws IOException {
        Negociacao negociacao1 = new Negociacao(40.5, 100, Calendar.getInstance());
        Negociacao negociacao2 = new Negociacao(45.0, 100, Calendar.getInstance());

        Negociacoes negociacoes = new Negociacoes();
        negociacoes.add(negociacao1);
        negociacoes.add(negociacao2);

        ObjectBuilder xmlBuilder = XMLBuilderJAXB.getInstance();

        OutputStream os = new FileOutputStream(new File("argentum.xml"));

        boolean actual = xmlBuilder.buildFile(negociacoes, os, true);

        Assert.assertTrue(actual);
    }
}
