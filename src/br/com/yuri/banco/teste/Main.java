package br.com.yuri.banco.teste;

import br.com.yuri.banco.classes.Banco;
import br.com.yuri.banco.classes.Conta;
import br.com.yuri.banco.classes.Titular;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();

        Titular yuri = new Titular("Yuri", "52818026833");
        Titular amanda = new Titular("Amanda", "50474859633");
        Titular laura = new Titular("Laura", "14758963526");

        Conta conta1 = new Conta(yuri);
        Conta conta2 = new Conta(amanda);
        Conta conta3 = new Conta(laura);

        conta1.depositar(100);
        conta2.depositar(100);
        conta3.depositar(100);

        conta1.sacar(50);
        conta2.sacar(50);
        conta3.sacar(50);

        conta1.transferir(conta2, 50);

        System.out.println();


        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);
        banco.adicionarConta(conta3);

        System.out.println(banco.lista());
    }
}