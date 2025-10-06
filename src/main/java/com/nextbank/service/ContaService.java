package com.nextbank.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import com.nextbank.model.Cliente;
import com.nextbank.model.Conta;
import com.nextbank.util.AppConfig;
import com.nextbank.util.ConsoleUI;

public class ContaService 
{
    private ArrayList<Conta> ContaList = new ArrayList<>();
    private ArrayList<Cliente> ClienteList = new ArrayList<>();

    private final ConsoleUI ui;
    private final Scanner scanner;

    public ContaService(Scanner scanner, ConsoleUI ui)
    {
        this.scanner = scanner;
        this.ui = ui;

    }

    public boolean printAllObjects(String userInput, String tipoObj)
    {
        String tipoConta = "";

        if(userInput.equals("ON"))
        {
            ui.printHead();
    
            System.out.println("| Escolha o Tipo da Lista para Exibição: ");
            tipoConta = AppConfig.TIPOS_DE_ENTIDADE.get(ui.selector(AppConfig.TIPOS_DE_ENTIDADE));

        }
        else if(userInput.equals("OFF"))
        {
            tipoConta = tipoObj;
        }

        ui.printHead();

        switch (tipoConta) 
        {
            case "CLIENTE":
                System.out.println("| LISTA DE CLIENTES                ");
                if(ClienteList.isEmpty())
                {
                    System.out.println("| Lista de Cliente está vazia! ");
                    return false;
                }
        
                for(int i = 0; i < ClienteList.size(); i++)
                {
                    System.out.println("| [ " + i + " ] - Nome: " + ClienteList.get(i).getNomeCliente());
                }
                break;
            case "CONTA":
                System.out.println("| LISTA DE CONTAS                ");
                if(ContaList.isEmpty())
                {
                    System.out.println("| Lista de Conta está vazia! ");
                    return false;
                }
                for(int i = 0; i < ContaList.size(); i++)
                {
                    System.out.println("| [ " + i + " ] - Nome: " + ContaList.get(i).getCliente().getNomeCliente() + " - Saldo: " + ContaList.get(i).getSaldo());
                }
                break;
            default:
                throw new IllegalArgumentException("Tipo desconhecido: ");
        }

        return true;

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
