package br.com.yuri.banco.teste;

import br.com.yuri.banco.classes.Banco;
import br.com.yuri.banco.classes.Conta;
import br.com.yuri.banco.classes.Titular;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean sair = false;
        Banco banco = new Banco();

        String menuDeOpcoes = """
                            Digite sua Opção
                            1- Abrir Conta
                            2- Sair
                            """;

        //
        while (!sair) {
            System.out.println("\n" + menuDeOpcoes);
            System.out.println("\nSelecione a opção desejada: ");

            int operacao = sc.nextInt();

            switch (operacao) {
                case 1 -> {
                    System.out.println("Informe seu nome: ");
                    String nome = sc.next();
                    System.out.println("Informe seu cpf: ");
                    String cpf = sc.next();
                    Titular novoTitular = new Titular(nome, cpf);
                    Conta novaConta = new Conta(novoTitular);
                    banco.adicionarConta(novaConta);
                    sair = true;
                }
                case 2 -> sair = true;
                default -> System.out.println("Informe a opção desejada");
            }
        }



            menuDeOpcoes = """
                            ***********************************
                            Digite sua Opção
                            1- Abrir outra conta
                            2- Consultar saldo
                            3- Depositar
                            4- Sacar
                            5- Transferir
                            6- Excluir conta
                            7- Sair
                            ***********************************
                            """;

//            System.out.println(banco.lista().get(1004).getTitular());
        sair = false;

        while (!sair){
                System.out.println(menuDeOpcoes);
                System.out.println("Informe a operação desejada: ");
                int operacao = sc.nextInt();

                switch (operacao) {
                    case 1 -> {
                        System.out.println("Informe seu nome: ");
                        String nome = sc.next();
                        System.out.println("Informe seu cpf: ");
                        String cpf = sc.next();
                        Titular novoTitular = new Titular(nome, cpf);
                        Conta novaConta = new Conta(novoTitular);
                        banco.adicionarConta(novaConta);
                    }
                    case 2 -> {
                        System.out.println("Informe o número da conta: ");
                        int conta = sc.nextInt();
                        try {
                            System.out.println(banco.lista().get(conta).getSaldo());
                        } catch (NullPointerException e) {
                            System.out.println("\nNúmero da conta inválido, por favor informe uma conta existente!\n");
                        }
                    }
                    case 3 -> {
                        System.out.println("\nInforme a conta para depósito: ");
                        int conta = sc.nextInt();
                        System.out.println("\nInforme o valor para depósito: ");
                        double valor = sc.nextDouble();
                        try {
                            banco.lista().get(conta).depositar(valor);
                        } catch (NullPointerException e) {
                            System.out.println("\nNúmero da conta inválido, por favor informe uma conta existente!\n");
                        }
                    }
                    case 4 -> {
                        System.out.println("\nInforme a conta da qual deseja sacar: ");
                        int conta = sc.nextInt();
                        System.out.println("\nInforme o valor para sacar: ");
                        double valor = sc.nextDouble();
                        try {
                            banco.lista().get(conta).sacar(valor);
                        } catch (NullPointerException e) {
                            System.out.println("\nNúmero da conta inválido, por favor informe uma conta existente!\n");
                        }
                    }
                    case 5 -> {
                        System.out.println("Informe de qual conta deseja realizar a transferência: ");
                        int conta = sc.nextInt();
                        System.out.println("Informe para qual conta deseja transferir: ");
                        int outra = sc.nextInt();
                        try {
                            Conta outraConta = banco.lista().get(outra);
                            System.out.println("Informe o valor da transferência: ");
                            double valor = sc.nextDouble();
                            banco.lista().get(conta).transferir(outraConta, valor);
                        } catch (NullPointerException e) {
                            System.out.println("\nNúmero da conta inválido, por favor informe uma conta existente!\n");
                        }

                    }
                    case 6 -> {
                        System.out.println("Informe o número da conta que deseja excluir: ");
                        int conta = sc.nextInt();
                        System.out.println("Tem certeza que deseja excluir a conta nº " + conta + "? (Digite 1 para confirme e 2 para cancelar)");
                        int confirma = sc.nextInt();

                        if (confirma == 1) {
                            banco.lista().remove(conta);
                        } else if (confirma != 2) {
                            System.out.println("Opção inválida");;
                        }
                    }
                    case 7 -> {
                        sair = true;
                    }
                    default -> System.out.println("Opção inválida, selecione uma opção existente.");
                }
        }
        System.out.println(banco.lista());

        System.out.println(banco.lista().get(1001));


    }
}