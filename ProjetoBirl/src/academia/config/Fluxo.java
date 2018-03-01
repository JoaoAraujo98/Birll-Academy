package academia.config;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Fluxo {

	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Calendar datainicio;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Calendar datafim;
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
