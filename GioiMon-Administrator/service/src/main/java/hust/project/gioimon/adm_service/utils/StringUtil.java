package hust.project.gioimon.adm_service.utils;

import java.security.MessageDigest;

public class StringUtil {
    public static String Hash(String src){
        //TODO WRITE CUSTOM Encrypt here, using Hash 10times, add salt, peper!
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(src.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
    public static String generateToken(){
        return "token";
    }
}
