package TPE;

import java.util.ArrayList;

public class Libro {

    private String titulo;
    private String autor;
    private int paginas;
    private ArrayList<String> generos;

    public Libro(String t, String a, int p){
        this.titulo = t;
        this.autor = a;
        this.paginas = p;
        this.generos = new ArrayList<>();
    }

    public void add(String g){
        generos.add(g);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}
