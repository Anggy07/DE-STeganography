package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.awal;
import view.view;

public class DEstego {

    private view View;
    private awal awal;
    String location;
    String gambar;
  //  imagingRGB test = null;
    int[][] matrix = null;

    public DEstego(view v) {
        this.View = v;
        View.setVisible(true);
        this.View.addHide(new hide());
    }

    public DEstego(awal v) {
        this.awal = v;
        awal.setVisible(true);
        this.awal.addUpload(new upload());
        this.awal.addNext(new Next());

    }

    private class Next implements ActionListener {

        public Next() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
          controller.DEstego c = new controller.DEstego(new view());
          c.location = location;
          c.gambar = awal.getFileHasil();
          awal.setVisible(false);
        }
    }

    private class upload implements ActionListener {

        public upload() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            JFileChooser jfc = new JFileChooser("E:\\"); //ketika membuka file maka terbuka ke lokasi D
            FileFilter filter = new FileNameExtensionFilter("JPG/ JPEG / PNG File", "JPG", "JPEG", "PNG"); //file yang terfilter pertama kali berenteksi gambar
//        jfc.addChoosableFileFilter(filter);
            jfc.setFileFilter(filter); //untuk mengeset Extension file
            jfc.showOpenDialog(null); //open browser di tampilkan
            jfc.getFileFilter(); //mendapatkan file difilter
            File file = jfc.getSelectedFile();  // mengambil file yang dipilih
            try {
                Image image = ImageIO.read(file); //read image
                ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(400, 400, 300)); //menampilkan gambar dgn ukuran 300x300x300

                awal.setImage().setIcon(imageIcon); //gambar diset ke label
                awal.setImage().setText(""); // gambar diset tanpa text
            } catch (IOException ex) {
                Logger.getLogger(DEstego.class.getName()).log(Level.SEVERE, null, ex);
            }
            String dir = file.getAbsolutePath(); //mendapatkan lokasi file
            awal.setURL(dir);//lokasi file ditampilkan dilayar 
            location = dir; //mengubah lokasi dir dimasukan kevariabel location
            System.out.println(location);

        }
    }

    private class hide implements ActionListener {

           imagingRGB test = null;
        public hide() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
//ambil gambar
            try {
                test = new imagingRGB(imagingRGB.COLOR_RED);
            System.out.println("kopok");
                matrix = test.read(location);
                System.out.println("Cover data:");
                String cover = "";
                for (int y = 0; y < matrix.length; y++) {
                    for (int x = 0; x < matrix.length; x++) {
                        cover += String.format("%3s", matrix[y][x]) + " ";
                    }
                    System.out.println(cover);
                    View.setCoverdata(cover);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }

            // Konverter ke ASCII
            System.out.println("panjang :" + matrix.length);
            String message = View.getMessage();
            char[] temp = message.toCharArray();
            message = "";
            for (char tmp : temp) {
                message += String.format("%8s", Integer.toBinaryString((int) tmp)).replace(' ', '0');
            }
            System.out.println("Secret message: " + message);
            View.setASCII(message);

            // Proses penyisipan dengan rumus
            System.out.println("Stego data: ");

            int l, h, haksen, xaksen, yaksen; // variabelnya

            for (int y = 0; y < matrix.length; y++) {
                for (int x = 0; x < matrix[y].length; x += 2) {
                    if (message.length() > 0) {
                        l = ((matrix[y][x] + matrix[y][x + 1]) / 2);
                        System.out.println("nilai l nya adalah : " + l);
                        h = matrix[y][x] - matrix[y][x + 1];
                        System.out.println("nilai h nya adalah : " + h);
                        haksen = (2 * h) + Integer.parseInt(message.substring(0, 1));
                        message = message.substring(1);
                        xaksen = (int) (l + (Math.floor((double) (haksen + 1) / 2)));
                        yaksen = (int) (l - (Math.floor((double) haksen / 2)));
                        //mengganti
                        matrix[y][x] = xaksen;
                        matrix[y][x + 1] = yaksen;
                    }

                }
            }
            // kirim ke array imagingRGB
            test.matrix = matrix;
            // cek dahulu
            for (int i = 0; i < test.matrix.length; i++) {
                System.out.println("================");
                for (int j = 0; j < test.matrix[i].length; j++) {
                    System.out.print(test.matrix[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("panjang :" + matrix.length);

            // cetak gambar
            try {
                test.write( "E:\\"+gambar+".png");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }

            // EXTRACT GAMBAR dari hasilnya
             
            try {
                test = new imagingRGB(imagingRGB.COLOR_RED);
                matrix = test.read( "E:\\"+gambar+".png");
                System.out.println("Stego data:");
                String stego = "";
                for (int y = 0; y < matrix.length; y++) {
                    for (int x = 0; x < matrix.length; x++) {
                        stego += String.format("%3s", matrix[y][x]) + " ";
                    }
                    System.out.println(stego);
                    View.setStegodata(stego);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }

            // Proses ekstraksi mencari pesan
            message = "";
            String tmp = "";
            for (int y = 0; y < matrix.length; y++) {
                for (int x = 0; x < matrix[y].length; x += 2) {
                    tmp += Math.abs((matrix[y][x] - matrix[y][x + 1]) % 2);
                    if (tmp.length() == 8) {
                        message += (char) Integer.parseInt(tmp, 2);
                        tmp = "";
                    }
                }
            }

            System.out.println("Temp =" + tmp);
            System.out.println("Secret messagenya : " + message);
            View.setSecretMessage(message);

        }
    }
}
