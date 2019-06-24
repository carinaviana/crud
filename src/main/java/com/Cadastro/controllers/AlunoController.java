package com.Cadastro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Cadastro.entities.Aluno;
import com.Cadastro.services.AlunoService;

/**
 * Product controller.
 */
@Controller
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    /**
     * List all aluno.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/aluno", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("aluno", alunoService.listAllAluno());
        System.out.println("Returning alunos:");
        return "aluno";
    }

    /**
     * View a specific aluno by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("aluno/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("aluno", alunoService.getAlunoById(id));
        return "alunoshow";
    }


    @RequestMapping("aluno/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("aluno", alunoService.getAlunoById(id));
        return "alunoform";
    }

    /**
     * New aluno.
     *
     * @param model
     * @return
     */
    @RequestMapping("aluno/new")
    public String newProduct(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunoform";
    }

    /**
     * Save aluno to database.
     *
     * @param aluno
     * @return
     */
    @RequestMapping(value = "aluno", method = RequestMethod.POST)
    public String saveAluno(Aluno aluno) {
        alunoService.saveAluno(aluno);
        return "redirect:/aluno/" + aluno.getId();
    }

    /**
     * Delete aluno by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("aluno/delete/{id}")
    public String delete(@PathVariable Integer id) {
        alunoService.deleteAluno(id);
        return "redirect:/aluno";
    }

}
