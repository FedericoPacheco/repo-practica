package ejercicio01;

public class VendedorSucursal extends Vendedor 
{
	private Integer cantidadDeClientesTratados;
	
	public VendedorSucursal(String nombre, Long cuit, String correoElectronico, Double valorObjetivoDeVentas) 
	{
		super(nombre, cuit, correoElectronico, valorObjetivoDeVentas);
	}

	public Double calcularComision()
	{
		Double comision = this.calcularComisionAuxiliar(0.25, 0.2);
		comision += 5000 * (cantidadDeClientesTratados / 20);
		return ((comision >= valorObjetivoDeVentas)? 1.1 : 1) * comision;
	}
}
