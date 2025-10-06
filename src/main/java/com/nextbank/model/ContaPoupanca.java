package com.nextbank.model;

public class ContaPoupanca extends Conta
{

    public ContaPoupanca(Cliente myCliente, double saldo)
    {
        super(myCliente, saldo);
    }

    @Override
    public double calculaTributos(double tributo) 
    {
        return 0;
    }
}