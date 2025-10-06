package com.nextbank.model;

public abstract class Conta {
    private static int PROXIMO_NUMERO_CONTA = 101;

    protected int numero;
    protected double saldo;
    protected Cliente myCliente;

    public Conta(Cliente myCliente, double saldo) {
        this.numero = PROXIMO_NUMERO_CONTA++;
        this.myCliente = myCliente;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("| Depósito de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
        } else {
            System.out.println("| Valor de depósito inválido!");
        }
    }

    public abstract boolean sacar(double valor);
    public abstract boolean transferir(Conta contaDestino, double valor);
    public abstract String getTipoConta();

    public int getNumero() {
        return this.numero;
    }

    public Cliente getCliente() {
        return this.myCliente;
    }

    public double getSaldo() {
        return this.saldo;
    }
}