package br.com.yuri.banco.classes;

public class Conta extends Banco {

    private Titular titular;
    private static int numeroConta = 1000;
    private int numero;
    private double saldo;

    public Conta(Titular titular) {
        numeroConta++;
        this.titular = titular;
        this.saldo = saldo;
        this.numero = numeroConta;
    }

    public Titular getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Valor para depósito inválido");
        }
    }

    public void sacar(double valor) {
        if(valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void transferir(Conta contaDeDestino, double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            contaDeDestino.saldo += valor;
            System.out.println("Transferência realizada com sucesso.\n" +
                    "Conta de destino: " + contaDeDestino.getNumero() +"\n" +
                    "Valor transferido: " + valor);
        } else {
            System.out.println("Transferência não realizada: Saldo insuficiente");
        }
    }

    @Override
    public String toString() {
        return "Titular: " + this.getTitular().getNome() + " | " + "Conta: " + this.getNumero() + " | " + "Saldo: " + this.getSaldo();
    }
}
