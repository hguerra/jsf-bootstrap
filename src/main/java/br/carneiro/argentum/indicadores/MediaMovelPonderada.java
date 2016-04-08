package br.carneiro.argentum.indicadores;

import br.carneiro.argentum.modelo.SerieTemporal;

/**
 * Created by heitor on 03/04/16.
 */
public class MediaMovelPonderada implements Indicador
{
    private final Indicador outroIndicador;

    public MediaMovelPonderada(Indicador outroIndicador)
    {
        this.outroIndicador = outroIndicador;
    }

    @Override
    public double calcula(int posicao, SerieTemporal serie)
    {
        double soma = 0.0;

        int peso = getPeriodo();
        int somaDosPesos = getPeriodo();

        for (int i = posicao; i > posicao - getPeriodo(); i--)
        {
            soma += outroIndicador.calcula(i, serie) * peso;
            peso--;
            somaDosPesos += peso;
        }
        return soma / somaDosPesos;
    }

    @Override
    public int getPeriodo()
    {
        return 3;
    }

    public String toString()
    {
        return "MMP de Fechamento";
    }
}
