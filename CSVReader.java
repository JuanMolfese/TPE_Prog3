package TPE;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "/home/juanmolfese/Desarrollo/datasets/dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";
        String catSplitBy = " ";
        ArrayList<String> generos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                String[] generos_libro = items[3].split(catSplitBy);
                for(int i=1; i< generos_libro.length;i++){
                    if(! generos.contains(generos_libro[i])){
                        generos.add(generos_libro[i]);
                    }
                }
            }
            System.out.println(generos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}