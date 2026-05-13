import java.util.Scanner;
import java.util.ArrayList;

// CLASSE PARTICIPANTE
class Participante {

    // VARIAVEIS DOS PARTICIPANTES
    String nome;
    int idade;
    String email;

    Participante(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    void mostrar() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Email: " + email);
    }
}

public class TrabalhoComplementar {
    public static void main(String[] args) {

        ArrayList<Participante> lista = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        int opcao;

        do {
             // MENU DE EXIBIÇÂO
            System.out.println("\n--- SISTEMA DE GESTÃO DE PARTICIPANTES ---");
            System.out.println("1- Cadastrar Participante");
            System.out.println("2- Listar Participantes");
            System.out.println("3- Buscar Participante");
            System.out.println("4- Remover Participante");
            System.out.println("5- Exibir Estatísticas");
            System.out.println("6- Sair do Sistema");
            System.out.print("Digite Sua Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    // CADASTRO DE PARTICIPANTE
                    System.out.println("\n== CADASTRO DE PARTICIPANTE ==");
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();
                    System.out.print("Idade: ");
                    int idade = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Email: ");
                    String email = entrada.nextLine();
                    boolean existe = false;
                    for (Participante p : lista) {
                        if (p.nome.equalsIgnoreCase(nome)) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("Participante já cadastrado!");
                    } else {
                        lista.add(new Participante(nome, idade, email));
                        System.out.println("Cadastrado com Sucesso!");
                    }
                    break;

                case 2:
                    // LISTA DE PARTICIPANTE
                    System.out.println("\n== LISTA DE PARTICIPANTES ==");
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum Participante.");
                    } else {
                        for (Participante p : lista) {
                            p.mostrar();
                            System.out.println("------------------");
                        }
                    }
                    break;

                case 3:
                    // BUSCA DE PARTICIPANTE
                    System.out.println("\n== BUSCAR PARTICIPANTES ==");
                    System.out.print("Nome: ");
                    String busca = entrada.nextLine();
                    boolean encontrado = false;
                    for (Participante p : lista) {
                        if (p.nome.equalsIgnoreCase(busca)) {
                            p.mostrar();
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Não encontrado.");
                    }
                    break;

                case 4:
                    // REMOVER PARTICIPANTE
                    System.out.println("\n== REMOVER PARTICIPANTES ==");
                    System.out.print("Nome: ");
                    String remover = entrada.nextLine();
                    boolean removido = false;
                    for (Participante p : lista) {
                        if (p.nome.equalsIgnoreCase(remover)) {
                            lista.remove(p);
                            removido = true;
                            break;
                        }
                    }

                    if (removido) {
                        System.out.println("Removido com sucesso!");
                    } else {
                        System.out.println("Não encontrado.");
                    }
                    break;

                case 5:
                    // ESTATISTICAS DOS PARTICIPANTES
                    System.out.println("\n== ESTATÍSTICAS DOS PARTICIPANTES ==");
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum Participante Cadastrado.");
                        break;
                    }
                    int total = lista.size();
                    int somaIdade = 0;
                    for (Participante p : lista) {
                        somaIdade += p.idade;
                    }

                    double media = (double) somaIdade / total;
                    System.out.println("Total: " + total);
                    System.out.println("Média de Idade: " + media);
                    System.out.println("\nClassificação:");
                    for (Participante p : lista) {
                        String classificacao;

                        if (p.idade <= 17) {
                            classificacao = "Jovem";
                        } else if (p.idade <= 59) {
                            classificacao = "Adulto";
                        } else {
                            classificacao = "Idoso";
                        }

                        System.out.println(p.nome + " - " + classificacao);
                    }
                    break;
                case 6:
                    // SAIDA DO SISTEMA
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcao != 6);

        entrada.close();
    }
}