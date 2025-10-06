package com.nextbank.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.nextbank.interfaces.ITributavel;
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

    // Métodos de negócio
    
    public void realizarDeposito() {
        ui.printHead();
        System.out.println("| REALIZAR DEPÓSITO");
        int numeroConta = ui.input("| Digite o número da conta: ", Integer.class);
        Conta conta = findContaByNumero(numeroConta);

        if (conta != null) {
            double valor = ui.input("| Digite o valor a ser depositado: ", Double.class);
            conta.depositar(valor);
        } else {
            System.out.println("| Conta não encontrada!");
        }
    }
    
    public void realizarSaque() {
        ui.printHead();
        System.out.println("| REALIZAR SAQUE");
        int numeroConta = ui.input("| Digite o número da conta: ", Integer.class);
        Conta conta = findContaByNumero(numeroConta);

        if (conta != null) {
            double valor = ui.input("| Digite o valor a ser sacado: ", Double.class);
            conta.sacar(valor);
        } else {
            System.out.println("| Conta não encontrada!");
        }
    }
    
    public void realizarTransferencia() {
        ui.printHead();
        System.out.println("| REALIZAR TRANSFERÊNCIA");
        int numeroContaOrigem = ui.input("| Digite o número da conta de ORIGEM: ", Integer.class);
        Conta contaOrigem = findContaByNumero(numeroContaOrigem);

        if (contaOrigem == null) {
            System.out.println("| Conta de origem não encontrada!");
            return;
        }

        int numeroContaDestino = ui.input("| Digite o número da conta de DESTINO: ", Integer.class);
        Conta contaDestino = findContaByNumero(numeroContaDestino);

        if (contaDestino == null) {
            System.out.println("| Conta de destino não encontrada!");
            return;
        }

        if(contaOrigem.getNumero() == contaDestino.getNumero()) {
            System.out.println("| A conta de origem e destino não podem ser a mesma!");
            return;
        }

        double valor = ui.input("| Digite o valor a ser transferido: ", Double.class);
        contaOrigem.transferir(contaDestino, valor);
    }
    
    public void calcularTotalTributos() {
        double totalTributos = 0.0;
        for (Conta conta : ContaList) {
            if (conta instanceof ITributavel) {
                ITributavel contaTributavel = (ITributavel) conta;
                totalTributos += contaTributavel.calculaTributos();
            }
        }
        ui.printHead();
        System.out.println("| CÁLCULO TOTAL DE TRIBUTOS");
        System.out.println("| Total de tributos a recolher: R$ " + String.format("%.2f", totalTributos));
    }
    
    public Conta findContaByNumero(int numeroConta) {
        for (Conta conta : ContaList) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public boolean printAllObjects(String userInput, String tipoObj)
    {
        String tipoLista = tipoObj;

        if("ON".equals(userInput))
        {
            ui.printHead();
            System.out.println("| Escolha o Tipo da Lista para Exibição: ");
            tipoLista = AppConfig.TIPOS_DE_ENTIDADE.get(ui.selector(AppConfig.TIPOS_DE_ENTIDADE));
        }

        ui.printHead();

        switch (tipoLista) 
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
                    System.out.println("| [ " + i + " ] - Nome: " + ClienteList.get(i).getNomeCliente() + " | CPF: " + ClienteList.get(i).getCpfCliente());
                }
                break;
            case "CONTA":
                System.out.println("| LISTA DE CONTAS                ");
                if(ContaList.isEmpty())
                {
                    System.out.println("| Lista de Conta está vazia! ");
                    return false;
                }
                for(Conta conta : ContaList)
                {
                    System.out.println(
                        "| Conta: " + conta.getNumero() + 
                        " | Cliente: " + conta.getCliente().getNomeCliente() + 
                        " | Saldo: R$ " + String.format("%.2f", conta.getSaldo()) +
                        " | Tipo: " + conta.getTipoConta()
                    );
                }
                break;
            default:
                System.out.println("| Tipo de lista desconhecido.");
                return false;
        }
        return true;
    }

    public void addCliente(Cliente myCliente)
    {
        this.ClienteList.add(myCliente);
    }

    public void addConta(Conta myConta)
    {
        if (myConta != null) {
            this.ContaList.add(myConta);
            System.out.println("| Conta número " + myConta.getNumero() + " criada com sucesso para " + myConta.getCliente().getNomeCliente() + "!");
        }
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