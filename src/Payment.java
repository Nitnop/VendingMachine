import java.security.NoSuchAlgorithmException;

public class Payment {

    
    
    public static void Start(){

        String creditCardInfo = "1234567890123456";
        System.out.println("Swipe card to rent movie for $5");

        try {
            byte[] cryptoInfo = CreditCardEncryptor.encryptData(creditCardInfo.getBytes(), CreditCardEncryptor.secretKey());
            SecureDataSender.sendIt(cryptoInfo); // this should send the encrypted byte array to the target, in this case, google
        }
        catch (NoSuchAlgorithmException e) {
            
            e.printStackTrace();
        } 
        catch (Exception e) {
            
            e.printStackTrace();
        }

        User.Start();
    } 

        
    
}
