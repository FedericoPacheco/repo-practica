package ejercicio01;

import java.util.LinkedList;
import java.util.List;

public class RecursosHumanos 
{
	public RecursosHumanos()
	{
		
	}
	
	public List<String> getReciboVendedores (List<Empleado> vendedores)
	{
		List<String> reciboDeComisiones = new LinkedList<String>();
		
		for (Empleado empleado: vendedores)
			reciboDeComisiones.add(empleado.getRecibo());
		
		return reciboDeComisiones;
	}
	
	// No se hacen tests por falta de tiempo :c
}
