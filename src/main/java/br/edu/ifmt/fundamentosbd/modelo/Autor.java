package br.edu.ifmt.fundamentosbd.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Nome;
    private String Sobrenome;

    @ManyToMany(mappedBy = "autores")
    private Set<Livro> livros = new HashSet<>();

    // MÉTODOS CONSTRUTORES.

    public Autor(){}
    public Autor(String nome, String sobrenome) {
        Nome = nome;
        Sobrenome = sobrenome;
    }

    // CÓDIGO GERADO.

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }
}
