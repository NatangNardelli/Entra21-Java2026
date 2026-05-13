import java.util.Scanner;
import java.util.ArrayList;

// ClASSE PARA PESSOA
class Pessoa {

    // VARIAVES DE CADASTRO
    String nome;
    String funcao;
    int idade;
    double salario;

    Pessoa(String nome, int idade, String funcao, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;
        this.salario = salario;

    }

    // MOSTRAR PARA BUSCA DE PESSOA
    void mostrarInfo() {
        System.out.println(
                "\nNome: " + nome + " | Idade: " + idade + " | Função: " + funcao + " | Salario: R$" + salario);
        if (salario >= 5000) {
            System.out.print("Salario é Alto");
        } else {
            System.out.print("Salario é Baixo");
        }
    }

    // MOSTRAR PARA LISTA DE PESSOAS
    void mostrar() {
        System.out.println(
                "\nPessoa: " + nome + " | Idade: " + idade + " | Função: " + funcao + " | Salario: R$" + salario);

        // IF/ELSE PARA SALARIO
        if (salario >= 5000) {
            System.out.print("Salario é Alto");
        } else {
            System.out.print("Salario é Baixo");
        }
    }
}

public class TrabalhoC {
    public static void main(String[] args) {

        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        // VARIAVEIS:

        int opcao = 0;
        String nome = "";
        int idade = 0;
        String funcao = "";
        double salario = 0;
        String busca = "";
        String remover = "";

        // CODIGO:

        do {
            // MENU INTERATIVO PARA SISTEMA
            System.out.println("\n ---SISTEMA DE CADASTRO DE PESSOAS--- ");
            System.out.println("\n1- Cadastrar pessoa.");
            System.out.println("2- Listar pessoa");
            System.out.println("3- Buscar pessoa pelo nome");
            System.out.println("4- Excluir pessoa");
            System.out.println("5- Editar Pessoa");
            System.out.println("6- Sair");
            System.out.print("Digite sua opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    // CADASTRO DE PESSOAS
                    System.out.println("\n===CADASTRO DE PESSOA=== ");
                    System.out.print("Digite o nome: ");
                    nome = entrada.nextLine();
                    System.out.print("Idade: ");
                    idade = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Função na Empresa: ");
                    funcao = entrada.nextLine();
                    System.out.print("Salario: R$");
                    salario = entrada.nextDouble();
                    // PARA CADASTRO JA REALIZADO OU NÃO
                    boolean existe = false;
                    for (Pessoa p : listaPessoas) {
                        if (p.nome.equalsIgnoreCase(nome)) {
                            existe = true;
                            break;
                        }
                    }
                    if (existe) {
                        System.out.println("Pessoa já cadastrada!");
                    } else {
                        listaPessoas.add(new Pessoa(nome, idade, funcao, salario));
                        System.out.println("Pessoa cadastrada com sucesso!");
                    }
                    break;
                case 2:
                    // LISTAS DE NOMES
                    System.out.println("\n ==LISTA DE PESSOAS==");

                    if (listaPessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    } else {
                        for (Pessoa a : listaPessoas) {
                            a.mostrar();
                            System.out.println("\n------------------------");
                        }

                    }
                    break;
                case 3:
                    // BUSCA DE PESSOAS
                    System.out.println("\n ==BUSCAR DE PESSOAS==");
                    System.out.print("Pessoa que deseja buscar: ");
                    busca = entrada.nextLine();

                    boolean buscando = false;
                    for (Pessoa b : listaPessoas) {
                        if (b.nome.equalsIgnoreCase(busca)) {
                            b.mostrarInfo();
                            buscando = true;
                        }
                    }

                    if (buscando) {
                        System.out.println("\nPessoa encontrada!");
                    } else {
                        System.out.println("\nPessoa não encontrada");
                    }
                    break;
                case 4:
                    // REMOVER PESSOAS
                    System.out.println("\n ==REMOVER PESSOAS== ");
                    System.out.print("Digite a pessoa que deseje remover: ");
                    remover = entrada.nextLine();
                    boolean removido = false;
                    for (Pessoa c : listaPessoas) {
                        if (c.nome.equalsIgnoreCase(remover)) {
                            c.mostrarInfo();
                            listaPessoas.remove(c);
                            removido = true;
                            break;
                        }

                    }
                    if (removido) {
                        System.out.println("\nPessoa removida com sucesso!");
                    } else {
                        System.out.println("\nPessoa não encontrado");
                    }
                    break;
                case 5:
                    // EDITAR PESSOA
                    System.out.println("\n ==EDITAR PESSOA== ");
                    System.out.print("Digite o nome da pessoa que deseja editar: ");
                    String editar = entrada.nextLine();

                    boolean encontrado = false;

                    for (Pessoa p : listaPessoas) {
                        if (p.nome.equalsIgnoreCase(editar)) {
                            System.out.println("\nPessoa encontrada! Dados atuais:");
                            p.mostrarInfo();

                            // NOVOS DADOS
                            System.out.println("\nDigite os novos dados:");

                            System.out.print("Novo nome: ");
                            p.nome = entrada.nextLine();

                            System.out.print("Nova idade: ");
                            p.idade = entrada.nextInt();
                            entrada.nextLine();

                            System.out.print("Nova função: ");
                            p.funcao = entrada.nextLine();

                            System.out.print("Novo salário: R$");
                            p.salario = entrada.nextDouble();
                            entrada.nextLine();

                            System.out.println("\nPessoa atualizada com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Pessoa não encontrada!");
                    }

                    break;

                case 6:
                    System.out.print("\nSaindo...");
                    break;
                default:
                    // AÇÂO CASO NÂO SEJA OPÇÂO VIAVEL
                    System.out.println("\nOpção Invalida!");

            }
        } while (opcao != 6);

        entrada.close();

    }
}
