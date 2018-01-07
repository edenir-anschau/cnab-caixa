package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class SegmentoQTest {

  @Test
  public void segmentoQ() throws IOException {
    String esperado = Arquivos.SEGMENTO_Q;

    Pagador pagador;
    pagador = new Pagador("Pagador Xpto", "65453512300", "Rua ABC, 123","Centro", "12345678", 
                          "São Paulo", "SP");
    
    SegmentoQ segmentoQ = new SegmentoQ(2, pagador);
    
    String res = segmentoQ.get();
    
    assertEquals(240, res.length());
    assertEquals(esperado, res);
  }
  
}