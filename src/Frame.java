import javax.swing.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Frame extends JFrame{

    private JPanel panel;
    private JButton ZIPFileButton;
    private JButton UNZIPFileButton;

    public Frame() {

        ///**** INIT GUI ****///
        createUIComponents();

        ZIPFileButton.addActionListener(actionEvent -> {
            try{
                // MULTIPLE FILE ZIP

                File sourceFolder = selectFile("Select Folder", true);
                File filesObj = new File(sourceFolder.getParent());
                String[] files = filesObj.list();

                File destnationFile = selectFile("Select Save Path", false);
                String destinetionStr = destnationFile.getParent()+"/"+destnationFile.getName()+".zip";


                FileOutputStream fos = null;
                ZipOutputStream zipOut = null;
                FileInputStream fis = null;

                fos = new FileOutputStream(destinetionStr);
                zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
                for(String filePath:files){
                    File input = new File(filesObj.getAbsolutePath()+"/"+filePath);
                    fis = new FileInputStream(input);
                    ZipEntry ze = new ZipEntry(input.getName());
                    System.out.println("Zipping the file: "+input.getName());
                    zipOut.putNextEntry(ze);
                    byte[] tmp = new byte[4*1024];
                    int size = 0;
                    while((size = fis.read(tmp)) != -1){
                        zipOut.write(tmp, 0, size);
                    }
                    zipOut.flush();
                    fis.close();
                }
                zipOut.close();
                System.out.println("Done... Zipped the files...");

            }catch (Exception ee){
                ee.printStackTrace();
            }
        });
    }

    private File selectFile(String title, boolean isOpen)throws Exception{
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(title);
        chooser.setName("untitle");
        int code;
        if(isOpen) code = chooser.showOpenDialog(this);
        else code = chooser.showSaveDialog(this);


        if(code == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile();
        }

        return null;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}
