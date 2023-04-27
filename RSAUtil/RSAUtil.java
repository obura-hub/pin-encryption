package RSAUtil.RSAUtil;

import org.springframework.stereotype.Component;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;

@Component
public class RSAUtil {

	protected static String DEFAULT_ENCRYPTION_ALGORITHM = "RSA";
	protected static String DEFAULT_TRANSFORMATION = "RSA/ECB/PKCS1Padding";

	public static PublicKey getPublicKey(String base64PublicKey) {
		PublicKey publicKey = null;
		try {
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(base64PublicKey.getBytes()));
			KeyFactory keyFactory = KeyFactory.getInstance(DEFAULT_ENCRYPTION_ALGORITHM);
			publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		System.out.printf("###################### key public ######### : "+publicKey);
		return publicKey;
	}

	public static String encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException,
			InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
		Cipher cipher = Cipher.getInstance(DEFAULT_TRANSFORMATION);
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
		String encKEY = Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
		System.out.printf("###################### key encoded ######### : "+encKEY);
		return encKEY;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, NoSuchPaddingException {
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCkq3XbDI1s8Lu7SpUBP+bqOs/MC6PKWz6n/0UkqTiOZqKqaoZClI3BUDTrSIJsrN1Qx7ivBzsaAYfsB0CygSSWay4iyUcnMVEDrNVOJwtWvHxpyWJC5RfKBrweW9b8klFa/CfKRtkK730apy0Kxjg+7fF0tB4O3Ic9Gxuv4pFkbQIDAQAB"; // public
																																																														// key
																																																														// provided
																																																														// to
																																																														// encrypt
																																																														// data
		String encryptData = RSAUtil.encrypt("3321", publicKey);
		System.out.println("Encrypted String-:" + encryptData);
	}
}