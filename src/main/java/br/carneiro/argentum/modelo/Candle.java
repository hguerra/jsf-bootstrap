package br.carneiro.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by heitor on 02/04/16.
 */
public final class Candle
{
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volume;
    private final Calendar data;

    public Candle(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
        if(minimo > maximo || data == null)
            throw new IllegalArgumentException("Valor minimo nao pode ser maior que o maximo");
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
    }

    public double getAbertura() {
        return abertura;
    }

    public double getFechamento() {
        return fechamento;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getVolume() {
        return volume;
    }

    public Calendar getData() {
        return data;
    }

    public boolean isAlta() {
        return this.abertura < this.fechamento;
    }

    public boolean isBaixa() {
        return this.abertura > this.fechamento;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Abertura ").append(getAbertura()).append(",");
        stringBuilder.append("Fechamento ").append(getFechamento()).append(",");
        stringBuilder.append("Minima ").append(getMinimo()).append(",");
        stringBuilder.append("Maximo ").append(getMaximo()).append(",");
        stringBuilder.append("Volume ").append(getVolume()).append(",");
        stringBuilder.append("Data ").append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(getData().getTime()));
        return stringBuilder.toString();
    }
}
