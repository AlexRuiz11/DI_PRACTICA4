package Jardineria.ModelClassDao;

import static org.junit.Assert.*;


import org.junit.Test;

import Jardineria.ModelClass.cliente;
import Jardineria.ModelClassDao.Dao;
import Jardineria.ModelClassDao.clienteDao;
import Jardineria.PatronBuilder.BuilderCliente;

public class Pruebas {

	
	
    private static Dao<cliente> clientesDao  = new clienteDao();
    private cliente cliente= new BuilderCliente(189, "Alex", "zaragoza", 189, 123.12, "5234a","25698312A","peep123@hotmail.es","1111").Buildeo();
public Pruebas() {
	
	
}
	
	
    @Test
	public void DNI(cliente cliente) {
    	boolean miBool;
    	
    	if(cliente.getDni().matches("[0-9]{8}[A-Z]{1}")==true) {
    		miBool=true;
    		assertEquals(true, miBool);
    	}else {
    		
    		fail("Formato DNI incorrecto");
    	}
    	
    	 
	}
	
	
	

    @Test
	public void email(cliente cliente) {
    	boolean miBool;

    	if(cliente.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")==true) {
    		miBool=true;

    		assertEquals(true,miBool);
    	}else {
    		
    		fail("Formato email incorrecto");
    	}
    	
    	 
	}

}
