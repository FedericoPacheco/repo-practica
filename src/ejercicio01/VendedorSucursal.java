package ejercicio01;

public class VendedorSucursal extends Vendedor 
{
	private Integer cantidadDeClientesAtendidos;
	
	public VendedorSucursal(String nombre, Long cuit, String correoElectronico, Double valorObjetivoDeVentas) 
	{
		super(nombre, cuit, correoElectronico, valorObjetivoDeVentas);
		cantidadDeClientesAtendidos = 0;
	}

	public Double calcularComision()
	{
		Double comision = this.calcularComisionAuxiliar(0.25, 0.2);
		comision += 5000 * (cantidadDeClientesAtendidos / 20);
		return ((comision >= valorObjetivoDeVentas)? 1.1 : 1) * comision;
	}

	public Integer getCantidadDeClientesAtendidos() {
		return cantidadDeClientesAtendidos;
	}

	public void setCantidadDeClientesAtendidos(Integer cantidadDeClientesAtendidos) {
		this.cantidadDeClientesAtendidos = cantidadDeClientesAtendidos;
	}
}
