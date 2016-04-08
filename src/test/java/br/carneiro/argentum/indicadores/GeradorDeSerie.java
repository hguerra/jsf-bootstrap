package br.carneiro.argentum.indicadores;

import br.carneiro.argentum.modelo.Candle;
import br.carneiro.argentum.modelo.SerieTemporal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by heitor on 03/04/16.
 */
public class GeradorDeSerie
{
    public static SerieTemporal criaSerie(double... valores)
    {
        List<Candle> candles = new ArrayList<Candle>();
        for (double d : valores)
        {
            candles.add(new Candle(d, d, d, d, 1000, Calendar.getInstance()));
        }
        return new SerieTemporal(candles);
    }
}
