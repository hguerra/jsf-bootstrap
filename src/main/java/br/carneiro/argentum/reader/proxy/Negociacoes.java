package br.carneiro.argentum.reader.proxy;

import br.carneiro.argentum.modelo.Negociacao;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heitor on 02/04/16.
 */
@XmlRootElement(name = "argentum")
public class Negociacoes {
    private List<NegociacaoProxy> negociacoes;

    public Negociacoes() {
        this.negociacoes = new ArrayList<>();
    }

    public boolean add(Negociacao negociacao) {
        NegociacaoProxy proxy = new NegociacaoProxy();
        proxy.setNegociacao(negociacao);
        return this.negociacoes.add(proxy);
    }

    public List<NegociacaoProxy> getNegociacoes() {
        return negociacoes;
    }

    @XmlElement
    public void setNegociacoes(List<NegociacaoProxy> negociacoes) {
        this.negociacoes = negociacoes;
    }
}
