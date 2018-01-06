package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;
import net.anschau.cnab.caixa.cnab240.Beneficiario;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class SegmentoPTest {

  @Test
  public void segmentoP() throws Exception {
    String esperado = Arquivos.SEGMENTO_P;
    
    Beneficiario beneficiario;
    beneficiario = new Beneficiario("João da Silva", "1087", 1,  "123456", "86479743520");
    
    LocalDate emissao = LocalDate.of(2017, 10,02);
    LocalDate vencimento = LocalDate.of(2017, 9, 29);
    Pagador pagador = null;
    Titulo titulo = new Titulo(6.00d, emissao, vencimento, 3, 3, pagador);
    
    SegmentoP segmentoP = new SegmentoP(1, beneficiario, titulo);
    String res = segmentoP.get();
    
    assertEquals(240, res.length());
    assertEquals(esperado, res);
  }
  
}