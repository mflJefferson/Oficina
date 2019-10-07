package br.com.negocio.fatec;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.com.modelo.fatec.Agenda;
import br.com.modelo.fatec.Cliente;

public class Controle {
	public Scanner scanner;

	public Controle() {
		scanner = new Scanner(System.in);
	}

	public int opcao() {
		int op = scanner.nextInt();
		return op;
	}

	public String texto() {
		String t = scanner.nextLine();
		return t;
	}
	
	public void carregar(Agenda ag) throws Exception {
		File arq = new File("agenda.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);
		String texto = brd.readLine();
		while(texto != null) {
			Cliente c  = new Cliente(texto);
			ag.clientes.add(c);
			texto = brd.readLine();
		}
		brd.close();
	}
	
	public void salvar(Agenda ag) throws IOException {
		File arq = new File("agenda.txt");
		FileWriter wr = new FileWriter(arq);
		BufferedWriter bwr = new BufferedWriter(wr);
		for(Cliente c : ag.clientes) {
			bwr.write(c.getNome());
			bwr.newLine();
			bwr.write(c.getTelefone());
			bwr.newLine();
		}
		bwr.close();
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		scanner.close();
	}
}