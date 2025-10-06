package com.nextbank.factory;

import java.security.PublicKey;
import java.util.Scanner;

import com.nextbank.model.Cliente;
import com.nextbank.model.Conta;
import com.nextbank.util.AppConfig;
import com.nextbank.util.ConsoleUI;

public class ContaFactory 
{

    private final Scanner scanner;
    private final ConsoleUI ui;

    
    public ContaFactory(Scanner scanner, ConsoleUI ui) 
    {
        this.scanner = scanner;
        this.ui = ui;
    }

    
    private Conta create(String tipoConta)
    {
        switch (tipoConta) 
        {
            case "CORRENTE":
                return null;
                // return createContaCorrente();
            case "POUPANCA":
                return null;
                // return createContaPoupanca();
            default:
                throw new IllegalArgumentException("Tipo de entregador desconhecido: " + tipoConta);
        } 
    }
    
    public Conta createConta()
    {
        ui.printHead();
        System.out.println("| CRIANDO UMA NOVA CONTA       ");
        System.out.println("|                              ");
        System.out.println("| Selecione o tipo de Conta:   ");

        int indiceVeiculo = ui.selector(AppConfig.TIPOS_DE_CONTA);
        String tipoVeiculo = AppConfig.TIPOS_DE_CONTA.get(indiceVeiculo);

        Conta myCliente = create(tipoVeiculo);

        return myCliente;
    }

}
