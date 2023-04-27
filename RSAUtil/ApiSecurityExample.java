//package RSAUtil.RSAUtil;
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import org.apache.commons.codec.binary.Base64;
//
//public class ApiSecurityExample {
//  public static void main(String[] args) {
//    try {
//     String secret = "zITVAAGYSlzl1WkUQJn81kbpT5drH3koffT8jCkcJJA="; //"a4f48f692d2b4df9acbad7dff60a32a6";
////     String message = "";
//     String message = "{"transaction":{"id":"BBZMiscxy","message":"Paid KSH 5,000 to TECH LIMITED, 
//    		 Trans ID MP210603.1234.L06941.","status_code":"TS","airtel_money_id":"MP210603.1234.L06941"}}";
//
//      Mac mac = Mac.getInstance("HmacSHA256");
//      SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
//      mac.init(secretKey);
//      
//      encryptedValue = Base64.encodeBase64String(mac.doFinal(message.getBytes()));
//     System.out.println(hash);
//    }
//    catch (Exception e){
//     System.out.println("Error");
//    }
//   }
//}