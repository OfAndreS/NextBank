package com.nextbank.factory;

import java.security.PublicKey;
import java.util.Scanner;

import com.nextbank.model.Cliente;
import com.nextbank.model.Conta;
import com.nextbank.model.ContaCorrente;
import com.nextbank.model.ContaPoupanca;
import com.nextbank.service.ContaService;
import com.nextbank.util.AppConfig;
import com.nextbank.util.ConsoleUI;

public class ContaFactory 
{

    private final ConsoleUI ui;
    private final Scanner scanner;
    private Cliente myCliente;
    
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
                return createContaCorrente();
            case "POUPANCA":
                return createContaPoupanca();
            default:
                throw new IllegalArgumentException("Tipo de entregador desconhecido: " + tipoConta);
        } 
    }
    
    private ContaCorrente createContaCorrente()
    {   
        System.out.println("| Qual o saldo Inicial");
        double saldoInicial = scanner.nextDouble();
        return new ContaCorrente(this.myCliente, saldoInicial);
    }

    private ContaPoupanca createContaPoupanca()
    {   
        System.out.println("| Qual o saldo Inicial");
        double saldoInicial = scanner.nextDouble();
        return new ContaPoupanca(this.myCliente, saldoInicial);
    }

    public Conta createContaFromConsole()
    {
        ui.printHead();

        ContaService myContaService = new ContaService(scanner, ui);

        System.out.println("| CRIANDO UMA NOVA CONTA       ");
        System.out.println("|                              ");
        System.out.println("| Selecionar Cliente           ");
        myContaService.printAllObjects("OFF", "CLIENTE");

        int userInput = scanner.nextInt();

        if(userInput < 0 || userInput > myContaService.getClienteList().size())
        {
            System.out.println("| Conta Inexistente!");
            System.out.println("| Cancelando!");
            return null;
        }

        this.myCliente = myContaService.getClienteList().get(userInput);

        System.out.println("| Selecione o tipo de Conta:   ");

        String tipoDeConta = AppConfig.TIPOS_DE_CONTA.get(ui.selector(AppConfig.TIPOS_DE_CONTA));

        return create(tipoDeConta);
    }

}
