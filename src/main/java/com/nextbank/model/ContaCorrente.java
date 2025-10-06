package com.nextbank.model;

public class ContaCorrente extends Conta
{

    public ContaCorrente(Cliente myCliente, String numeroCliente, double saldo)
    {
        super(myCliente, numeroCliente, saldo);
    }

    @Override
    public double calculaTributos(double tributo) 
    {
        return 0;
    }
}
