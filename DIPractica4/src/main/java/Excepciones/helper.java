package Excepciones;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class helper {
	
	public helper(){
		
		
	}

	public void ClienteNoEncontrado(long id , long id2) throws ClientNotFoundException{
		
		if(id==id2) {
			
			//System.out.println("Cliente encontrado");
		}else {
			
			throw new  ClientNotFoundException("Cliente no encontrado");
			
		}
		
		
	}
	
public void WrongDeliveryDayException(Calendar fecha) throws WrongDeliveryDayException{
		
	int dia=fecha.getFirstDayOfWeek();
			if(dia==dia+3){
			throw new  WrongDeliveryDayException("La fecha de entrega esperada no puede ser anterior a tres d�as despu�s de la fecha de creaci�n");
			
			}
		
		
	}



public void WrongOrderDayCreationException(Calendar fecha , Calendar diaHoy) throws WrongOrderDayCreationException{
	
	
		if(fecha!=diaHoy){
			throw new  WrongOrderDayCreationException("La fecha de creaci�n debe ser el  �d�a de hoy� ");

			}
		
	
}


	
}
