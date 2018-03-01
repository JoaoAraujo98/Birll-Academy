package academia.config;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Mensalidade {

	
	
	public Long codigo;
	public Long idcliente;
	private double valor;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar datapagamento;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar datainicio;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar datafim;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Calendar getDatapagamento() {
		return datapagamento;
	}
	public void setDatapagamento(Calendar datapagamento) {
		this.datapagamento = datapagamento;
	}
	public Calendar getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(Calendar datainicio) {
		this.datainicio = datainicio;
	}
	public Calendar getDatafim() {
		return datafim;
	}
	public void setDatafim(Calendar datafim) {
		this.datafim = datafim;
	}
	
	
	
	
}
