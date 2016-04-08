package br.carneiro.argentum.ws;

import br.carneiro.argentum.modelo.Negociacao;

import java.util.List;

/**
 * Created by heitor on 03/04/16.
 */
public interface ClienteWebService
{
    List<Negociacao> getNegociacoes();
}
