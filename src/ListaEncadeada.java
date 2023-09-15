public class ListaEncadeada<T> {

    private No<T> refEntrada;
    public ListaEncadeada() {
        this.refEntrada = null;
    }

    public boolean isEmpty() {
        return this.refEntrada == null;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.isEmpty()) {
            this.refEntrada = novoNo;
            return;
        }
        No<T> noAux = refEntrada;
        for (int i = 0; i < this.size()-1; i++) {
            noAux = noAux.getProxNo();
        }
        noAux.setProxNo(novoNo);
    }

    private void validaIndice(int index) {
        if(index >= this.size()) {
            throw new IndexOutOfBoundsException("Indice nao existente");
        }
    }

    @Override
    public String toString() {
        String s = "";
        No<T> aux = refEntrada;
        for(int i = 0; i < this.size(); i++) {
            s += " [No{conteudo ="+aux.getConteudo() + "}] -->";
            aux = aux.getProxNo();
        }
        s += " null";
        return s;
    }

    public T remove(int index) {
        No<T> noPivo = this.getNo(index);
        if(index == 0) {
            this.refEntrada = noPivo.getProxNo();
            return noPivo.getConteudo();
        }
        No<T> noAnterior = getNo(index - 1);
        noAnterior.setProxNo(noPivo.getProxNo());
        return noPivo.getConteudo();
    }

    public T get(int index) {
        return getNo(index).getConteudo();
    }
    private No<T> getNo(int index) {
        validaIndice(index);

        No<T> aux = this.refEntrada;
        No<T> noRetorno = null;
        for(int i = 0; i < this.size()-1; i++) {
            noRetorno = aux;
            aux = aux.getProxNo();
        }
        return noRetorno;
    }


    public int size() {
        int tamLista = 0;

        No<T> refAux = this.refEntrada;
        while (true) {
            if(this.refEntrada != null) {
                tamLista += 1;
                if(this.refEntrada.getProxNo() != null) {
                    this.refEntrada = refAux.getProxNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return tamLista;
    }
}
