package cn.fxbin.groovy

import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.PBEParameterSpec
import java.security.spec.AlgorithmParameterSpec
import java.security.spec.KeySpec

/**
 * Secret
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 20:50
 */
class Secret {

    private static byte[] salt = [ (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03]

    //包的加密方法，调用的时候需要传入key和明文，方法返回加密后的密文

    static String encrypt(String secretKey, String plainText) throws Exception {
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, 19)
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec)
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, 19)
        Cipher cipher = Cipher.getInstance(key.getAlgorithm())
        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec)
        String charSet = "UTF-8"
        byte[] input = plainText.getBytes(charSet)
        byte[] output = cipher.doFinal(input)
        return new String(Base64.getEncoder().encode(output))
    }

    //包的解密方法，调用的时候需要传入key和加密后的密文
    static String decrypt(String secretKey, String encryptedText) throws Exception {
        KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt, 19)
        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec)
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, 19)
        Cipher cipher = Cipher.getInstance(key.getAlgorithm())
        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec)
        byte[] enc = Base64.getDecoder().decode(encryptedText)
        byte[] utf8 = cipher.doFinal(enc)
        String charSet = "UTF-8"
        return new String(utf8, charSet)
    }

    //写了个main方法来调用上面两个方法
    static void main(String[] args) throws Exception {
        String key = "apiTestStudy"               //设置key值，这里使用的是对称加密，加密和解密时使用相同的key值即可，key具体的值自己可以任意设置
        String plain = "api"              //明文密码
        String enc = encrypt(key, plain)          //加密后的密码
        System.out.println("Original text: " + plain)
        System.out.println("Encrypted text: " + enc)
        String encs="7mmKHCEkyG8="    //加密后的密文
        String plainAfter = decrypt(key, encs)    //密文解密
        System.out.println("Original text after decryption: " + plainAfter)   //解密后的明文
    }
}
