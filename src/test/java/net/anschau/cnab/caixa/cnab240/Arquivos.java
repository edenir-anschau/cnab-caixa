package net.anschau.cnab.caixa.cnab240;

import java.io.File;
import java.io.IOException;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * @author Edenir Norberto Anschau (edenir.ans@gmail.com)
 */
public class Arquivos {

  public static final String SEGMENTO_P = readFile("segmento_p.txt");
  public static final String SEGMENTO_Q = readFile("segmento_q.txt");
  public static final String REMESSA_1_TITULO = readFile("remessa_1_titulo.txt");
  public static final String REMESSA_3_TITULOS = readFile("remessa_3_titulos.txt");
 
  private static String readFile(String file) {
    try {
      return Files.asCharSource(new File("src/test/resources/"+ file), Charsets.US_ASCII).read();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }
  
}