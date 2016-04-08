package br.carneiro.argentum.indicadores;

import br.carneiro.argentum.modelo.SerieTemporal;

/**
 * Created by heitor on 03/04/16.
 */
public class IndicadorFechamento implements Indicador
{
    @Override
    public double calcula(int posicao, SerieTemporal serie)
    {
        return serie.getCandle(posicao).getFechamento();
    }

    @Override
    public int getPeriodo()
    {
        return 1;
    }

    public String toString()
    {
        return "Fechamento";
    }
}
