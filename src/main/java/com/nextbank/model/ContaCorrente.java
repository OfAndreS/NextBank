package com.nextbank.model;

public class ContaCorrente extends Conta
{

    public ContaCorrente(Cliente myCliente, double saldo)
    {
        super(myCliente, saldo);
    }

    @Override
    public double calculaTributos(double tributo) 
    {
        return 0;
    }
}
