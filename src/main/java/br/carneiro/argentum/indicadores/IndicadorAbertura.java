package br.carneiro.argentum.indicadores;

import br.carneiro.argentum.modelo.SerieTemporal;

/**
 * Created by heitor on 03/04/16.
 */
public class IndicadorAbertura implements Indicador
{
    @Override
    public double calcula(int posicao, SerieTemporal serie)
    {
        return serie.getCandle(posicao).getAbertura();
    }

    @Override
    public int getPeriodo()
    {
        return 1;
    }

    public String toString() {
        return "Abertura";
    }
}
