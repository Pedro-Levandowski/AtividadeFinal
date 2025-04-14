public class FilaSimples implements IEstruturaSimples {
    private int tamanho;
    private Integer[] fila;
    private int posicaoDisponivel;

    public FilaSimples(int tamanhoDaFila) {
        this.tamanho = tamanhoDaFila;
        this.fila = new Integer[tamanhoDaFila];
        this.posicaoDisponivel = 0;
    }

    public void inserirElemento(Object elemento) { //
        if (estaVazia()) {
            this.fila[0] = (Integer)elemento;
            this.posicaoDisponivel++;
            System.out.println("Elemento (" + elemento + ") inserido com sucesso!");
        } else {
            if (estaCheia()) {
                System.out.println("Não é possível adicionar mais elementos. A fila está cheia!");
            } else {
                this.fila[this.posicaoDisponivel] = (Integer) elemento;
                this.posicaoDisponivel++;
                System.out.println("Elemento (" + elemento + ") inserido com sucesso!");
            }
        }
    }

    public void inserirElementoIndice(Object elemento, int indice) {
        System.out.println("Atenção: inserirElementoIndice viola o princípio FIFO e foi implementado por exigência da interface.");
        if (indice < 0 || indice > posicaoDisponivel || estaCheia()) {
            System.out.println("Índice inválido ou fila cheia.");
            return;
        }

        for (int i = posicaoDisponivel; i > indice; i--) {
            fila[i] = fila[i - 1];
        }
        fila[indice] = (Integer) elemento;
        System.out.println("Elemento (" + elemento + ") inserido com sucesso no índice " + indice + "!");
        posicaoDisponivel++;
    }



    public void inserirSequencia(Object elementos) {
        Integer[] lista = (Integer[]) elementos;
        for (int i = 0; i < lista.length; i++) {
            if (estaCheia()) {
                System.out.println("A fila está cheia! Não é possível adicionar o elemento: " + lista[i]);
                return;
            }
            this.fila[this.posicaoDisponivel] = lista[i];
            this.posicaoDisponivel++;
            System.out.println("Elemento (" + lista[i] + ") inserido com sucesso!");
        }
    }

    public boolean removerElemento(){ //
        if (estaVazia()) {
            System.out.println("Não existem elementos na fila para remoção.");
            return false;
        } else {
            for (int i = 0; i < this.tamanho - 1; i++) {
                this.fila[i] = this.fila[i + 1];
            }
            this.fila[tamanho - 1] = null;
            this.posicaoDisponivel--;
            System.out.println("O primeiro elemento foi removido com sucesso.");
            return true;
        }
    }

    public Object removerIndice(int indice) {
        System.out.println("Atenção: remover um elemento por indice viola o princípio FIFO e foi implementado por exigência da interface.");
        if (indice < 0 || indice >= posicaoDisponivel) {
            System.out.println("Índice inválido.");
            return null;
        }
        Integer removido = fila[indice];
        for (int i = indice; i < posicaoDisponivel - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[posicaoDisponivel - 1] = null;
        System.out.println("Elemento (" + removido + ") removido com sucesso do índice " + indice + "!");
        posicaoDisponivel--;
        return removido;
    }


    public void removerSequencia(Object elementos) {
        System.out.println("Aviso: Remover uma sequência viola o princípio FIFO. Método implementado por exigência da interface.");
        Integer[] lista = (Integer[]) elementos;
            for (int i = 0; i < lista.length; i++) {
            if (this.posicaoDisponivel == 0 || !lista[i].equals(this.fila[0])) {
                System.out.println("Sequência não encontrada na ordem esperada. Nenhum elemento foi removido.");
                return; }
            for (int j = 0; j < this.posicaoDisponivel - 1; j++) {
                this.fila[j] = this.fila[j + 1];}
            this.fila[this.posicaoDisponivel - 1] = null;
            this.posicaoDisponivel--;
            System.out.println("Elemento (" + lista[i] + ") removido com sucesso.");

        }
    }
    
    public void removerTodasOcorrencias(Object elemento) {
        System.out.println("Atenção: Remover todas ocorrencias viola o princípio FIFO e foi implementado por exigência da interface.");
        int removidos = 0;
        for (int i = 0; i < this.posicaoDisponivel; i++) {
            if (this.fila[i] != null && this.fila[i].equals(elemento)) {
                for (int j = i; j < this.posicaoDisponivel - 1; j++) {
                    this.fila[j] = this.fila[j + 1];
                }
                this.fila[this.posicaoDisponivel - 1] = null;
                this.posicaoDisponivel--;
                removidos++;
                i--;
            }
        }
        if (removidos > 0) {
            System.out.println("Foram removidas " + removidos + " ocorrência(s) do elemento " + elemento + ".");
        } else {
            System.out.println("Nenhuma ocorrência do elemento " + elemento + " foi encontrada na fila.");
        }
    }




    public boolean estaCheia() { //
        if(this.fila[this.tamanho-1] != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estaVazia() { //
        if(this.fila[0] == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean buscarElemento(Object elemento) {
        System.out.println("Buscando elemento: " + elemento);
        for (int i = 0; i < this.tamanho; i++) {
            if (this.fila[i] != null && this.fila[i].equals(elemento)) {
                System.out.println("O elemento " + elemento + " existe na fila, na posição " + (i + 1));
                return true;
            }
        }
        System.out.println("O elemento " + elemento + " não foi encontrado na fila.");
        return false;
    }

    public Object buscarElementoIndice(int indice) {
        System.out.println("Buscando elemento no índice: " + indice);
        if (indice < 0 || indice >= this.posicaoDisponivel) {
            System.out.println("Índice inválido.");
            return null;
        }
        System.out.println("Elemento encontrado: " + this.fila[indice]);
        return this.fila[indice];
    }


    public void ordenarCrescente() {
        System.out.println("Aviso: Ordenar a fila em ordem crescente viola o princípio FIFO.");
        Integer aux;
        for (int i = 0; i < this.posicaoDisponivel - 1; i++) {
            for (int j = 0; j < this.posicaoDisponivel - 1 - i; j++) {
                if (this.fila[j] != null && this.fila[j + 1] != null && this.fila[j] > this.fila[j + 1]) {
                    aux = this.fila[j];
                    this.fila[j] = this.fila[j + 1];
                    this.fila[j + 1] = aux;
                }
            }
        }
        System.out.println("Fila ordenada em ordem crescente.");
    }


    public void ordenarDecrescente() {
        System.out.println("Atenção: Ordenar a fila em ordem decrescente viola o princípio FIFO.");
        Integer aux;
        for (int i = 0; i < this.posicaoDisponivel - 1; i++) {
            for (int j = 0; j < this.posicaoDisponivel - 1 - i; j++) {
                if (this.fila[j] < this.fila[j + 1]) {
                    aux = this.fila[j];
                    this.fila[j] = this.fila[j + 1];
                    this.fila[j + 1] = aux;
                }
            }
        }
        System.out.println("Fila ordenada em ordem decrescente.");
    }



    public int quantidadeElementos() {
        int cont = 0;
        if (estaVazia()) {
            System.out.println("A fila está vazia. Quantidade de elementos: 0");
            return cont;
        } else {
            for (int i = 0; i < tamanho; i++) {
                if (this.fila[i] != null) {
                    cont++;
                } else {
                    break;
                }
            }
            System.out.println("Quantidade de elementos na fila: " + cont);
            return cont;
        }
    }

    public void dobrarCapacidade() {
        Integer[] novaFila = new Integer[this.tamanho * 2];
        for (int i = 0; i < this.tamanho; i++) {
            novaFila[i] = this.fila[i];
        }
        this.fila = novaFila;
        this.tamanho *= 2;
        System.out.println("Capacidade da fila dobrada para " + this.tamanho);
    }


    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        System.out.println("Aviso: Editar um elemento viola o princípio FIFO. Método implementado por exigência da interface.");
        for (int i = 0; i < this.posicaoDisponivel; i++) {
            if (this.fila[i] != null && this.fila[i].equals(elementoAntigo)) {
                this.fila[i] = (Integer) elementoNovo;
                break;
            }
        }
    }


    public void limpar() { //
        for (int i = 0; i < this.tamanho; i++) {
            this.fila[i] = null;
        }
        this.posicaoDisponivel = 0;
        System.out.println("Fila limpa com sucesso.");
    }


    public void exibir() { //
        System.out.println("Elementos na fila: ");
        for (int i = 0; i < this.tamanho; i++) {
            if (this.fila[i] != null) {
                System.out.println("Posição " + (i+1) + ": " + this.fila[i]);
            }
        }
    }

    public Object obterPrimeiroElemento() {
        System.out.println("Obtendo o primeiro elemento da fila...");
        if (!estaVazia()) {
            System.out.println("Primeiro elemento: " + this.fila[0]);
            return this.fila[0];
        }
        System.out.println("Erro: A fila está vazia!");
        return "Erro: A fila está vazia!";
    }

    public Object obterUltimoElemento() {
        System.out.println("Obtendo o último elemento da fila...");
        if (!estaVazia()) {
            System.out.println("Último elemento: " + this.fila[this.posicaoDisponivel - 1]);
            return this.fila[this.posicaoDisponivel - 1];
        }
        System.out.println("Erro: A fila está vazia!");
        return "Erro: A fila está vazia!";
    }
}
