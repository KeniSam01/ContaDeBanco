import java.util.Objects;
import java.util.Scanner;

public class Banco {
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;

    public int getNumConta(){return this.numConta;}
    public void setNumConta (int conta){
        this.numConta = conta;
    }
    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getDono(){
        return this.dono;
    }
    public void setDono(String dono){
        this.dono = dono;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public void constructor(){
        this.status = status;
        this.saldo = saldo;
        if (this.status == true){
            this.saldo = saldo;
            System.out.println("[$] BEM VINDO(A), SUA CONTA ENCONTRA-SE: DESBLOQUEADA |$_$|");
        }else {
            System.out.println("[!] ERROR 001[!]\n[!]SUA CONTA ESTÁ FECHADA!");
        }

    }
    public void corpoDoCartao(){
        System.out.println("\n[$] SISTEMA DE BANCO v1.0 [$]");
        System.out.println("[$] INFORMAÇÕES DO(A) CLIENTE "+ getDono().toUpperCase() + " [$]\n");
        constructor();
        System.out.println("[$] TIPO: " + getTipo());
        System.out.println("[$] Nº DA CONTA " + getNumConta());
        System.out.println("[$] SALDO: R$" + getSaldo() + " REAIS\n");
    }
    public void abrirConta(int conta, String tipo, String dono, double saldo, boolean status){
        this.numConta = conta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = saldo;
        this.status = true;
        if (this.tipo.equals("CC")){
            this.saldo = saldo + 50;
            corpoDoCartao();

        }
        else{
            this.saldo = saldo + 150;
            corpoDoCartao();
        }
    }
    public void fecharConta(){
        if (getSaldo() < 0){
            this.status = true;
            System.out.println("[!] VOCÊ POSSUI PENDENCIAS COM O BANCO!\n[!] PORTANTO NÃO PODEMOS ESTAR FECHANDO SUA CONTA.\n[!] FAVOR CONTACTAR O SEU GERENTE.");
        }else{
            this.status = false;
            this.saldo = 0;
            System.out.println("[$] VOCÊ SELECIONOU A OPÇÃO FECHAR A CONTA!");
            System.out.println("[$] SUA CONTA ESTÁ OFICIALMENTE FECHADA.");
            System.out.println("[$] SALDO: R$" + getSaldo() + " REAIS");
        }
    }
    public void depositarDinheiro(){
        if (getStatus() == true){
            if (getSaldo() > 0) {
                this.saldo = saldo;
                Scanner dp = new Scanner(System.in);
                System.out.print("[$] SUA CONTA ESTÁ EM ORDEM, DIGITE O VALOR QUE QUER DEPOSITAR: R$");
                int depositar = dp.nextInt();
                this.saldo += depositar;
                System.out.println("[$] DINHEIRO DEPOSITADO COM SUCESSO!\n[$] SEU SALDO AGORA É DE: R$" + getSaldo() + " REAIS");
            }else {
                System.out.println("[!] SALDO NEGATIVO, NÃO POSSIBILITANDO O SAQUE!");
            }
        }else {
            System.out.println("[!] VOCÊ NÃO POSSUI UMA CONTA ABERTA.");
        }
    }
    public void sacarDinheiro(){
        if (getSaldo() > 0 && getStatus()){
            this.saldo = getSaldo();
            Scanner saque = new Scanner(System.in);
            System.out.print("[$] SUA CONTA CUMPRE OS REQUISITOS NECESSARIOS, DIGITE O VALOR QUE QUER SACAR: R$");
            double subtrairDin = saque.nextDouble();
            if (getSaldo() > subtrairDin) {
                this.saldo -= subtrairDin;
                System.out.println("[$] SALDO ATUALIZADO PARA: R$" + getSaldo() + " REAIS");
            }else {
                System.out.println("[!] VALOR MAIOR DO QUE O SALDO DA CONTA, POR FAVOR DIGITE UM VALOR VALIDO.");
            }
        }else {
            System.out.println("[!] NO MOMENTO VOCÊ NÃO PODE REALIZAR UM SAQUE, VERIFIQUE AS INFORMAÇÕES DA SUA CONTA.");
        }
    }
    public void pagarMensalidade(){
        if (getStatus() && this.tipo.equals("CC")){
            this.saldo -= 12;
            System.out.println("[$] EFETUAMOS A COBRANÇA DA MENSALIDADE DESCONTANDO DIRETAMENTE DO SEU SALDO!");
            System.out.println("[$] SALDO ATUALIZADO: R$" + getSaldo());
        } else if (getStatus() && this.tipo.equals("CP")) {
            this.saldo -= 20;
            System.out.println("[$] EFETUAMOS A COBRANÇA DA MENSALIDADE DESCONTANDO DIRETAMENTE DO SEU SALDO!");
            System.out.println("[$] SALDO ATUALIZADO: R$" + getSaldo());

        }
    }

}
