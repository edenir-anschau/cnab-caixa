package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class CampoAlfaNumericoTest {

  @Test
  public void normalizaCampoAlphaNumerico() {
    CampoAlfaNumerico campoNumerico = new CampoAlfaNumerico("ação", 6);
    
    assertEquals("ACAO  ", campoNumerico.toString());
  }
  
  @Test
  public void deveRetornarValorComTamanhoMaximoPermitido() throws Exception {
    CampoAlfaNumerico campo = new CampoAlfaNumerico("Fulano Da Silva", 12);
    
    assertEquals(12, campo.toString().length());
    assertEquals("FULANO DA SI", campo.toString());
  }
  
}