package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class TituloTest {

  @Test
  public void camposFormatados() throws Exception {
    LocalDate emissao = LocalDate.of(2017, 9, 19);
    LocalDate vencimento = LocalDate.of(2017, 9, 29);
    Pagador pagador = null;
    Titulo titulo = new Titulo(6.00d, emissao, vencimento, 3, 3, pagador);
    
    assertEquals("000000000000600", titulo.getValor());
    assertEquals("19092017", titulo.getDataEmissao());
    assertEquals("29092017", titulo.getDataVencimeto());
    
    String numeroDocumento11posicoes = titulo.getNumeroDocumento(11).toString();
    assertEquals(11, numeroDocumento11posicoes.length());
    assertEquals("3          ", numeroDocumento11posicoes);
    
    String numeroDocumento25posicoes = titulo.getNumeroDocumento(25).toString();
    assertEquals(25, numeroDocumento25posicoes.length());
    assertEquals("3                        ", numeroDocumento25posicoes);
    assertEquals("000000000000003", titulo.getNossoNumero().toString());
  }
  
}