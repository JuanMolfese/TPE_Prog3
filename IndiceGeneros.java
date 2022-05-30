package TPE;

public class IndiceGeneros {
    private NodeGen root;

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
        if (actual.getGenero().compareTo(genero) > 0) {
            if (actual.getLeft() == null) {
                NodeGen temp = new NodeGen(genero);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), genero, l);
            }
        } else if (actual.getGenero().compareTo(genero) < 0) {
            if (actual.getRight() == null) {
                NodeGen temp = new NodeGen(genero);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), genero, l);
            }
        } else actual.addLibro(l);
    }



    @Override
    public String toString() {
        return root.toString();
    }
}
