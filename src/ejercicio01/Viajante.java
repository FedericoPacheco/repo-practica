package ejercicio01;

public class Viajante extends Empleado
{
	public Viajante(String nombre, Long cuit, String correoElectronico, Double valorObjetivoDeVentas) 
	{
		super(nombre, cuit, correoElectronico, valorObjetivoDeVentas);
	}

	public Double calcularComision()
	{
		Double comision = this.calcularComisionAuxiliar(0.2, 0.1);
		comision += 1000 * cantidadDeClientesTratados;
		return ((comision >= valorObjetivoDeVentas)? 1.2 : 1) * comision;
	}
}
