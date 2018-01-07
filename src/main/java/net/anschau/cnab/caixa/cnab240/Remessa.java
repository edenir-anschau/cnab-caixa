package net.anschau.cnab.caixa.cnab240;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.google.common.collect.ImmutableList;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class Remessa {

  private final int numeroRemessa;
  private final Beneficiario beneficiario;
  private final List<Titulo> titulos;
  private final LocalDateTime dataHoraGeracao;
  private final LocalDate dataGravacao;

  public Remessa(int numeroRemessa, Beneficiario beneficiario, List<Titulo> titulos) {
    this.numeroRemessa = numeroRemessa;
    this.beneficiario = beneficiario;
    this.titulos = ImmutableList.copyOf(titulos);
    this.dataHoraGeracao = LocalDateTime.now();
    this.dataGravacao = LocalDate.now();
  }
  
  public Remessa(int numeroRemessa, Beneficiario beneficiario, List<Titulo> titulos, 
                 LocalDateTime dataHoraGeracao, LocalDate dataGravacao) {
    this.numeroRemessa = numeroRemessa;
    this.beneficiario = beneficiario;
    this.titulos = titulos;
    this.dataHoraGeracao = dataHoraGeracao;
    this.dataGravacao = dataGravacao;
  }

  public String gerarArquivo() {
    HeaderArquivo headerArquivo = new HeaderArquivo(beneficiario, numeroRemessa, 
                                                    dataHoraGeracao);
    HeaderLote headerLote = new HeaderLote(beneficiario, numeroRemessa, dataGravacao);

    String segmentos = "";
    int contador = 1;
    for (Titulo titulo : titulos) {
      SegmentoP segmentoP = new SegmentoP(contador, beneficiario, titulo);
      segmentos = segmentos + "\n" + segmentoP.get();
      
      contador++;
      
      SegmentoQ segmentoQ = new SegmentoQ(contador, titulo.getPagador());
      segmentos = segmentos + "\n" + segmentoQ.get();
      contador++;
    }
    
    int quantidadeRegistros = 2 + (titulos.size() * 2);
    TrailerLote trailerLote = new TrailerLote(quantidadeRegistros);
    
    TrailerArquivo trailerArquivo = new TrailerArquivo(1, quantidadeRegistros + 2);
    
    return headerArquivo.get() + '\n' + headerLote.get() + 
        segmentos + '\n' + trailerLote.get() + '\n' + trailerArquivo.get();
  }

}