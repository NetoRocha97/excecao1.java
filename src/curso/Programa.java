package curso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Quarto numero: ");
		int numero = Integer.parseInt(sc.nextLine());
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.nextLine());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.nextLine());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
		}
		else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: "+ reserva);
			
			System.out.println();
			System.out.print("Insira dados para atualizar a reserva: ");
			System.out.print("Data de check-in ()dd/MM/yyyy: ");
			checkIn = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.nextLine());
			
			Date agora = new Date();
			if(checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: As datas de reserva para atualização devem ser futuras.");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
			}
			else {
			reserva.atualizacaoData(checkIn, checkOut);
			System.out.println("Reserva: "+ reserva);
			}
		}
		
		
		
		sc.close();

	}
}
