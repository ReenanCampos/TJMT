package app;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import model.Cliente;
import service.ClienteService;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente(
            "João da Silva",
            "12345678901",
            "(41)99999-9999",
            "joao.silva@email.com"
        );

        ClienteService service = new ClienteService();

        service.salvarCliente(cliente);
    }
}