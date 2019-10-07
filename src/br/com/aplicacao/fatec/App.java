package br.com.aplicacao.fatec;

import br.com.modelo.fatec.Agenda;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.Menu;

public class App {
	public static void main(String[] args) throws Exception {
		Menu neymar = new Menu();
		Agenda ag = new Agenda();
		Controle c = new Controle();
		try {
			ag = c.carregar();
		}
		catch(Exception e) {
			ag = new Agenda();
		}
		neymar.boasVindas();
		int opcao = 100;
		while(opcao != 0) {
			neymar.menu();
			Controle ctrl = new Controle();
			opcao = ctrl.opcao();
			if(opcao == 1) {
				ag.inserirClientes();
			}
			if(opcao == 2) {
				ag.listarClientes();
			}
			if(opcao == 3) {
				ag.trocaRevisao();
			}
			if(opcao == 4) {
				ag.removerRevisao();
			}
			if(opcao == 5) {
				ag.removerCliente();
			}
			
			if (opcao == 0) {
				//ag.sair(); Estava saindo antes de salvar
				break;
			}
			
		}
		c.salvar(ag);
		//ag.sair();
		
	}
}