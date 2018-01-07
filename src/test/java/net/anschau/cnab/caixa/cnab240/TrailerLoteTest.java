package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class TrailerLoteTest {

  @Test
  public void trailer() throws Exception {
    int quantidadeRegistros = 4;
    TrailerLote trailer = new TrailerLote(quantidadeRegistros);
    
    String esperado = "10400015         00000400000000000000000000000000000000000000000000000000"
        + "0000000000000000000                                                                 "
        + "                                                                                   ";
    
    assertEquals(esperado, trailer.get());
  }
  
}