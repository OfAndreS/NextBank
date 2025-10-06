package com.nextbank.model;

public class Cliente 
{
    private String cpfCliente;
    private String nomeCliente;

    public Cliente(String nomeCliente, String cpfCliente)
    {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente()
    {
        return this.cpfCliente;
    }

    public String getNomeCliente()
    {
        return this.nomeCliente;
    }

}
