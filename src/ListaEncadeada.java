public class ListaEncadeada<T> {

    private No<T> refEntrada;
    public ListaEncadeada() {
        this.refEntrada = null;
    }

    public boolean isEmpty() {
        return this.refEntrada == null;
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
