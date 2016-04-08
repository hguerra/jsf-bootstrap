package br.carneiro.argentum.reader.proxy;

import br.carneiro.argentum.modelo.Negociacao;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Calendar;

/**
 * Created by heitor on 02/04/16.
 */
@XmlRootElement
public class NegociacaoProxy {
    private double preco;
    private int quantidade;
    private Calendar data;

    public double getPreco() {
        return preco;
    }

    @XmlElement
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @XmlElement
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Calendar getData() {
        return data;
    }

    @XmlElement
    public void setData(Calendar data) {
        this.data = data;
    }

    public Negociacao getNegociacao() {
        return new Negociacao(preco, quantidade, data);
    }

    @XmlTransient
    public void setNegociacao(Negociacao negociacao) {
        this.preco = negociacao.getPreco();
        this.quantidade = negociacao.getQuantidade();
        this.data = negociacao.getData();
    }
}
