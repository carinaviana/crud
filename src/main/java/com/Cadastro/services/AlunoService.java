package com.Cadastro.services;

import com.Cadastro.entities.Aluno;

public interface AlunoService {

    Iterable<Aluno> listAllAluno();

    Aluno getAlunoById(Integer id);

    Aluno saveAluno(Aluno product);

    void deleteAluno(Integer id);

}
