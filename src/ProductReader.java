import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args){
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Product>products = new ArrayList<>();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                System.out.printf("%-20s","ID#");
                System.out.printf("%-25s","Name");
                System.out.printf("%-35s","Description");
                System.out.printf("%-20s","Cost");
                System.out.println();
                for (int i = 0; i < 100; i++){
                    System.out.print("=");
                }
                System.out.println();
                String[] arrOfRec;
                while(reader.ready())
                {
                    rec = reader.readLine();
                    arrOfRec = rec.split(", ");
                    Product p = new Product(arrOfRec[0], arrOfRec[1], arrOfRec[2], Double.parseDouble(arrOfRec[3]));
                    products.add(p);
                    System.out.printf("%-20s", p.getID());
                    System.out.printf("%-25s", p.getName());
                    System.out.printf("%-35s", p.getDescription());
                    System.out.printf("%-20s", p.getCost());
                    System.out.println();
                }
                reader.close();
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}