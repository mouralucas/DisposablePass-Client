package disposablePasswd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Penha de Moura - 1208977
 */
public class Hash {

    public String pass2hash(String passwd) {
        String retorno = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(passwd.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuilder hash = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                hash.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            //System.out.println("Hex format : " + sb.toString());
            retorno = hash.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
}
