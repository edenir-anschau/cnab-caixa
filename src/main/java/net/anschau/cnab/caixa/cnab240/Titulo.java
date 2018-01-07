package net.anschau.cnab.caixa.cnab240;

import java.time.LocalDate;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class Titulo {

  private final double valor;
  private final LocalDate emissao;
  private final LocalDate vencimento;
  private final int numeroDocumento;
  private final int nossoNumero;
  private final Pagador pagador;

  public Titulo(double valor, LocalDate emissao, LocalDate vencimento, 
                int numeroDocumento, int nossoNumero, Pagador pagador) {
    this.valor = valor;
    this.emissao = emissao;
    this.vencimento = vencimento;
    this.numeroDocumento = numeroDocumento;
    this.nossoNumero = nossoNumero;
    this.pagador = pagador;
  }

  public String getValor() {
    return String.format("%016.2f", valor).replaceAll("[^0-9]", "");
  }
  
  public String getDataEmissao() {
    return emissao.format(MoreDateTimeFormatter.DIA_MES_ANO);
  }

  public String getDataVencimeto() {
    return vencimento.format(MoreDateTimeFormatter.DIA_MES_ANO);
  }
  
  public CampoAlfaNumerico getNumeroDocumento(int tamanho) {
    return new CampoAlfaNumerico(numeroDocumento, tamanho);
  }
  
  public CampoNumerico getNossoNumero() {
    return new CampoNumerico(nossoNumero, 15);
  }

  public Pagador getPagador() {
    return pagador;
  }
  
}