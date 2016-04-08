package br.carneiro.argentum.ws;

import br.carneiro.argentum.modelo.Negociacao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by heitor on 03/04/16.
 */
public class ClienteWebServiceMockTest
{
    @Test
    public void getNegociacoes(){
        ClienteWebService webService = new ClienteWebServiceMock();
        List<Negociacao> negociacoes = webService.getNegociacoes();

        assertEquals(240, negociacoes.size());
    }
}
