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

    private Cliente myCliente;
    private final ConsoleUI ui;
    private final Scanner scanner;
    private final ContaService myContaService; 
    
    public ContaFactory(Scanner scanner, ConsoleUI ui, ContaService myContaService) 
    {
        this.scanner = scanner;
        this.ui = ui;
        this.myContaService = myContaService; // 3. Atribua a variável
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

        System.out.println("| CRIANDO UMA NOVA CONTA       ");
        System.out.println("|                              ");
        System.out.println("| Selecionar Cliente           ");

        if (!this.myContaService.printAllObjects("OFF", "CLIENTE")) {
            System.out.println("| Cancele a operação, pois não há clientes para associar a uma conta.");
            return null;
        }

        int userInput = scanner.nextInt(); scanner.nextLine(); // Limpa o buffer

        if(userInput < 0 || userInput >= this.myContaService.getClienteList().size())
        {
            System.out.println("| Cliente Inexistente!");
            System.out.println("| Cancelando!");
            return null;
        }

        this.myCliente = this.myContaService.getClienteList().get(userInput);

        System.out.println("| Selecione o tipo de Conta:   ");
        String tipoDeConta = AppConfig.TIPOS_DE_CONTA.get(ui.selector(AppConfig.TIPOS_DE_CONTA));

        return create(tipoDeConta);
    }

}
