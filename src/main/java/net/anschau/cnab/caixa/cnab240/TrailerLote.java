package net.anschau.cnab.caixa.cnab240;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class TrailerLote {

  private final int quantidadeRegistros;

  public TrailerLote(int quantidadeRegistros) {
    this.quantidadeRegistros = quantidadeRegistros;
  }

  public String get() {
    StringBuilder trailer = new StringBuilder(240);
    trailer.append("104");//1-3
    //TODO numeração do lote
    trailer.append("0001");//4-7
    trailer.append("5");//8-8
    trailer.append(new CampoAlfaNumerico(" ", 9));//9-17
    trailer.append(new CampoNumerico(quantidadeRegistros, 6));//18-23
    trailer.append(new CampoNumerico(0, 69));//24-92
    trailer.append(new CampoAlfaNumerico(" ", 148));//93-240
    return trailer.toString();
  }

}