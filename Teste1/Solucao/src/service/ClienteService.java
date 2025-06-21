package service;

import model.Cliente;

public class ClienteService {

    public void salvarCliente(Cliente cliente) {
        if (validaCliente(cliente)) {
            System.out.println("Salvando cliente...");
            // Simulação de lógica de persistência
            System.out.println("Cliente salvo com sucesso");
        } else {
            System.out.println("Dados inválidos");
        }
    }

    private boolean validaCliente(Cliente cliente) {
        return isNomeValido(cliente.getNome()) &&
                isCpfValido(cliente.getCpf()) &&
                isEmailValido(cliente.getEmail()) &&
                isTelefoneValido(cliente.getTelefone());
    }

    private boolean isNomeValido(String nome) {
        return nome != null && !nome.isBlank();
    }

    private boolean isCpfValido(String cpf) {
        return cpf != null && cpf.length() == 11 && cpf.matches("\\d{11}");
    }

    private boolean isEmailValido(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    private boolean isTelefoneValido(String telefone) {
        if (telefone == null) return false;
        String telefoneLimpo = telefone.replaceAll("[^\\d]", "");
        return telefoneLimpo.matches("^\\d{10,11}$");
    }
}
