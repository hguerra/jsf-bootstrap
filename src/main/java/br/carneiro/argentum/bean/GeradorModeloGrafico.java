package br.carneiro.argentum.bean;

import br.carneiro.argentum.indicadores.Indicador;
import br.carneiro.argentum.modelo.SerieTemporal;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 * Created by heitor on 03/04/16.
 */
public class GeradorModeloGrafico
{
    private SerieTemporal serie;
    private int comeco;
    private int fim;
    private LineChartModel modeloGrafico;

    public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim)
    {
        this.serie = serie;
        this.comeco = comeco;
        this.fim = fim;
        this.modeloGrafico = new LineChartModel();
    }

    public void plotaIndicador(Indicador indicador)
    {
        LineChartSeries chartSerie = new LineChartSeries(indicador.toString());
        for (int i = comeco; i <= fim; i++)
        {
            double valor = indicador.calcula(i, serie);
            chartSerie.set(i, valor);
        }
        this.modeloGrafico.addSeries(chartSerie);
        this.modeloGrafico.setLegendPosition("w");
        this.modeloGrafico.setTitle("Indicadores");
    }

    public LineChartModel getModeloGrafico()
    {
        return modeloGrafico;
    }
}
