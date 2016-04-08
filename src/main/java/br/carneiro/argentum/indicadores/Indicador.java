package br.carneiro.argentum.indicadores;

import br.carneiro.argentum.modelo.SerieTemporal;

/**
 * Created by heitor on 03/04/16.
 */
public interface Indicador
{
    double calcula(int posicao, SerieTemporal serie);

    int getPeriodo();
}
