package net.anschau.cnab.caixa.cnab240;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
      Path workDir = Paths.get("src/test/resources/");
      byte[] bytes = Files.readAllBytes(workDir.resolve(file));
      return new String(bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }
  
}