package academia.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import academia.config.Cliente;
import academia.config.Fluxo;
import academia.config.Mensalidade;
import academia.daos.ClienteDAO;
import academia.daos.MensalidadeDAO;

@Controller
public class AcademiaController {

	@RequestMapping("clientes/form")
	public String form() {

		System.out.println("Acesando o formulário dos clientes");
		return "clientes/form";

	}
	
	@RequestMapping("clientes/formfluxo")
	public String formfluxo() {

		System.out.println("fluxo de caixa");
		return "clientes/formfluxo";

	}

	@RequestMapping(value="clientes", method=RequestMethod.POST)
	public String gravar(Cliente c) {
		System.out.println("acessando o método de gravar um cliente");

		System.out.println("Nome: " + c.getNome());
		System.out.println("Cpf: " + c.getCpf());
		System.out.println("Fone: " + c.getFone());
		System.out.println("Email: " + c.getEmail());
		System.out.println("Endereço: " + c.getEndereco());
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
	public String remover(Cliente c){
		System.out.println("removendo cliente");
		ClienteDAO dao = new ClienteDAO();
		dao.remover(c);
		
		return "redirect:/clientes";
		
	}
	
	@RequestMapping(value="clientes/selecionar")
	public ModelAndView selecionar(Cliente c ){
		ClienteDAO dao = new ClienteDAO();
		c = dao.getById(c.id);
		
		
		ModelAndView modelAndView = new ModelAndView("clientes/alterar");
		modelAndView.addObject("clientes", c);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="clientes/selecionarnome")
	public String selecionarnome(){
		
		return "clientes/selecionarnome";
		
	}
	
	@RequestMapping(value="clientes/buscarnome")
	public ModelAndView buscarnome(String nome){
		ClienteDAO dao = new ClienteDAO();
		 
		List<Cliente> c = dao.getByNome(nome);
		
		
		
		ModelAndView modelAndView = new ModelAndView("clientes/listar");
		modelAndView.addObject("clientes", c);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="clientes/alterar")
	public String alterar (Cliente c){
		System.out.println("alterando cliente");
		ClienteDAO dao = new ClienteDAO();
		dao.alterar(c);
		
		return "redirect:/clientes";
		
	
	}
	
	@RequestMapping(value="clientes/vermensalidades")
	public ModelAndView vermensalidades (Cliente c){
		
		
		
		MensalidadeDAO dao2 = new MensalidadeDAO();
		List<Mensalidade> mensalidades = dao2.getLista(c.id);
		
		ModelAndView modelAndView = new ModelAndView("clientes/mensalidades");
		modelAndView.addObject("mensalidades", mensalidades);
		
		return modelAndView;
	
	}
	
	@RequestMapping(value="clientes/pagarmensalidade")
	public ModelAndView pagarmensalidade(Cliente c ){
		ClienteDAO dao = new ClienteDAO();
		c = dao.getById(c.id);
		
		
		ModelAndView modelAndView = new ModelAndView("clientes/pagar");
		modelAndView.addObject("clientes", c);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="teste", method=RequestMethod.GET)
	public String t(){
		return "clientes/teste";
	}
	
	@RequestMapping(value="mensalidades", method=RequestMethod.POST)
	public String pagar(Mensalidade m) {
		System.out.println("acessando o método de gravar uma mensalidade");

		System.out.println("Valor:" +m.getValor()+"Codigo:" + m.getCodigo()+"Idcliente:" + m.getIdcliente()+"DataFim:" + m.getDatafim()+"Data inicio:" + m.getDatainicio()+"Data pagamento:" + m.getDatapagamento());
		

		MensalidadeDAO dao = new MensalidadeDAO();
		dao.inserir(m);
		
		
		return "redirect:clientes";

	}
	
	@RequestMapping(value="pagarm", method = RequestMethod.POST)
	public String pagarM(Mensalidade m, String nome){
		
		System.out.println("acessando o método de gravar uma mensalidade");

		System.out.println("Valor:" +m.getValor()+"Codigo:" + m.getCodigo()+"Idcliente:" + m.getIdcliente()+"DataFim:" + m.getDatafim()+"Data inicio:" + m.getDatainicio()+"Data pagamento:" + m.getDatapagamento());
		
		System.out.println(m.getValor());

		MensalidadeDAO dao = new MensalidadeDAO();
		dao.inserir(m);
		
		
		return "redirect:clientes";
	}
	
	@RequestMapping(value="solicitarfluxo", method = RequestMethod.POST)
	public ModelAndView solicitarFluxo(String datainicio, String datafim){
		
		System.out.println("acessando o método de solicitar fluxo");

		
		
		
		MensalidadeDAO dao = new MensalidadeDAO();
				

		
		
		List<Mensalidade> mensalidades = dao.getFluxo(datainicio, datafim);
		
		ModelAndView modelAndView = new ModelAndView("clientes/mensalidades");
		modelAndView.addObject("mensalidades", mensalidades);
		
		return modelAndView;
	}
	
	
		
	
}
	
	
	
	


