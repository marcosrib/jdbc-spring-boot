package com.teste1.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SalvarArquivo {


	public void createFile(List<String> dados, String fileName) {

		try {
			
			FileWriter writer = new FileWriter(System.getProperty("user.home")+"/logs/"+fileName+".csv");
			BufferedWriter out = new BufferedWriter(writer);

			int i = 0;
			for (String reg : dados) {
				if (i > 0)
					out.newLine();
				out.write(reg.replaceAll(",", ";"));
				i++;
			}
			out.close();
			writer.close();

		} catch (IOException e) {
			System.err.println("Erro gravar arquivo: " + e.getMessage());
		}
		
		
	}
}