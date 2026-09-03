import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         int Opcao = 0;
         double Saldo = 500;
         double[] historico = new double[100];
         int quantidadeOperacoes = 0;


        while (Opcao != 4) {
            System.out.println("============== CAIXA ELETRÔNICO ==============");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.println("5 - Extrato");
            Opcao = sc.nextInt();

            if (Opcao< 0 || Opcao > 5){
                System.out.println("Opção iválida");
            }

            switch (Opcao){
                case 1:
                    System.out.println("Seu saldo é: R$ " + Saldo);
                    break;
                case 2:
                    System.out.println("Digite o valor do depósito:");
                    double valor = sc.nextDouble();

                    if(valor < 0){
                        System.out.println("Valor inválido");
                    }else {
                        if (quantidadeOperacoes < historico.length){

                            historico[quantidadeOperacoes]= valor;

                            quantidadeOperacoes ++;
                        }
                        Saldo += valor;
                        System.out.println("Depósito realizado!");
                    }
                    break;
                case 3:
                    System.out.println("Digite o valor do saque:");
                    double Saque = sc.nextDouble();

                    if(Saque <= Saldo){
                        Saldo -= Saque;
                        System.out.println("Saldo atual: R$ "+ Saldo);
                        if (quantidadeOperacoes < historico.length){

                            historico[quantidadeOperacoes]= -Saque;
                            quantidadeOperacoes ++;
                        }
                    }else {
                        System.out.println("Saldo insuficiente");
                    }
                    break;
                case 4:
                    System.out.println("4 - Sair");
                    break;
                case 5:
                    for (int i = 0; i < quantidadeOperacoes; i++) {
                        if(historico[i] < 0){
                        System.out.println("Saque: R$" + historico[i]);
                        }else {
                            System.out.println("Depósito: R$" + historico[i]);
                        }
                    }
            }


        }

    }
}