package ejercicio01;

public class VendedorOnline extends Vendedor 
{
	public VendedorOnline(String nombre, Long cuit, String correoElectronico, Double valorObjetivoDeVentas) 
	{
		super(nombre, cuit, correoElectronico, valorObjetivoDeVentas);
	}

	public Double calcularComision()
	{
		Double comision = this.calcularComisionAuxiliar(0.05, 0.05);
		comision += 1000 * (cantidadDeClientesTratados / 100);
		return ((comision >= valorObjetivoDeVentas)? 1.2 : 1) * comision;
	}
}
