package AESsecurity;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class EnkripsiAES {
  private static String key = "EraBangun";
  
  private static String initVector = "EramedClara";
  
  public static String decrypt(String encrypted) {
    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(2, skeySpec, iv);
      byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
      return new String(original);
    } catch (Exception ex) {
      System.out.println("Dekripsi selesai.");
      return null;
    } 
  }
  
  public static String encrypt(String value) {
    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(1, skeySpec, iv);
      byte[] encrypted = cipher.doFinal(value.getBytes());
      return Base64.encodeBase64String(encrypted);
    } catch (Exception ex) {
      System.out.println("Enkripsi selesai.");
      return null;
    } 
  }
}