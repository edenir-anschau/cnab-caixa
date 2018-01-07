package net.anschau.cnab.caixa.cnab240;

import java.time.LocalDate;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class HeaderLote {

  private final Beneficiario beneficiario;
  private final int numeroRemessa;
  private final LocalDate dataGravacao;

  public HeaderLote(Beneficiario beneficiario, int numeroRemessa) {
    this.beneficiario = beneficiario;
    this.numeroRemessa = numeroRemessa;
    this.dataGravacao = LocalDate.now();
  }

  public HeaderLote(Beneficiario beneficiario, int numeroRemessa, 
                    LocalDate dataGravacao) {
    this.beneficiario = beneficiario;
    this.numeroRemessa = numeroRemessa;
    this.dataGravacao = dataGravacao;
  }
  
  public String get() {
    StringBuilder header = new StringBuilder(240);
    header.append("104");//1-3
    header.append("0001");//4-7
    header.append("1");//8-8
    header.append("R");//9-9
    header.append("01");//10-10
    header.append("00"); //12-13
    header.append("030"); //14-16
    header.append(" "); //17-17
    header.append(beneficiario.tipoInscricao()); //18-18
    header.append("0" + beneficiario.getDocumento()); //19-33
    header.append(beneficiario.getContaCorrente()); //34-39
    header.append(new CampoNumerico("0", 14)); //40-53
    header.append(beneficiario.getAgencia()); //54-58
    header.append(beneficiario.getDvAgencia()); //59-59
    header.append(beneficiario.getContaCorrente()); //60-65
    header.append(new CampoNumerico("0", 7)); //66-72
    header.append("0"); //73-73
    header.append(beneficiario.getNome()); //73-103
    header.append(new CampoAlfaNumerico(" ", 80));//104-183
    header.append(new CampoNumerico(numeroRemessa, 8)); //184-191
    header.append(dataGravacao.format(MoreDateTimeFormatter.DIA_MES_ANO));//192-199
    header.append(new CampoNumerico("0", 8)); //200-207
    header.append(new CampoAlfaNumerico(" ", 33)); //208-240
    return header.toString();
  }

}