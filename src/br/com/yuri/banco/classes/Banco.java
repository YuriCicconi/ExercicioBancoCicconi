package br.com.yuri.banco.classes;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private final ArrayList<Conta> contas;

    public Banco() {
        contas = new ArrayList<Conta>();
    }

    public void adicionarConta(Conta conta) {

        contas.add(conta);
    }

    public ArrayList<Conta> lista() {

        return this.contas;
    }

    public Conta buscarConta(int numeroDaConta) {
        try{
            for (Conta conta : contas) {
                if (conta.getNumero() == numeroDaConta) {
                    return conta;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Não foi possível encontrar a conta");
        }

        return null;
    }
}
