import java.util.Scanner;

public class MainFilaSimples {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o tamanho inicial da fila: ");
        int tamanho = scanner.nextInt();
        FilaSimples fila = new FilaSimples(tamanho);

        int opcao;

        do {
            System.out.println("\n==== MENU FILA SIMPLES ====");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Inserir elemento em índice");
            System.out.println("3. Inserir sequência de elementos");
            System.out.println("4. Remover elemento");
            System.out.println("5. Remover por índice");
            System.out.println("6. Remover sequência");
            System.out.println("7. Remover todas as ocorrências");
            System.out.println("8. Buscar elemento");
            System.out.println("9. Buscar elemento por índice");
            System.out.println("10. Ordenar crescente");
            System.out.println("11. Ordenar decrescente");
            System.out.println("12. Editar elemento");
            System.out.println("13. Obter primeiro elemento");
            System.out.println("14. Obter último elemento");
            System.out.println("15. Ver quantidade de elementos");
            System.out.println("16. Verificar se está vazia");
            System.out.println("17. Verificar se está cheia");
            System.out.println("18. Dobrar capacidade");
            System.out.println("19. Limpar fila");
            System.out.println("20. Exibir fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número: ");
                    int elem = scanner.nextInt();
                    fila.inserirElemento(elem);
                    continuar(scanner);
                    break;
                case 2:
                    System.out.print("Digite o número: ");
                    int valor = scanner.nextInt();
                    System.out.print("Digite o índice: ");
                    int idx = scanner.nextInt();
                    fila.inserirElementoIndice(valor, idx);
                    continuar(scanner);
                    break;
                case 3:
                    System.out.print("Quantos elementos deseja inserir? ");
                    int qtd = scanner.nextInt();
                    Integer[] listaInserir = new Integer[qtd];
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        listaInserir[i] = scanner.nextInt();
                    }
                    fila.inserirSequencia(listaInserir);
                    continuar(scanner);
                    break;
                case 4:
                    fila.removerElemento();
                    continuar(scanner);
                    break;
                case 5:
                    System.out.print("Digite o índice a remover: ");
                    int ri = scanner.nextInt();
                    fila.removerIndice(ri);
                    continuar(scanner);
                    break;
                case 6:
                    System.out.print("Quantos elementos deseja remover? ");
                    int qr = scanner.nextInt();
                    Integer[] listaRemover = new Integer[qr];
                    for (int i = 0; i < qr; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        listaRemover[i] = scanner.nextInt();
                    }
                    fila.removerSequencia(listaRemover);
                    continuar(scanner);
                    break;
                case 7:
                    System.out.print("Elemento a remover (todas as ocorrências): ");
                    int del = scanner.nextInt();
                    fila.removerTodasOcorrencias(del);
                    continuar(scanner);
                    break;
                case 8:
                    System.out.print("Elemento a buscar: ");
                    int buscar = scanner.nextInt();
                    fila.buscarElemento(buscar);
                    continuar(scanner);
                    break;
                case 9:
                    System.out.print("Índice a buscar: ");
                    int bi = scanner.nextInt();
                    Object result = fila.buscarElementoIndice(bi);
                    System.out.println("Resultado: " + result);
                    continuar(scanner);
                    break;
                case 10:
                    fila.ordenarCrescente();
                    continuar(scanner);
                    break;
                case 11:
                    fila.ordenarDecrescente();
                    continuar(scanner);
                    break;
                case 12:
                    System.out.print("Elemento antigo: ");
                    int antigo = scanner.nextInt();
                    System.out.print("Elemento novo: ");
                    int novo = scanner.nextInt();
                    fila.editarElemento(antigo, novo);
                    continuar(scanner);
                    break;
                case 13:
                    System.out.println("Primeiro elemento: " + fila.obterPrimeiroElemento());
                    continuar(scanner);
                    break;
                case 14:
                    System.out.println("Último elemento: " + fila.obterUltimoElemento());
                    continuar(scanner);
                    break;
                case 15:
                    System.out.println("Quantidade de elementos: " + fila.quantidadeElementos());
                    continuar(scanner);
                    break;
                case 16:
                    if (fila.estaVazia()){
                        System.out.println("A fila está vazia!");
                    } else {
                        System.out.println("A fila possui elementos!");
                    }
                    continuar(scanner);
                    break;
                case 17:
                    if (fila.estaCheia()){
                        System.out.println("A fila está cheia!");
                    } else {
                        System.out.println("A fila ainda não está cheia");
                    }
                    continuar(scanner);
                    break;
                case 18:
                    fila.dobrarCapacidade();
                    continuar(scanner);
                    break;
                case 19:
                    fila.limpar();
                    continuar(scanner);
                    break;
                case 20:
                    fila.exibir();
                    continuar(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando...");

                    break;
                default:
                    System.out.println("Opção inválida!");
                    continuar(scanner);
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void continuar(Scanner scanner) {

        System.out.println("Aperte ENTER para continuar!");

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        scanner.nextLine();
    }



}
