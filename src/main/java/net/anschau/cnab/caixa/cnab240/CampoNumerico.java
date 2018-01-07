package net.anschau.cnab.caixa.cnab240;

import com.google.common.base.Strings;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class CampoNumerico {

  private final String valor;
  private final int tamanho;

  public CampoNumerico(String valor, int tamanho) {
    this.valor = valor;
    this.tamanho = tamanho;
  }
  
  public CampoNumerico(int valor, int tamanho) {
    this.valor = String.valueOf(valor);
    this.tamanho = tamanho;
  }

  @Override
  public String toString() {
    return Strings.padStart(valor, tamanho, '0');
  }
  
}