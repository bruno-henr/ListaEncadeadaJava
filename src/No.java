public class No<T> {
    private T conteudo;
    private No<T> proxNo;

    public No(T conteudo) {
        this.conteudo = conteudo;
        this.proxNo = null;
    }

    public No() {
        this.proxNo = null;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }

    public String toStringEncadeado() {
        String s = "No{" +
                "conteudo=" + conteudo +
                '}';
        if(this.proxNo != null) {
            s += "\n-> "+this.proxNo.toString();
        } else {
            s += "\n-> null";
        }
        return s;
    }

    public No(T conteudo, No<T> novoNo) {
        this.conteudo = conteudo;
        this.proxNo = novoNo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getProxNo() {
        return proxNo;
    }

    public void setProxNo(No<T> proxNo) {
        this.proxNo = proxNo;
    }
}
