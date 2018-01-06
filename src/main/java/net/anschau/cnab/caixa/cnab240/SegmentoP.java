package net.anschau.cnab.caixa.cnab240;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class SegmentoP {

  private final int sequencialLote;
  private final Beneficiario beneficiario;
  private final Titulo titulo;

  public SegmentoP(int sequencialLote, Beneficiario beneficiario, Titulo titulo) {
    this.sequencialLote = sequencialLote;
    this.beneficiario = beneficiario;
    this.titulo = titulo;}

  public String get() {
    StringBuilder header = new StringBuilder(240);
    header.append("104");//1-3
    //TODO numeração do lote
    header.append("0001");//4-7
    header.append("3");//8-8
    header.append(new CampoNumerico(sequencialLote, 5));//9-13
    header.append("P");//14-14
    header.append(" ");//15-15
    header.append("01");//16-17
    header.append(beneficiario.getAgencia()); //18-22
    header.append(beneficiario.getDvAgencia()); //23-23
    header.append(beneficiario.getContaCorrente()); //24-29
    header.append(new CampoNumerico("0", 10)); //30-39
    header.append("0");//40-40
    header.append("14" + titulo.getNossoNumero());//41-57
    header.append("1");//58-58
    header.append("1");//59-59
    header.append("2");//60-60
    header.append("2");//61-61
    header.append("0");//62-62
    header.append(titulo.getNumeroDocumento(11));//63-73
    header.append(new CampoAlfaNumerico(" ", 4));//74-77
    header.append(titulo.getDataVencimeto());//78-85
    header.append(titulo.getValor());//86-100
    header.append(new CampoNumerico("0", 5)); //101-105
    header.append("0"); //106-106
    header.append("19"); //107-108 - 19 - Nota de Débito
    header.append("N"); //109-109
    header.append(titulo.getDataEmissao()); //110-117
    header.append("3"); //118-118
    header.append(new CampoNumerico("0", 77)); //119-195 - não implementado
    header.append(titulo.getNumeroDocumento(25)); //196-220
    header.append("3"); //221-221
    header.append("00"); //222-223
    header.append("1"); //224-224
    header.append("005"); //225-227
    header.append("09"); //228-229
    header.append(new CampoNumerico("0", 10)); //230-239
    header.append(" "); //240
    return header.toString();
  }

}