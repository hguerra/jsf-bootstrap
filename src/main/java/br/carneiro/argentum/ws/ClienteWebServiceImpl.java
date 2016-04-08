package br.carneiro.argentum.ws;

import br.carneiro.argentum.modelo.Negociacao;
import br.carneiro.argentum.reader.LeitorXMLXstream;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by heitor on 03/04/16.
 */
public class ClienteWebServiceImpl implements ClienteWebService
{
    private static final String URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes";

    public List<Negociacao> getNegociacoes() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(URL_WEBSERVICE);
            connection = (HttpURLConnection) url.openConnection();
            InputStream content = connection.getInputStream();
            return new LeitorXMLXstream().carrega(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }
    }
}
