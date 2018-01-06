package net.anschau.cnab.caixa.cnab240;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import net.anschau.cnab.caixa.cnab240.Beneficiario;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class RemessaTest {

  @Test
  public void deveGerarRemessaComUmTitulo() {
    String esperado = Arquivos.REMESSA_1_TITULO;

    Beneficiario beneficiario;
    beneficiario = new Beneficiario("João da Silva", "1087", 1,  "123456", "86479743520");
    
    Pagador pagador;
    pagador = novoPagador("Pagador PF", "65453512300", "Rua ABC, 123", "Centro", "12345678");
    
    LocalDate emissao = LocalDate.of(2017, 10,02);
    LocalDate vencimento = LocalDate.of(2017, 9, 29);
    Titulo titulo = new Titulo(6.00d, emissao, vencimento, 3, 3, pagador);
    List<Titulo> titulos = ImmutableList.of(titulo);
    
    int numeroRemessa = 1;
    LocalDateTime dataHoraGeracao = LocalDateTime.of(2017, 10, 2, 8, 9, 44);
    LocalDate dataGravacao = LocalDate.of(2017, 10, 2);
    Remessa remessa = new Remessa(numeroRemessa, beneficiario, titulos, 
                                  dataHoraGeracao, dataGravacao);
    
    String remessaGerada = remessa.gerarArquivo();
    String[] linhasRemessa = remessaGerada.split("\n");
    
    assertEquals(6, linhasRemessa.length);
    assertEquals(esperado, remessaGerada);
  }
  
  @Test
  public void deveGerarRemessaComTresTitulo() {
    String esperado = Arquivos.REMESSA_3_TITULOS;
    
    Beneficiario beneficiario;
    beneficiario = new Beneficiario("João da Silva", "1087", 1,  "123456", "86479743520");
    
    List<Titulo> titulos = titulos();
    
    int numeroRemessa = 1;
    LocalDateTime dataHoraGeracao = LocalDateTime.of(2017, 10, 2, 8, 9, 44);
    LocalDate dataGravacao = LocalDate.of(2017, 10, 2);
    Remessa remessa = new Remessa(numeroRemessa, beneficiario, titulos, 
                                  dataHoraGeracao, dataGravacao);
    
    String remessaGerada = remessa.gerarArquivo();
    String[] linhasRemessa = remessaGerada.split("\n");
    
    assertEquals(10, linhasRemessa.length);
    assertEquals(esperado, remessaGerada);
  }
  
  private List<Titulo> titulos() {
    Pagador pagador1;
    pagador1 = novoPagador("Pagador PF1", "65453512300", "Rua ABC, 123", "Centro", "12345678");
    
    Pagador pagador2;
    pagador2 = novoPagador("Pagador PF2", "27443347235", "Rua ABCD, 1233", "Centro", "12345679");
    
    Pagador pagador3;
    pagador3 = novoPagador("Pagador PF3", "54810761797", "Rua ABCDE, 0123", "Centro", "12345670");
    
    LocalDate emissao = LocalDate.of(2017, 8, 2);
    LocalDate vencimento = LocalDate.of(2017, 9, 29);
    Titulo titulo1 = new Titulo(6.00d, emissao, vencimento, 3, 3, pagador1);
    Titulo titulo2;
    titulo2 = new Titulo(2500.00d, emissao.plusDays(1), vencimento.plusDays(1), 55, 55, pagador2);
    Titulo titulo3;
    titulo3 = new Titulo(1365.00d, emissao.plusDays(2), vencimento.plusDays(2), 1500, 1500, pagador3);
    return ImmutableList.of(titulo1, titulo2, titulo3);
  }
  
  private Pagador novoPagador(String nome, String documento, String endereco, String bairro,
                              String cep) {
   return new Pagador(nome, documento, endereco, bairro, cep, "São Paulo", "SP");
  }
  
}