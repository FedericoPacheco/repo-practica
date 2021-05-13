package ejercicio01;

public class VendedorOnline extends Vendedor 
{
	Integer cantidadDeClientesContactados; // No sé si está correcto.
	
	public VendedorOnline(String nombre, Long cuit, String correoElectronico, Double valorObjetivoDeVentas) 
	{
		super(nombre, cuit, correoElectronico, valorObjetivoDeVentas);
		cantidadDeClientesContactados = 0;
	}

	public Double calcularComision()
	{
		Double comision = this.calcularComisionAuxiliar(0.05, 0.05);
		comision += 1000 * (cantidadDeClientesContactados / 100);
		return ((comision >= valorObjetivoDeVentas)? 1.2 : 1) * comision;
	}

	public Integer getCantidadDeClientesContactados() {
		return cantidadDeClientesContactados;
	}

	public void setCantidadDeClientesContactados(Integer cantidadDeClienteContactados) {
		this.cantidadDeClientesContactados = cantidadDeClienteContactados;
	}
}
