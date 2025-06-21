package com.projeto.app;

import com.projeto.model.Visitante;
import com.projeto.service.VisitanteService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		VisitanteService service = new VisitanteService();
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		while (true) {
			System.out.println("\n=== Controle de Visitantes ===");
			System.out.println("1 - Registrar entrada");
			System.out.println("2 - Aprovar entrada");
			System.out.println("3 - Registrar saída");
			System.out.println("4 - Listar visitantes presentes");
			System.out.println("0 - Sair");
			System.out.print("Escolha: ");

			String input = sc.nextLine();
			int opcao;

			try {
				opcao = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor, digite um número.");
				continue;
			}

			switch (opcao) {
				case 1:
					System.out.print("Nome: ");
					String nome = sc.nextLine();

					System.out.print("Motivo da visita: ");
					String motivo = sc.nextLine();

					Visitante v = new Visitante(nome, motivo);
					service.registrarEntrada(v);
					break;

				case 2:
					System.out.print("ID do visitante para aprovar: ");
					int idAprovar = lerInt(sc);
					service.aprovarEntrada(idAprovar);
					break;

				case 3:
					System.out.print("ID do visitante para registrar saída: ");
					int idSaida = lerInt(sc);
					service.registrarSaida(idSaida);
					break;

				case 4:
					List<Visitante> presentes = service.listarVisitantesPresentes();
					System.out.println("\n=== Visitantes Presentes ===");

					if (presentes.isEmpty()) {
						System.out.println("Não há visitantes no momento.");
					} else {
						for (Visitante visit : presentes) {
							System.out.println(
									"ID: " + visit.getId() +
											" | Nome: " + visit.getNome() +
											" | Motivo: " + visit.getMotivo() +
											" | Entrada: " + visit.getHorarioEntrada().format(formatter)
							);
						}
					}
					break;

				case 0:
					System.out.println("Encerrando...");
					sc.close();
					System.exit(0);
					break;

				default:
					System.out.println("Opção inválida.");
			}
		}
	}

	private static int lerInt(Scanner sc) {
		while (true) {
			String input = sc.nextLine();
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.print("Entrada inválida. Digite um número válido: ");
			}
		}
	}
}
