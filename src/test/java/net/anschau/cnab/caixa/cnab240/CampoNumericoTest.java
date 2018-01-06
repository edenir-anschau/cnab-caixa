package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class CampoNumericoTest {

  @Test
  public void normalizaCampoNumerico() {
    CampoNumerico campoNumerico = new CampoNumerico("123", 5);
    
    assertEquals("00123", campoNumerico.toString());
  }
  
}