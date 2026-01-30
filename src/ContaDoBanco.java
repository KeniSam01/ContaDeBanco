public class ContaDeBanco {
    public static void main(String[] args) {
        Banco clienteUm = new Banco();
        clienteUm.abrirConta(1234, "CP", "jubileu", 300, true);
        clienteUm.depositarDinheiro();
        clienteUm.sacarDinheiro();
        Banco clienteDois = new Banco();
        clienteDois.abrirConta(12345, "CC", "creusa", 500, true);
        clienteDois.fecharConta();
        clienteDois.depositarDinheiro();
        clienteDois.sacarDinheiro();
        clienteDois.pagarMensalidade();


    }
}