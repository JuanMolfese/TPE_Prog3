package TPE;

import java.util.ArrayList;

public class NodeGen {
    private String genero;
    private ArrayList<Libro> libros;
    private NodeGen izq;
    private NodeGen der;

    public NodeGen(String g){
        this.genero = g;
        this.libros = new ArrayList<Libro>();
        this.izq = null;
        this.der = null;
    }

    public void addLibro(Libro l){
        this.libros.add(l);
    }

    public String getGenero(){
        return this.genero;
    }

    public NodeGen getLeft() {
        return izq;
    }

    public void setLeft(NodeGen izq) {
        this.izq = izq;
    }

    public NodeGen getRight() {
        return der;
    }

    public void setRight(NodeGen der) {
        this.der = der;
    }

    public boolean esHoja(){
        return this.izq == null && this.der==null;
    }

    public boolean haveOneChild(){ return (this.izq == null && this.der !=null)
            || (this.izq != null && this.der ==null);
    }
    public void setValue(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        String s = "";
        s+=genero;
        if(der != null){
            s+=der.toString();
        }
        if(izq != null){
            s+=izq.toString();
        }
        return s;
    }
}
