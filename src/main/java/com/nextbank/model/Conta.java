package com.nextbank.model;

import com.nextbank.interfaces.ITributavel;

public abstract class Conta implements ITributavel
{
    protected double saldo;
    protected Cliente myCliente;

    public Conta(Cliente myCliente, double saldo)
    {
        this.saldo = saldo;
        this.myCliente = myCliente;
    }

    public Cliente getCliente()
    {
        return this.myCliente;
    }

    public double getSaldo()
    {
        return this.saldo;
    }

}
