package br.carneiro.argentum.bean;

import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by heitor on 05/04/16.
 */
@ManagedBean
public class NegociaoBean
{
    private double preco;
    private int quantidade;
    private Date data;

    public void printData()
    {
        String data = new SimpleDateFormat("dd/MM/yyyy").format(getData());
        System.out.println(data);
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
}
