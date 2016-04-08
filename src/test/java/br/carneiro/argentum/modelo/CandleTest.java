package br.carneiro.argentum.modelo;

import org.junit.Test;

import java.util.Calendar;

/**
 * Created by heitor on 02/04/16.
 */
public class CandleTest
{

    @Test(expected=IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo() {
        new Candle(10, 20, 20, 10, 10000, Calendar.getInstance());
    }

    @Test(expected=IllegalArgumentException.class)
    public void naoCriaCandlestickComDataNula() {
        new Candle(10, 20, 20, 10, 10000, null);
    }
}
