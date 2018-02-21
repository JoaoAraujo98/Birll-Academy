package academia.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import academia.config.Cliente;
import academia.daos.ClienteDAO;

@Controller
public class AcademiaController {

	@RequestMapping("clientes/form")
	public String form() {

		System.out.println("Acesando o formul�rio dos clientes");
		return "clientes/form";

	}

	@RequestMapping(value="clientes", method=RequestMethod.POST)
	public String gravar(Cliente c) {
		System.out.println("acessando o m�todo de gravar um cliente");

		System.out.println("Nome: " + c.getNome());
		System.out.println("Cpf: " + c.getCpf());
		System.out.println("Fone: " + c.getFone());
		System.out.println("Email: " + c.getEmail());
		System.out.println("Endere�o: " + c.getEndereco());
		System.out.println("Data de nascimento: " + c.getDataNascimento());

		ClienteDAO dao = new ClienteDAO();
		dao.inserir(c);

		return "redirect:clientes";

	}
	@RequestMapping(value="clientes", method=RequestMethod.GET)
	public ModelAndView listar() {
		
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.getLista();

		ModelAndView modelAndView = new ModelAndView("clientes/listar");
		modelAndView.addObject("clientes", clientes);
		
		return modelAndView;

	}
	
	@RequestMapping(value= "clientes/remover")
	public ModelAndView remover(Cliente c){
		System.out.println("removendo cliente");
		ClienteDAO dao = new ClienteDAO();
		dao.remover(c);
		
		return listar();
		
	}
	
	@RequestMapping(value="clientes/selecionar")
	public ModelAndView selecionar(Cliente c ){
		ClienteDAO dao = new ClienteDAO();
		c = dao.getById(c.id);
		
		
		ModelAndView modelAndView = new ModelAndView("clientes/alterar");
		modelAndView.addObject("clientes", c);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="clientes/alterar")
	public ModelAndView alterar (Cliente c){
		System.out.println("alterando cliente");
		ClienteDAO dao = new ClienteDAO();
		dao.alterar(c);
		
		return listar();
		
	
	}
		
	
}
	
	
	
	


