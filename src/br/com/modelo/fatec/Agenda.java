package br.com.modelo.fatec;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.negocio.fatec.Controle;

@SuppressWarnings("serial")
public class Agenda implements Serializable {
	public List<Cliente> clientes = new ArrayList<Cliente>();
	String padrao = "yyyy-MM-dd";
	transient SimpleDateFormat sdf = new SimpleDateFormat(padrao);
	transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
	
	
	public void inserirClientes() throws ParseException {
		Controle ctrl = new Controle();
		Cliente c = new Cliente(null);
		System.out.println("Por favor, digite um nome para o contato");
		c.nome = (ctrl.texto());
		System.out.println("Por favor, digite um telefone para o contato");
		c.telefone = (ctrl.texto());
		System.out.println("Por favor, digite o seu endereço: ");
		c.endereco = (ctrl.texto());
		System.out.println("Por favor, digite o seu CPF: ");
		c.CPF = (ctrl.texto());
		System.out.println("### Começaremos o cadastro do seu veículo ###");
		System.out.println("Digite o número da placa: ");
		c.numeroPlaca = (ctrl.texto());
		System.out.println("Digite o modelo/versão: ");
		c.modelo = (ctrl.texto());
		System.out.println("Digite o ano de fabricação: ");
		c.anoFabricacao = (ctrl.texto());
		System.out.println("Digite o valor de compra: ");
		c.valordeCompra = (ctrl.texto());
		LocalDate a1 = LocalDate.now();
		a1 = a1.plusMonths(6);
		c.revisao = a1.format(formatter);
		
//		System.out.println("Quando você deseja fazer sua revisão?");
//		System.out.println("1 - Em um mês");
//		System.out.println("2 - Em dois meses");
//		System.out.println("3 - Em três meses");
//		System.out.println("4 - Em seis meses");
		
		System.out.println("### Qual serviço/produto você utiliza? ###");
		System.out.println("1 - Pintura automóvel");
		System.out.println("2 - Troca e calibragem de pneus");
		System.out.println("3 - Mudança de óleo");
		System.out.println("4 - Alinhar direção");
		System.out.println("0 - Terminar cadastro");
		int op = 100;
		while (op != 0) {
			switch(ctrl.opcao()) {
			case 1:{
				c.servicos.add("Pintura automóvel");
				break;
			}
			case 2:{
				c.servicos.add("Troca e calibragem de pneus");
				break;
			}
			case 3:{
				c.servicos.add("Mudança de óleo");
				break;
			}
			case 4:{
				c.servicos.add("Alinhar direção");
				break;
			}
			case 0:{
				op = 0;
				break;
			}
			}
		}
		System.out.println("Cadastro concluído!");
		System.out.println("Sua primeira revisão foi automaticamente agendada para daqui a seis meses.");
		System.out.println("Para trocar a data ou cancelar a revisão selecione a opção no menu inicial.");
		System.out.println("");
		clientes.add(c);
	}
	
	public void listarClientes() {
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Endereço: " + cliente.getEndereco());
			System.out.println("CPF: " + cliente.getCPF());
			System.out.println("Serviços/Produtos " + cliente.getServicos());
			System.out.println("Sua revisão será em: " + cliente.revisao);
//			System.out.println("Veículos do cliente: " + cliente);
			System.out.println("");
		}
	}
	
	public void trocaRevisao() {
		System.out.println("Qual o nome do cliente?");
		Controle ctrl = new Controle();
		String nome = ctrl.texto();
		for(Cliente c: clientes) {
			if (c.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Quando você deseja fazer sua revisão?");
				System.out.println("1 - Em um mês");
				System.out.println("2 - Em dois meses");
				System.out.println("3 - Em três meses");
				System.out.println("4 - Em seis meses");
				LocalDate a1 = LocalDate.now();
				int op = 100;
				while (op != 0) {
					switch(ctrl.opcao()) {
					case 1:{
						a1 = a1.plusMonths(1);
						c.revisao = a1.format(formatter);
						op = 0;
						break;
					}
					case 2:{
						a1 = a1.plusMonths(2);
						c.revisao = a1.format(formatter);
						op = 0;
						break;
					}
					case 3:{
						a1 = a1.plusMonths(3);
						c.revisao = a1.format(formatter);
						op = 0;
						break;
					}
					case 4:{
						a1 = a1.plusMonths(6);
						c.revisao = a1.format(formatter);
						op = 0;
						break;
					}
				}
			}
		}
			else {
				System.out.println("Não há cliente com esse nome");
			}
		}
	}
	public void removerCliente(){
		System.out.println("Qual Cliente você deseja excluir?");
		Controle ctrl = new Controle();
		String nome = ctrl.texto();
		Predicate<Cliente> condition = cliente -> cliente.getNome().equalsIgnoreCase(nome);
		clientes.removeIf(condition);
		}
	public void removerRevisao() {
		System.out.println("De qual cliente a revisão será cancelada?");
		Controle ctrl = new Controle();
		String nome = ctrl.texto();
		for(Cliente c: clientes) {
			if (c.getNome().equalsIgnoreCase(nome)) {
				c.revisao = "Não há revisão agendada";
			}
			else {
				System.out.println("Não há cliente com esse nome");
			}
		}
	}
}
