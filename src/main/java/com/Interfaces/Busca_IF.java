package com.Interfaces;

public interface Busca_IF{
    boolean checaVetorOrdenado(Filme_IF[] filmes);
    Filme_IF buscaLinearIterativa(Filme_IF[] filmes, int nota) throws Exception;
    Filme_IF buscaLinearRecursiva(Filme_IF[] filmes, int nota) throws Exception;
    Filme_IF buscaBinariaIterativa(Filme_IF[] filmes, int nota) throws Exception;
    Filme_IF buscaBinariaRecursiva(Filme_IF[] filmes, int nota) throws Exception;
    Filme_IF buscaLinearIterativaDuasPontas(Filme_IF[] filmes, int nota) throws Exception;
}
