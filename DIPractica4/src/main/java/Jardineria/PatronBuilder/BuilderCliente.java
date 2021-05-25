package Jardineria.PatronBuilder;

import Jardineria.ModelClass.cliente;

public class BuilderCliente {

    cliente cliente;

    public BuilderCliente(int codigo_cliente, String nombre_cliente, String domicilio, 
        int telefono, double limite_credit, String codigo_empleado_rep_ventas, String dni, String email, String password) {

            cliente = new cliente(codigo_cliente, nombre_cliente, domicilio, telefono,
             codigo_cliente, codigo_empleado_rep_ventas, dni, email, password);

    }

    public cliente Buildeo() {

        if (cliente.getNombre_cliente()==null) {
            System.out.println("añade un nuevo nombre");
            
            return null;
            
        }
        return cliente;

    }

}
