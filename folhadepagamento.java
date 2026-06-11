import java.util.Scanner;
import java.util.ArrayList;

public class folhadepagamento {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final double salarioBase = 2000.00;

           ArrayList<colaborador> colaboradores = new ArrayList<>();

        int opcao;

        do {
            System.out.println("******************************");
            System.out.println("FOLHA DE PAGAMENTO");
            System.out.println("1° Cadastro de funcionário padrão");
            System.out.println("2° Cadastro de funcionário comissado");
            System.out.println("3° Cadastro de funcionário produção");
            System.out.println("4° Gerar folha de pagamento");
            System.out.println("0° Sair.");
            System.out.println("******************************");

            System.out.println("Escolha uma das opções acima");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:

                    colaborador padrao = new colaborador();
                    padrao.tipo = 1;

                    System.out.println("Nome do colaborador: ");
                    sc.nextLine();
                    padrao.nome = sc.nextLine();

                    System.out.println("Mátricula: ");
                    padrao.matricula = sc.nextInt();

                    padrao.salario = salarioBase;

                    colaboradores.add(padrao);

                    break;
                case 2:

                    colaborador comissado = new colaborador();
                    comissado.tipo = 2;

                    System.out.println("Nome do colaborador: ");
                    sc.nextLine();
                    comissado.nome = sc.nextLine();

                    System.out.println("Mátricula: ");
                    comissado.matricula = sc.nextInt();

                    System.out.println("Informe valor de venda: ");
                    comissado.vendas = sc.nextDouble();

                    System.out.println("Informe valor da comissão: ");
                    comissado.comissao = sc.nextDouble();
                    
                    comissado.comissao = (comissado.vendas * comissado.comissao)/100;
                    comissado.salario = salarioBase + comissado.comissao;

                    colaboradores.add(comissado);
                    break;
                case 3:

                    colaborador producao = new colaborador();
                    producao.tipo = 3;

                    System.out.println("Nome do colaborador: ");
                    sc.nextLine();
                    producao.nome = sc.nextLine();

                    System.out.println("Mátricula: ");
                    producao.matricula = sc.nextInt();

                    System.out.println("Informe quantidade de peças: ");
                    producao.quantidade = sc.nextInt();

                    System.out.println("Informe valor da peça: ");
                    producao.peca = sc.nextDouble();

                    producao.producao = producao.quantidade * producao.peca;
                    producao.salario = salarioBase + producao.producao;

                    colaboradores.add(producao);
                    break;
                case 4: 

                  System.out.println("Total de pessoas cadastradas: " +colaboradores.size());

                    if(colaboradores.isEmpty()){
                        System.out.println("A lista está vazia.");
                    }
                    else{

                        for(colaborador c : colaboradores){
                            if(c.tipo == 1 ){
                             System.out.println("Nome: " + c.nome);
                             System.out.println("Mátricula: " + c.matricula);
                             System.out.println("Salário fixo: " + salarioBase);
                             System.out.println("Extras: 0");
                             System.out.println("Salário final: " + c.salario);

                            }
                            else if(c.tipo == 2 ){
                             System.out.println("****************");
                             System.out.println("Nome: " + c.nome);
                             System.out.println("Mátricula: " + c.matricula);
                             System.out.println("Salário fixo: " + salarioBase);
                             System.out.println("Comissão: " + c.comissao );
                             System.out.println("Salário final: " + c.salario);   
                            }
                            else if(c.tipo == 3 ){
                              System.out.println("****************");
                              System.out.println("Nome: " + c.nome);
                              System.out.println("Mátricula: " + c.matricula);
                              System.out.println("Salário fixo: " + salarioBase);
                              System.out.println("Produtividade: " + c.producao );
                              System.out.println("Salário final: " + c.salario); 
                            }
                        }

                        

                    }
                    
                    break;
                case 0:
                    System.out.println("Encerrando sistema.");
                    break;
                default:
                    System.out.println("Opção inválida...");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}