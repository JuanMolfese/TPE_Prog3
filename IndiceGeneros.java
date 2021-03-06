package TPE;

import java.util.ArrayList;

public class IndiceGeneros {
    private NodeGen root;
    private int iteracionesGenero;

    public IndiceGeneros(){
        root = null;
    }

    public void add(String genero, Libro l){
        if (this.root == null) {
            this.root = new NodeGen(genero);
            this.root.addLibro(l);
        }else
            this.add(this.root, genero, l);
    }

    private void add(NodeGen actual, String genero, Libro l) {

        if(actual.getGenero().compareTo(genero) == 0){
            actual.addLibro(l);
        }
        else if (actual.getGenero().compareTo(genero) > 0) {
            if (actual.getLeft() == null) {
                NodeGen temp = new NodeGen(genero);
                temp.addLibro(l);
                actual.setLeft(temp);

            } else {
                add(actual.getLeft(), genero, l);
            }
        } else if (actual.getGenero().compareTo(genero) < 0) {
            if (actual.getRight() == null) {
                NodeGen temp = new NodeGen(genero);
                temp.addLibro(l);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), genero, l);
            }
        }
    }

    public ArrayList<Libro> getLibros(String g){
        this.iteracionesGenero = 0;
        if (this.root == null)
            return new ArrayList<>();
        else
            return this.getLibros(this.root, g);
    }

    private ArrayList<Libro> getLibros(NodeGen actual, String g) {
        this.iteracionesGenero++;
        if (actual.getGenero().compareTo(g) == 0) {
            return actual.getLibros();
        } else if ((actual.getGenero().compareTo(g) > 0) && (actual.getLeft() != null)) {
            return getLibros(actual.getLeft(), g);
        } else if ((actual.getGenero().compareTo(g) < 0) && (actual.getRight() != null)) {
            return getLibros(actual.getRight(), g);
        }
        return new ArrayList<Libro>();
    }


    public int getIteracionesGenero(){
        return iteracionesGenero;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
