package TPE;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Catalogo {

    IndiceGeneros generos;

    public Catalogo(){
        this.generos = new IndiceGeneros();
    }

    public void getLibrosGeneros(String g){
        obtenerDatos();
        ArrayList<String> titulosGenero = generos.getLibros(g);

        generarSalida(titulosGenero);
    }

    private void obtenerDatos(){

        String csvFile = "dataset/dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";
        String catSplitBy = " ";
        ArrayList<Libro> libros = new ArrayList<>();

        try (
        BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

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
        } catch (
        IOException e) {
            e.printStackTrace();
        }
    }

    public void generarSalida(ArrayList<String> titulosLibros) {
        BufferedWriter bw = null;
        try {
            File file = new File("dataset/salida1.csv");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for(String s : titulosLibros){
                String contenidoLinea = s;
                bw.write(contenidoLinea);
                bw.newLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
