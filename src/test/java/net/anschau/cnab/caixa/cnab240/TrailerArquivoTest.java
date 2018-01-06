package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class TrailerArquivoTest {

  @Test
  public void trailer() throws Exception {
    int quantidadeLotes = 1;
    int quantidadeRegistros = 6;
    TrailerArquivo trailer = new TrailerArquivo(quantidadeLotes, quantidadeRegistros);
    
    String esperado = "10499999         000001000006                                            "
        + "                                                                                     "
        + "                                                                                  ";
    
    assertEquals(esperado, trailer.get());
  }
  
}