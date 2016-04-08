package br.carneiro.argentum.bean;

import br.carneiro.argentum.modelo.*;
import br.carneiro.argentum.ws.ClienteWebServiceMock;
import org.primefaces.model.chart.ChartModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by heitor on 03/04/16.
 */
@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable
{
    private List<Negociacao> negociacoes;
    private ChartModel modeloGrafico;
    private String nomeMedia;
    private String nomeIndicadorBase;

    public ArgentumBean()
    {
        // real
        //this.negociacoes = new ClienteWebServiceImpl().getNegociacoes();
        // mock
        this.negociacoes = new ClienteWebServiceMock().getNegociacoes();
        gerarGrafico();
    }

    public void gerarGrafico()
    {
        System.out.println("PLOTANDO: " + nomeMedia + " de " + nomeIndicadorBase);
        List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
        SerieTemporal serie = new SerieTemporal(candles);

        GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());

        IndicadorFactory fabrica = new IndicadorFactory(nomeMedia, nomeIndicadorBase);
        geradorGrafico.plotaIndicador(fabrica.defineIndicador());
        this.modeloGrafico = geradorGrafico.getModeloGrafico();

    }


    /**
     * Getters and setters
     *
     * @return
     */
    public List<Negociacao> getNegociacoes()
    {
        return negociacoes;
    }

    public void setNegociacoes(List<Negociacao> negociacoes)
    {
        this.negociacoes = negociacoes;
    }

    public ChartModel getModeloGrafico()
    {
        return modeloGrafico;
    }

    public void setModeloGrafico(ChartModel modeloGrafico)
    {
        this.modeloGrafico = modeloGrafico;
    }

    public String getNomeMedia()
    {
        return nomeMedia;
    }

    public void setNomeMedia(String nomeMedia)
    {
        this.nomeMedia = nomeMedia;
    }

    public String getNomeIndicadorBase()
    {
        return nomeIndicadorBase;
    }

    public void setNomeIndicadorBase(String nomeIndicadorBase)
    {
        this.nomeIndicadorBase = nomeIndicadorBase;
    }
}
