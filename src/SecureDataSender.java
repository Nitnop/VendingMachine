import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.URL;

public class SecureDataSender {

    public static void sendIt(byte[] getEncryptedData) {
        try {
            // Assume you have encrypted data
            byte[] encryptedData = getEncryptedData;

            // Specify the URL to which you want to send the data
            URL url = new URL("https://google.com");

            // Open a connection to the URL
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            System.out.println("Connecting to " + url);

            // Set up the connection
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Write the encrypted data to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                os.write(encryptedData);
                System.out.println("Sending " + encryptedData.length +" bytes");
            }

            // Check the response code to see if the request was successful
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            System.out.println("Payment sucsessfull\n\n");
            User.lowerquantity(responseCode);


            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
