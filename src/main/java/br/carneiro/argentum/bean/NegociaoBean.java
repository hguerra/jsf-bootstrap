package br.carneiro.argentum.bean;

import br.carneiro.argentum.modelo.Negociacao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by heitor on 05/04/16.
 */
@ManagedBean
@SessionScoped
public class NegociaoBean implements Serializable
{
    private double preco;
    private int quantidade;
    private Date data;
    private List<Negociacao> negociacoes;

    public NegociaoBean()
    {
        this.negociacoes = new ArrayList<>();

    }

    public void addNegociacao(Negociacao negociacao)
    {
        this.negociacoes.add(negociacao);
    }

    /**
     * Getters and setters
     *
     * @return
     */
    public double getPreco()
    {
        return preco;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public List<Negociacao> getNegociacoes()
    {
        return negociacoes;
    }

    public void setNegociacoes(List<Negociacao> negociacoes)
    {
        this.negociacoes = negociacoes;
    }
}
