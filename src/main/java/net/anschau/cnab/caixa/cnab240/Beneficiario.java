package net.anschau.cnab.caixa.cnab240;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class Beneficiario {

  private final String nome;
  private final String agencia;
  private final int dvAgencia;
  private final String contaCorrente;
  private final String documento;

  public Beneficiario(String nome, String agencia, int dvAgencia,
                      String contaCorrente, String documento) {
    this.nome = nome;
    this.agencia = agencia;
    this.dvAgencia = dvAgencia;
    this.contaCorrente = contaCorrente;
    this.documento = documento;
  }

  public int tipoInscricao() {
    return documento.length() == 11 ? 1 : 2;
  }
  
  public CampoAlfaNumerico getNome() {
    return new CampoAlfaNumerico(nome, 30);
  }
  
  public CampoNumerico getDocumento() {
    return new CampoNumerico(documento, 14);
  }

  public CampoNumerico getAgencia() {
    return new CampoNumerico(agencia, 5);
  }
  
  public int getDvAgencia() {
    return dvAgencia;
  }
  
  public CampoNumerico getContaCorrente() {
    return new CampoNumerico(contaCorrente, 6);
  }

}