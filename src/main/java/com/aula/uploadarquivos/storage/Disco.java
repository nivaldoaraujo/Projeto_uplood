package com.aula.uploadarquivos.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Disco {

	private String raiz = "C:/Imagem/";
	private String diretorioFotos = "fotos";
	
	public void salvarFotos(MultipartFile foto)
	{
		this.salvar(this.diretorioFotos, foto);
	}
	{
		
	}
	
	private void salvar(String diretorio, MultipartFile arquivo)
	{
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
			
		}
		catch(IOException e) 
		{
			throw new RuntimeException("Problema na tentativa de salvar arquivo! ", e);
			
		}
		
	}
}
