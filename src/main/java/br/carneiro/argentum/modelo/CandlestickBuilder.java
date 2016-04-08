package br.carneiro.argentum.modelo;

import java.util.Calendar;

/**
 * Created by heitor on 02/04/16.
 */
public class CandlestickBuilder {
    private double abertura;
    private double fechamento;
    private double minimo;
    private double maximo;
    private double volume;
    private Calendar data;

    public CandlestickBuilder comAbertura(double abertura) {
        this.abertura = abertura;
        return this;
    }

    public CandlestickBuilder comFechamento(double fechamento) {
        this.fechamento = fechamento;
        return this;
    }
    public CandlestickBuilder comMinimo(double minimo) {
        this.minimo = minimo;
        return this;
    }
    public CandlestickBuilder comMaximo(double maximo) {
        this.maximo = maximo;
        return this;
    }
    public CandlestickBuilder comVolume(double volume) {
        this.volume = volume;
        return this;
    }
    public CandlestickBuilder comData(Calendar data) {
        this.data = data;
        return this;
    }
    public Candle geraCandle() {
        return new Candle(abertura, fechamento, minimo, maximo,
                volume, data);
    }

}
