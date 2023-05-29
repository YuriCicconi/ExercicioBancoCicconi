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

    public String buscarConta(int numeroDaConta) {
        for (Conta conta : contas) {
                if (conta.getNumero() == numeroDaConta) {
                    return "" + conta;
                }
            }
        return "Não foi possível encontrar a conta solicitada";
    }
}
