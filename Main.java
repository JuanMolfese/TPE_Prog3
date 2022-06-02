package TPE;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Catalogo cat = new Catalogo();
        String genero_Buscar= JOptionPane.showInputDialog("Ingresa GENERO de los libros a buscar");
        cat.getLibrosGeneros(genero_Buscar);
        JOptionPane.showMessageDialog(null, "Listo, anda a dormir !");
    }
}
