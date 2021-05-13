package ejercicio01;

public abstract class Vendedor extends Empleado 
{
	public Vendedor(String nombre, Long cuit, String correoElectronico, Double valorObjetivoDeVentas) 
	{
		super(nombre, cuit, correoElectronico, valorObjetivoDeVentas);
	}
}
