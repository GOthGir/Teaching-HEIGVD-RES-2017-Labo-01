package ch.heigvd.res.lab01.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
     String[] out = {"", lines};
     char separator = 0;

     // We check each character and check if it's an end of line.
     for (int i = 0; i < lines.length(); i++) {
        char actualChar = lines.charAt(i);
        if (actualChar == '\n') {
           separator = '\n';
           break;
        } else if (actualChar == '\r') {
           separator = '\r';
           // If the end of line isn't \r\n, we end the loop.
           if (i + 1 < lines.length() && lines.charAt(i + 1) != '\n') {
              break;
           }
         }
     }

     // We get the position of the end of line character we found.
     int separatorPos = lines.indexOf(separator);

     // If it was an end of line character, we cut the string in the two parts.
     if (separatorPos >= 0) {
        out[0] = lines.substring(0, separatorPos + 1);
        out[1] = lines.substring(separatorPos + 1);
     }

     return out;
  }

}
