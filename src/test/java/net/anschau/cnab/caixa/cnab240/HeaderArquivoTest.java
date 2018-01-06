package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import org.junit.Test;
import net.anschau.cnab.caixa.cnab240.Beneficiario;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class HeaderArquivoTest {

  @Test
  public void header() {
    String esperado = "10400000         1000864797435200000000000000000000001087112345600000000"
        + "JOAO DA SILVA                 CAIXA ECONOMICA FEDERAL                 10210201708094"
        + "400000105000000                    REMESSA-PRODUCAO                                 ";

    Beneficiario beneficiario;
    beneficiario = new Beneficiario("João da Silva", "1087", 1,  "123456", "86479743520");
    
    LocalDateTime dataHoraGeracao = LocalDateTime.of(2017, 10, 2, 8, 9, 44);
    HeaderArquivo headerDeArquivo = new HeaderArquivo(beneficiario, 1, dataHoraGeracao);
    String header = headerDeArquivo.get();
    
    assertTrue(header.length() == 240);
    assertEquals(esperado, header);
  }
  
}