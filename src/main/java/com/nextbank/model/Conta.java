package com.nextbank.model;

import com.nextbank.interfaces.ITributavel;

public abstract class Conta implements ITributavel
{
    protected double saldo;
    protected Cliente myCliente;
    protected String numeroCliente;

    public Conta(Cliente myCliente, String numeroCliente, double saldo)
    {
        this.saldo = saldo;
        this.myCliente = myCliente;
        this.numeroCliente = numeroCliente;
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
