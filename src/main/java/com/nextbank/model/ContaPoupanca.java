package com.nextbank.model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente myCliente, double saldo) {
        super(myCliente, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("| Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
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
    public String getTipoConta() {
        return "Poupança";
    }
}