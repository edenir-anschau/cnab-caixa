package net.anschau.cnab.caixa.cnab240;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class Pagador {
  
  private final String nome;
  private final String documento;
  private final String endereco;
  private final String bairro;
  private final String cep;
  private final String cidade;
  private final String uf;
  
  public Pagador(String nome, String documento, String endereco, String bairro,
                 String cep, String cidade, String uf) {
    this.nome = nome;
    this.documento = documento;
    this.endereco = endereco;
    this.bairro = bairro;
    this.cep = cep;
    this.cidade = cidade;
    this.uf = uf;
  }

  public int tipoInscricao() {
    return documento.length() == 11 ? 1 : 2;
  }

  public CampoAlfaNumerico getNome() {
    return new CampoAlfaNumerico(nome, 40);
  }

  public CampoNumerico getDocumento() {
    return new CampoNumerico(documento, 15);
  }

  public CampoAlfaNumerico getEndereco() {
    return new CampoAlfaNumerico(endereco, 40);
  }

  public CampoAlfaNumerico getBairro() {
    return new CampoAlfaNumerico(bairro, 15);
  }

  public String getCEP() {
    return cep;
  }

  public CampoAlfaNumerico getCidade() {
    return new CampoAlfaNumerico(cidade, 15);
  }

  public String getUF() {
    return uf;
  }
  
}