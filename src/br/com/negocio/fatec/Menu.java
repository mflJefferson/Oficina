package br.com.negocio.fatec;

public class Menu {
	public void boasVindas() {
		System.out.println("Bem vindo a melhor agenda do mundo!");
	}
	public void menu() {
		System.out.println("### Menu ###");
		System.out.println("1 - Inserir cliente");
		System.out.println("2 - Listar cliente");
		System.out.println("3 - Re-agendar revisão");
		System.out.println("5 - Cancelar a revisão");
		System.out.println("6 - Relatório de serviços feitos");
		System.out.println("7 - Excluir cliente");
		System.out.println("0 - Sair");
	}
}