package Jardineria.ModelClassDao;

import java.util.*;

import Jardineria.ModelClass.cliente;
import Excepciones.ClientNotFoundException;
import Excepciones.helper;

public class clienteDao implements Dao<cliente> {

    private List<cliente> clientes = new ArrayList<>();
    private helper helper= new helper();

    public clienteDao() {

        clientes.add(new cliente(1, "Alex", "domicilio", 660442980, 1200.7, "codigo_empleado_rep_ventas","DNI","email","password"));
        clientes.add(new cliente(2, "Pepe", "domicilio", 660442980, 1200.7, "codigo_empleado_rep_ventas","DNI","email","password"));
        clientes.add(new cliente(3, "David", "domicilio", 660442980, 1200.7, "codigo_empleado_rep_ventas","DNI","email","password"));
        clientes.add(new cliente(4, "Alba", "domicilio", 660442980, 1200.7, "codigo_empleado_rep_ventas","DNI","email","password"));
        clientes.add(new cliente(5, "Susana", "domicilio", 660442980, 1200.7, "codigo_empleado_rep_ventas","DNI","email","password"));
        clientes.add(new cliente(6, "Iris", "domicilio", 660442980, 1200.7, "codigo_empleado_rep_ventas","DNI","email","password"));
        clientes.add(new cliente(7, "Juan", "domicilio", 660442980, 1200.7, "codigo_empleado_rep_ventas","DNI","email","password"));


    }

    @Override
    public Optional<cliente> get(long id) {
    	
    	
    	
    	
    	try {
			helper.ClienteNoEncontrado(id, id);
		} catch (ClientNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return Optional.ofNullable(clientes.get((int) id));
    }

    @Override
    public List<cliente> getAll() {

        return clientes;
    }

    @Override
    public void save(cliente t) throws Exception {
        for (cliente cliente : clientes) {
            if (cliente.getCodigo_cliente() == t.getCodigo_cliente()) { //
                if (cliente.getNombre_cliente() == t.getNombre_cliente() && cliente.getTelefono() == t.getTelefono()) {

                    throw new Exception("duplicar clientes malo");
                }
                System.out.println("cliente ya existe");

                return;
            }

        }
        Pruebas test= new Pruebas();
        
        test.DNI(t);
        test.email(t);

        clientes.add(t);

    }

    @Override
    public void update(cliente t, String[] params) {

        t.setNombre_cliente("predeterminado");
        t.setCodigo_cliente(111);
        t.setDomicilio("domicilio");
        t.setLimite_credit(6666666);
        t.setCodigo_empleado_rep_ventas("codigo_empleado_rep_ventas");
        t.setDni("DNI");
        t.setEmail("Email");
        t.setPassword("Password");

    }

    @Override
    public void delete(cliente t) {
        clientes.remove(t);

    }

}
