package ejercicio01;

import java.time.LocalDate;

public class Venta 
{
	public enum tipoProducto
	{
		VETERINARIO,
		HERBICIDA,
		FERTILIZANTE
	}
	
	private String nombreCliente;
	private LocalDate fecha;
	private Double montoTotal;
	private tipoProducto tipoProducto;
	
	public Venta() 
	{
		
	}
}
