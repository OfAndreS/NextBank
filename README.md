<div align="center"\>
  <img width="796" height="238" alt="image" src="https://github.com/user-attachments/assets/3b4b7ab2-6f2c-493f-a0c2-2e04ecb3252d" />
</div>

<br>

-----

<div align="center"\>
  <strong>Um sistema de console em Java para simulação de gerenciamento bancário.</strong\>
</div>

<br>

<div align="center">
  <img src="https://img.shields.io/github/license/OfAndreS/NextBank?style=for-the-badge" alt="Licença">
  <img src="https://img.shields.io/github/stars/OfAndreS/NextBank?style=for-the-badge" alt="Stars">
  <img src="https://img.shields.io/github/forks/OfAndreS/NextBank?style=for-the-badge" alt="Forks">
  <img src="https://img.shields.io/github/last-commit/OfAndreS/NextBank?style=for-the-badge" alt="Último Commit">
</div>

<br>

<p align="center">
  <a href="#estrutura-do-projeto">Estrutura do Projeto</a> •
  <a href="#tecnologias">Tecnologias</a> •
  <a href="#como-executar">Como Executar</a> •
</p>

-----

<br>

|**Sobre o Projeto**|
|-|
|O NextBank é um sistema de simulação bancária desenvolvido em Java para ser executado via console. O projeto foi criado como parte da disciplina de Linguagem de Programação 2, com o objetivo de aplicar conceitos fundamentais de Programação Orientada a Objetos (POO). O sistema permite gerenciar clientes e suas contas, processar transações financeiras básicas e calcular tributos, simulando as operações de um banco digital.|

<br>

<div align="center"\>
  <img width="1102" height="500" alt="image" src="https://github.com/user-attachments/assets/c6fc7925-3a6c-4189-8d06-afb3a99ba65a" />
</div>

<br>

-----

<br>

| **Funcionalidades** |
|---|
| <p align="justify">  Criação de Clientes e Contas: <br> <br> -  Permite o cadastro de novos clientes e a abertura de Contas Corrente ou Poupança. A geração do número da conta é feita de forma automática e sequencial. </p> |
| <p align="justify">Transações Financeiras: <br> <br> - Suporte completo para operações de depósito, saque e transferência entre contas, com validações de saldo. </p> |
| <p align="justify"> Regras de Negócio Específicas: <br> <br> - Aplicação de taxa de 5% sobre o valor de saques e transferências realizadas a partir de Contas Corrente. </p> |
| <p align="justify"> Cálculo de Tributos: <br> <br> - Sistema para calcular e consolidar o total de tributos, aplicando uma alíquota de 1% sobre o saldo de todas as Contas Corrente. </p> |
| <p align="justify"> Interface de Console: <br> <br> - Interage com o usuário através de um menu de console simples e intuitivo. </p> |

<br>

-----

<br>

## **Estrutura do Projeto**
<br>

```bash
NextBank/
└── src/
    └── main/
        └── java/
            └── com/
                └── nextbank/
                    ├── application/
                    │   └── Main.java               # Classe principal que inicia a aplicação e o menu.
                    ├── factory/
                    │   ├── ClienteFactory.java     # Cria instâncias de Cliente.
                    │   └── ContaFactory.java       # Cria instâncias de Conta (Corrente ou Poupança).
                    ├── interfaces/
                    │   └── ITributavel.java        # Interface que define o contrato para cálculo de tributos.
                    ├── model/
                    │   ├── Cliente.java            # Modelo para o cliente.
                    │   ├── Conta.java              # Classe abstrata base para os tipos de contas.
                    │   ├── ContaCorrente.java      # Modelo para a conta corrente.
                    │   └── ContaPoupanca.java      # Modelo para a conta poupança.
                    ├── service/
                    │   └── ContaService.java       # Gerencia as operações de contas e clientes.
                    └── util/
                        ├── AppConfig.java          # Armazena constantes e configurações da aplicação.
                        └── ConsoleUI.java          # Controla a interface do usuário no console.
```

<br>

## **Tecnologias**

<br>

| Ferramenta | Descrição |
|-----------|----------------------------------------------------------------|
| **Java** | Linguagem de programação principal utilizada para toda a lógica do sistema. |

<br>

## **Como Executar**

<br>

Para ter uma cópia local deste projeto e executá-lo, siga os passos abaixo.

<details>
  <summary><strong>Pré-requisitos</strong></summary>
  
  - Você vai precisar do Java Development Kit (JDK) instalado na sua máquina.
  - Você vai precisar do Git instalado na sua máquina para clonar o repositório.
  - É bom ter um editor de texto como o VS Code ou uma IDE como IntelliJ ou Eclipse.

</details>

<details>
  <summary><strong>Rodando a Aplicação</strong></summary>

<br>

1 ) **Clone o repositório:**

```bash
git clone https://github.com/OfAndreS/FastDelivery.git
````

2 ) **Navegue até o diretório `src` do projeto:**

```bash
cd NextBank
```

3 ) **Compile todos os arquivos Java a partir do diretório `src`:**

```bash
# Para sistemas baseados em Unix (Linux, macOS)
mkdir -p bin && javac -d bin $(find src/main/java -name "*.java")

# Para Windows (PowerShell)
if (-not (Test-Path -Path "bin")) { New-Item -ItemType Directory -Path "bin" }; javac -d bin (Get-ChildItem -Recurse -Path src/main/java -Filter *.java).FullName
```

4 ) **Execute a classe principal a partir do diretório `src`:**

```bash
java -cp bin com.nextbank.application.Main
```

</details>
