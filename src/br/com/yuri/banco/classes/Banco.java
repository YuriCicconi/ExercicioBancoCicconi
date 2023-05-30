package br.com.yuri.banco.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {

    private final HashMap<Integer, Conta > contas;

    public Banco() {
        contas = new HashMap<>();
    }

    public void adicionarConta(Conta conta) {

        contas.put(conta.getNumero(), conta);
    }

    public HashMap<Integer, Conta> lista() {

        return this.contas;
    }

    public String buscarConta(int numeroDaConta) {

        for (int i = 0; i < contas.size(); i++) {
            return "" + contas.get(i);
        }
        return "Não foi possível encontrar a conta solicitada";
    }
}
