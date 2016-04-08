package br.carneiro.argentum.indicadores;

import br.carneiro.argentum.modelo.SerieTemporal;

/**
 * Created by heitor on 03/04/16.
 */
public class MediaMovelSimples implements Indicador
{
    private final Indicador outroIndicador;

    public MediaMovelSimples(Indicador outroIndicador)
    {
        this.outroIndicador = outroIndicador;
    }

    @Override
    public double calcula(int posicao, SerieTemporal serie)
    {
        double soma = 0.0;
        for (int i = posicao; i > posicao-getPeriodo(); i--)
            soma += outroIndicador.calcula(i, serie);
        return soma/getPeriodo();
    }

    @Override
    public int getPeriodo()
    {
        return 3;
    }

    public String toString() {
        return "MMS de Fechamento";
    }

}
