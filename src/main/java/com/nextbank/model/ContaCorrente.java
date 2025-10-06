package com.nextbank.model;

import com.nextbank.interfaces.ITributavel;

public class ContaCorrente extends Conta implements ITributavel {

    private static final double TAXA_SAQUE = 0.05; 

    public ContaCorrente(Cliente myCliente, double saldo) {
        super(myCliente, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        double valorTotalSaque = valor * (1 + TAXA_SAQUE);
        if (valor > 0 && this.saldo >= valorTotalSaque) {
            this.saldo -= valorTotalSaque;
            System.out.println("| Saque de R$ " + String.format("%.2f", valor) + " (taxa de R$ " + String.format("%.2f", valor * TAXA_SAQUE) + ") realizado.");
            return true;
        }
        System.out.println("| Saldo insuficiente ou valor inválido!");
        return false;
    }
    
    @Override
    public boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) { 
            contaDestino.depositar(valor);
            System.out.println("| Transferência realizada com sucesso!");
            return true;
        }
        System.out.println("| Transferência não realizada.");
        return false;
    }

    @Override
    public double calculaTributos() {
        return this.saldo * 0.01;
    }

    @Override
    public String getTipoConta() {
        return "Corrente";
    }
}