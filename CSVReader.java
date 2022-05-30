package TPE;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "dataset/dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";
        String catSplitBy = " ";
        IndiceGeneros generos = new IndiceGeneros();
        ArrayList<Libro>libros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                String[] generos_libro = items[3].split(catSplitBy);

                    Libro l =new Libro(items[0],items[1],Integer.parseInt(items[2]));
                    libros.add(l);

                    for(int i=0; i< generos_libro.length;i++){
                        generos.add(generos_libro[i], l);
                        l.add(generos_libro[i]);
                    }
            }
           // System.out.println(generos);
          //  System.out.println("Ingrese genero a buscar libros: ");
          //  BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

            String genero_Buscar= JOptionPane.showInputDialog("Ingresa GENERO de los libros a buscar");
            JOptionPane.showMessageDialog(null, "Gracias Fede, eres un crack !, buscamos genero : " + genero_Buscar);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}