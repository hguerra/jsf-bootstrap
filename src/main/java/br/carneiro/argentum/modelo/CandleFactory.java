package br.carneiro.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by heitor on 02/04/16.
 */
public class CandleFactory
{
    public Candle constroiCandleParaData(Calendar data,
                                         List<Negociacao> negociacoes) {
        double maximo = !negociacoes.isEmpty() ? negociacoes.get(0).getPreco() : 0;
        double minimo = !negociacoes.isEmpty() ? negociacoes.get(0).getPreco() : 0;

        double volume = 0;

        for (Negociacao negociacao : negociacoes) {

            volume += negociacao.getVolume();
            double preco = negociacao.getPreco();

            if (preco > maximo) {
                maximo = preco;
            } else if (preco < minimo) {
                minimo = preco;
            }
        }

        double abertura = !negociacoes.isEmpty() ? negociacoes.get(0).getPreco() : 0;
        double fechamento = !negociacoes.isEmpty() ? negociacoes.get(negociacoes.size() - 1).getPreco() : 0;


        return new Candle(abertura, fechamento, minimo, maximo, volume, data);
    }

    public List<Candle> constroiCandles(List<Negociacao> todasNegociacoes) {
        Collections.sort(todasNegociacoes);

        List<Candle> candles = new ArrayList<Candle>();

        List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();

        Calendar dataAtual = todasNegociacoes.get(0).getData();

        for (Negociacao negociacao : todasNegociacoes) {
            if (negociacao.getData().before(dataAtual)) {
                throw new IllegalStateException("negociações em ordem errada");
            }
            // se não for mesmo dia, fecha candle e reinicia variáveis
            if (!negociacao.isMesmoDia(dataAtual)) {
                criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
                negociacoesDoDia = new ArrayList<Negociacao>();
                dataAtual = negociacao.getData();
            }
            negociacoesDoDia.add(negociacao);

        }
        // adiciona último candle
        criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
        return candles;
    }

    private void criaEGuardaCandle(List<Candle> candles, List<Negociacao> negociacoesDoDia, Calendar dataAtual)
    {
        Candle candleDoDia = constroiCandleParaData(dataAtual,
                negociacoesDoDia);
        candles.add(candleDoDia);
    }

}
