package TPE;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Catalogo cat = new Catalogo();
        String genero_Buscar= JOptionPane.showInputDialog("Ingresa GENERO de los libros a buscar");
        Timer t = new Timer();
        t.start();
        cat.getLibrosGeneros(genero_Buscar);
        System.out.println(t.stop());
    }
}
