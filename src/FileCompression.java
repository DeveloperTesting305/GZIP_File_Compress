import javax.swing.*;
import java.io.*;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileCompression {
    private JPanel panel;

    public static void main(String[] args) {
        try {

            /*
            // SINGLE FILE ZIP
            String sourceStr = "D:\\Backup\\data.sql";
            String destinetionStr = "D:\\Backup\\testData.zip";

            FileInputStream inputStream = new FileInputStream(sourceStr);

            FileOutputStream outputStream = new FileOutputStream(destinetionStr);
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);


            byte[] buffer = new byte[1024];

            int readBytes;
            while ((readBytes = inputStream.read(buffer)) > 0){
                gzipOutputStream.write(buffer, 0, readBytes);
                System.out.println("R");
            }

            gzipOutputStream.finish();
            gzipOutputStream.close();

            inputStream.close();
            outputStream.close();

             */


            Frame frame = new Frame();
            frame.setVisible(true);

        }catch (Exception ee){
            ee.printStackTrace();
        }

    }

}
