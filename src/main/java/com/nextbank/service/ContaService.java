package com.nextbank.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.nextbank.model.Cliente;
import com.nextbank.model.Conta;

public class ContaService 
{
    private ArrayList<Conta> ContaList = new ArrayList<>();
    private ArrayList<Cliente> ClienteList = new ArrayList<>();

    private final Scanner scanner;

    public ContaService(Scanner scanner)
    {
        this.scanner = scanner;
    }


    public void printAllClientes()
    {
        for(int i = 0; i < ClienteList.size(); i++)
        {
            System.out.println("| [ " + i + " ] - " + ClienteList.get(i).getNomeCliente());
        }
    }

    public void addCliente(Cliente myCliente)
    {
        this.ClienteList.add(myCliente);
    }

    public void addConta(Conta myConta)
    {
        this.ContaList.add(myConta);
    }

    public ArrayList<Cliente> getClienteList()
    {
        return this.ClienteList;
    }

    public ArrayList<Conta> getContaList()
    {
        return this.ContaList;
    }
}
