package br.carneiro.argentum.reader;

import br.carneiro.argentum.modelo.Negociacao;

import java.io.InputStream;
import java.util.List;

/**
 * Created by heitor on 03/04/16.
 */
public interface LeitorXML {
   List<Negociacao> carrega(InputStream in);
}
