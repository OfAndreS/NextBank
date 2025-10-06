package com.nextbank.model;

public class ContaPoupanca extends Conta
{

    public ContaPoupanca(Cliente myCliente, String numeroCliente, double saldo)
    {
        super(myCliente, numeroCliente, saldo);
    }

    @Override
    public double calculaTributos(double tributo) 
    {
        return 0;
    }
}