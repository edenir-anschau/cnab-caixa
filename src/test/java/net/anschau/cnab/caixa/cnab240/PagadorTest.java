package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class PagadorTest {

  @Test
  public void deveRetornarTipoInscricao1QuandoPF() {
    Pagador pagadorPF;
    pagadorPF = novoPagador("Pagador PF", "65453512300", "Rua ABC, 123", "Centro", "12345678");
    
    assertEquals(1, pagadorPF.tipoInscricao());
  }
  
  @Test
  public void deveRetornarTipoInscricao2QuandoPJ() {
    Pagador pagadorPJ;
    pagadorPJ = novoPagador("Pagador PJ", "15232943000117", "Rua ABC, 123", "Centro", "12345678");
    
    assertEquals(2, pagadorPJ.tipoInscricao());
  }
  
  @Test
  public void camposFormatados() {
    Pagador pagador;
    pagador = novoPagador("Pagador Xpto", "65453512300", "Rua Abc, 123", "Centro", "12345678");
    
    assertEquals("PAGADOR XPTO                            ", pagador.getNome().toString());
    assertEquals("000065453512300", pagador.getDocumento().toString());
    assertEquals("RUA ABC, 123                            ", pagador.getEndereco().toString());
    assertEquals("CENTRO         ", pagador.getBairro().toString());
    assertEquals("12345678", pagador.getCEP());
    assertEquals("SAO PAULO      ", pagador.getCidade().toString());
    assertEquals("SP", pagador.getUF());
  }

  private Pagador novoPagador(String nome, String documento, String endereco, String bairro,
                              String cep) {
   return new Pagador(nome, documento, endereco, bairro, cep, "São Paulo", "SP");
  }
  
}