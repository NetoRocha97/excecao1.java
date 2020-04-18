package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String atualizacaoData(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro na reserva: as datas da reserva para atualiza��o devem ser futuras";
		}
		if (!checkOut.after(checkIn)) {
			return "Erro na reserva: a data do check-out deve ser posterior � data do check-in";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto "
			+ numeroDoQuarto
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duracao()
			+" noites";
			
	}

}
