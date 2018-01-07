package net.anschau.cnab.caixa.cnab240;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class TrailerArquivo {

  private final int quantidadeLotes;
  private final int quantidadeRegistros;

  public TrailerArquivo(int quantidadeLotes, int quantidadeRegistros) {
    this.quantidadeLotes = quantidadeLotes;
    this.quantidadeRegistros = quantidadeRegistros;
  }

  public String get() {
    StringBuilder trailer = new StringBuilder(240);
    trailer.append("104");//1-3
    //TODO numeração do lote
    trailer.append("9999");//4-7
    trailer.append("9");//8-8
    trailer.append(new CampoAlfaNumerico(" ", 9));//9-17
    trailer.append(new CampoNumerico(quantidadeLotes, 6));//18-23
    trailer.append(new CampoNumerico(quantidadeRegistros, 6));//24-29
    trailer.append(new CampoAlfaNumerico(" ", 211));//30-240
    return trailer.toString();
  }

}