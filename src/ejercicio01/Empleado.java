package ejercicio01;

import java.util.LinkedList;
import java.util.List;

public abstract class Empleado 
{
	private String nombre;
	private Long cuit;
	private String correoElectronico;
	List<Venta> ventasRealizadas;
	Double valorObjetivoDeVentas;
	
	public Empleado(String nombre, Long cuit, String correoElectronico, Double valorObjetivoDeVentas) 
	{
		this.nombre = nombre;
		this.cuit = cuit;
		this.correoElectronico = correoElectronico;
		ventasRealizadas = new LinkedList<Venta>();
		this.valorObjetivoDeVentas = valorObjetivoDeVentas;
	}
	
	public abstract Double calcularComision();
	protected Double calcularComisionAuxiliar(Double comisionProductoVeterinario, Double comisionProductoAgroquimico) 
	{
		Double comision = 0.0;
		
		for (Venta venta: ventasRealizadas)
			if (venta.getTipoProducto().equals(Venta.tipoProducto.VETERINARIO))
				comision += comisionProductoVeterinario * venta.getMontoTotal();
			else if (venta.getTipoProducto().equals(Venta.tipoProducto.AGROQUIMICO))
				comision += comisionProductoAgroquimico * venta.getMontoTotal();
		
		return comision;
	}
	
	public void agregarVenta(Venta venta) { ventasRealizadas.add(venta); }
}
