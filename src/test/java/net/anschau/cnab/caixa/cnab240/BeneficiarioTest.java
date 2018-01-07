package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import net.anschau.cnab.caixa.cnab240.Beneficiario;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class BeneficiarioTest {

  @Test
  public void deveRetornarTipoInscricao1QuandoPF() {
    Beneficiario beneficiario;
    beneficiario = new Beneficiario("João da Silva", "1087", 1,  "123456", "86479743520");
    
    assertEquals(1, beneficiario.tipoInscricao());
  }
  
  @Test
  public void deveRetornarTipoInscricao2QuandoPJ() {
    Beneficiario beneficiario;
    beneficiario = new Beneficiario("João da Silva", "1087", 1,  "123456", "55939793000109");
    
    assertEquals(2, beneficiario.tipoInscricao());
  }
  
  @Test
  public void camposFormatados() throws Exception {
    Beneficiario beneficiario;
    beneficiario = new Beneficiario("João da Silva", "1087", 1,  "123456", "86479743520");
    
    assertEquals(1, beneficiario.tipoInscricao());
    assertEquals("JOAO DA SILVA                 ", beneficiario.getNome().toString());
    assertEquals("01087", beneficiario.getAgencia().toString());
    assertEquals(1, beneficiario.getDvAgencia());
    assertEquals("123456", beneficiario.getContaCorrente().toString());
    assertEquals("00086479743520", beneficiario.getDocumento().toString());
  }
  
}