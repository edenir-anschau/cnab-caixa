package net.anschau.cnab.caixa.cnab240;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
class HeaderArquivo {

  private final Beneficiario beneficiario;
  private final int nsa;
  private final LocalDateTime dataHoraGeracao;
  
  public HeaderArquivo(Beneficiario beneficiario, int nsa) {
    this.beneficiario = beneficiario;
    this.nsa = nsa;
    this.dataHoraGeracao = LocalDateTime.now();
  }  
  
  public HeaderArquivo(Beneficiario beneficiario, int nsa, 
                       LocalDateTime dataHoraGeracao) {
    this.beneficiario = beneficiario;
    this.nsa = nsa;
    this.dataHoraGeracao = dataHoraGeracao;
  }

  String get() {
    StringBuilder header = new StringBuilder(240);
    header.append("104");//1-3
    header.append("0000");//4-7
    header.append("0");//8-8
    header.append(new CampoAlfaNumerico(" ", 9));//9-17
    header.append(beneficiario.tipoInscricao()); //18-18
    header.append(beneficiario.getDocumento()); //19-32
    header.append(new CampoNumerico("0", 20)); //33-52
    header.append(beneficiario.getAgencia()); //53-57
    header.append(beneficiario.getDvAgencia()); //58-58
    header.append(beneficiario.getContaCorrente()); //59-64
    header.append(new CampoNumerico("0", 8)); //65-72
    header.append(beneficiario.getNome()); //73-102
    header.append(new CampoAlfaNumerico("CAIXA ECONOMICA FEDERAL", 30)); //103-132
    header.append(new CampoAlfaNumerico(" ", 10));//133-142
    header.append('1'); //143-143
    DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
    header.append(dataHoraGeracao.format(timeStamp)); //144-157
    header.append(new CampoNumerico(nsa, 6)); //158-163
    header.append("050"); //164-166
    header.append(new CampoNumerico(0, 5)); //167-171
    header.append(new CampoAlfaNumerico(" ", 20));//172-191
    header.append(new CampoAlfaNumerico("REMESSA-PRODUCAO", 20));//192-211
    header.append(new CampoAlfaNumerico(" ", 29));//212-240
    return header.toString();
  }

}