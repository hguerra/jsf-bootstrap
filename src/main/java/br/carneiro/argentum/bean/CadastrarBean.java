package br.carneiro.argentum.bean;

import br.carneiro.argentum.modelo.Negociacao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by heitor on 08/04/16.
 */
@ManagedBean(name = "cadastrar")
public class CadastrarBean
{
    private double preco;
    private int quantidade;
    private Date data;

    @ManagedProperty(value = "#{redirectBean}")
    private RedirectBean redirectBean;

    @ManagedProperty(value = "#{negociaoBean}")
    private NegociaoBean negociaoBean;

    public void addNegociacao()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getData());
        Negociacao negociacao = new Negociacao(getPreco(), getQuantidade(), calendar);
        negociaoBean.addNegociacao(negociacao);

    }

    public String visualizarNegociacoes()
    {
        return redirectBean.negociacao();
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

    public RedirectBean getRedirectBean()
    {
        return redirectBean;
    }

    public void setRedirectBean(RedirectBean redirectBean)
    {
        this.redirectBean = redirectBean;
    }

    public NegociaoBean getNegociaoBean()
    {
        return negociaoBean;
    }

    public void setNegociaoBean(NegociaoBean negociaoBean)
    {
        this.negociaoBean = negociaoBean;
    }
}
