package br.carneiro.argentum.modelo;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by heitor on 02/04/16.
 */

public final class Negociacao implements Comparable<Negociacao>, Serializable
{
    private final double preco;
    private final int quantidade;
    private final Calendar data;

    public Negociacao(double preco, int quantidade, Calendar data)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("data nao pode ser nula");
        }
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double getPreco()
    {
        return this.preco;
    }

    public int getQuantidade()
    {
        return this.quantidade;
    }

    public Calendar getData()
    {
        return (Calendar) this.data.clone();
    }

    public double getVolume()
    {
        return this.preco * this.quantidade;
    }

    public boolean isMesmoDia(Calendar outraData)
    {
        return this.data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH)
                && this.data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH)
                && this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
    }


    @Override
    public int compareTo(Negociacao o)
    {
        return this.getData().compareTo(o.getData());
    }
}
