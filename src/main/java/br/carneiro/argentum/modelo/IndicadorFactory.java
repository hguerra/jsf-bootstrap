package br.carneiro.argentum.modelo;

import br.carneiro.argentum.indicadores.Indicador;
import br.carneiro.argentum.indicadores.IndicadorFechamento;
import br.carneiro.argentum.indicadores.MediaMovelSimples;

import java.lang.reflect.Constructor;

/**
 * Created by heitor on 03/04/16.
 */
public class IndicadorFactory
{
    private final static String PACOTE = "br.carneiro.argentum.indicadores.";
    private final String nomeMedia;
    private final String nomeIndicadorBase;

    public IndicadorFactory(String nomeMedia, String nomeIndicadorBase)
    {
        this.nomeMedia = nomeMedia;
        this.nomeIndicadorBase = nomeIndicadorBase;
    }

    public Indicador defineIndicador()
    {

        if (nomeIndicadorBase == null || nomeMedia == null)
        {
            return new MediaMovelSimples(new IndicadorFechamento());
        }
        try
        {
            /*Cria a instancia da classe Indicador, ex: IndicadorFechamento*/
            Class<?> classeIndicadorBase = Class.forName(PACOTE + nomeIndicadorBase);
            Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();

            /*Cria a instancia da MediaMovel, ex: MediaMovelSimples*/
            Class<?> classMedia = Class.forName(PACOTE + nomeMedia);
            //Cria o construtor com parametro do tipo Indicador*/
            Constructor<?> constructorMedia = classMedia.getConstructor(Indicador.class);
            Indicador indicador = (Indicador) constructorMedia.newInstance(indicadorBase);

            return indicador;

        } catch (Exception e)
        {
            throw new RuntimeException("Erro ao construir Indicador!!");
        }
    }
}
