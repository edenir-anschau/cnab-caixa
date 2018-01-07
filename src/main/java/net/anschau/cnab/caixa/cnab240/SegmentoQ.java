package net.anschau.cnab.caixa.cnab240;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class SegmentoQ {

  private final int sequencialLote;
  private final Pagador pagador;

  public SegmentoQ(int sequencialLote, Pagador pagador) {
    this.sequencialLote = sequencialLote;
    this.pagador = pagador;
  }

  public String get() {
    StringBuilder header = new StringBuilder(240);
    header.append("104");//1-3
    //TODO numeração do lote
    header.append("0001");//4-7
    header.append("3");//8-8
    header.append(new CampoNumerico(sequencialLote, 5));//9-13
    header.append("Q");//14-14
    header.append(" ");//15-15
    header.append("01");//16-17
    header.append(pagador.tipoInscricao());//18-18
    header.append(pagador.getDocumento());//19-33
    header.append(pagador.getNome());//34-74
    header.append(pagador.getEndereco());//74-113
    header.append(pagador.getBairro());//114-128
    header.append(pagador.getCEP());//129-136
    header.append(pagador.getCidade());//137-151
    header.append(pagador.getUF());//152-153
    header.append(new CampoNumerico(0, 16));//154-169
    header.append(new CampoAlfaNumerico(" ", 40));//170-209
    header.append(new CampoAlfaNumerico(" ", 3));//210-212
    header.append(new CampoAlfaNumerico(" ", 28));//170-209
    return header.toString();
  }

}