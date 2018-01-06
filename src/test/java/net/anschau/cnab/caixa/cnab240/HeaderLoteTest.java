package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.Test;
import net.anschau.cnab.caixa.cnab240.Beneficiario;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class HeaderLoteTest {

  @Test
  public void header() throws Exception {
    Beneficiario beneficiario;
    beneficiario = new Beneficiario("João da Silva", "1087", 1,  "123456", "86479743520");
    
    LocalDate dataGravacao = LocalDate.of(2017, 10, 2);
    HeaderLote header = new HeaderLote(beneficiario, 1, dataGravacao);
    
    String esperado = "10400011R0100030 10000864797435201234560000000000000001087112345600000000"
        + "JOAO DA SILVA                                                                        "
        + "                         000000010210201700000000                                 ";
    
    assertEquals(esperado, header.get());
  }
  
}