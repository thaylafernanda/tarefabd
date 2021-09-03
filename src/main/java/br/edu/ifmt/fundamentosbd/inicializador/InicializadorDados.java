package br.edu.ifmt.fundamentosbd.inicializador;


import br.edu.ifmt.fundamentosbd.modelo.Autor;
import br.edu.ifmt.fundamentosbd.modelo.Livro;
import br.edu.ifmt.fundamentosbd.repositorio.AutorRepositorio;
import br.edu.ifmt.fundamentosbd.repositorio.LivroRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InicializadorDados implements CommandLineRunner {

    private final LivroRepositorio livroRepositorio;
    private final AutorRepositorio autorRepositorio;

    public InicializadorDados(LivroRepositorio livroRepositorio, AutorRepositorio autorRepositorio){
        this.autorRepositorio = autorRepositorio;
        this.livroRepositorio = livroRepositorio;
    }
    @Override
    public void run(String... args) throws Exception { 

        // INICIALIZANDO OS LIVROS 1-3

        Livro livro1 = new Livro("Dom Quixote", "12345");
        Autor autor1 = new Autor("Miguel", "de Cervantes");

        livro1.getAutores().add(autor1);
        autor1.getLivros().add(livro1);

        autorRepositorio.save(autor1);
        livroRepositorio.save(livro1);

        Livro livro2 = new Livro("Dom Casmurro", "54321");
        Autor autor2 = new Autor("Machado", "de Assis");

        livro2.getAutores().add(autor2);
        autor2.getLivros().add(livro2);

        autorRepositorio.save(autor2);
        livroRepositorio.save(livro2);

        System.out.println("Inicializador OK!!!");
        System.out.println("Numero de Livros " +livroRepositorio.count());

    }
}
