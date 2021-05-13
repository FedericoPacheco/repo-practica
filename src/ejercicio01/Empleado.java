package ejercicio01;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public abstract class Empleado 
{
	protected String nombre;
	protected Long cuit;
	protected String correoElectronico;
	protected Integer cantidadDeClientesTratados;
	protected List<Venta> ventasRealizadas;
	protected Double valorObjetivoDeVentas;
	
	public Empleado(String nombre, Long cuit, String correoElectronico, Double valorObjetivoDeVentas) 
	{
		this.nombre = nombre;
		this.cuit = cuit;
		this.correoElectronico = correoElectronico;
		ventasRealizadas = new LinkedList<Venta>();
		this.valorObjetivoDeVentas = valorObjetivoDeVentas;
		cantidadDeClientesTratados = 0;
	}
	
	public abstract Double calcularComision();
	 
	protected Double calcularComisionAuxiliar(Double comisionProductoVeterinario, Double comisionProductoAgroquimico) 
	{
		Double comision = 0.0;
		Double comisionParcial;
		
		for (Venta venta: ventasRealizadas)
		{
			comisionParcial = 0.0;
			
			if (venta.getTipoProducto().equals(Venta.tipoProducto.VETERINARIO))
				comisionParcial = comisionProductoVeterinario * venta.getMontoTotal();
			else if (venta.getTipoProducto().equals(Venta.tipoProducto.AGROQUIMICO))
				comisionParcial += comisionProductoAgroquimico * venta.getMontoTotal();
			
			comision += comisionParcial * this.multiplicadorComisiones(venta.getFecha().getMonth());
		}
		
		return comision;
	}
	
	private Double multiplicadorComisiones(Month mes) {	return (mes.equals(Month.SEPTEMBER))? 2.0 : 1.0; }
	
	public String getRecibo()  // Uso Strings para hacerlo un poco mas simple.
	{
		return "[" + nombre + "(" + cuit + "): " + LocalDate.now().getMonth() + "; " + ventasRealizadas.size() + "; " + cantidadDeClientesTratados + "; " + this.calcularComision() + "]";
	}
	
	public void agregarVenta(Venta venta) { ventasRealizadas.add(venta); }

	public Integer getCantidadDeClientesTratados() {
		return cantidadDeClientesTratados;
	}

	public void setCantidadDeClientesTratados(Integer cantidadDeClientesTratados) {
		this.cantidadDeClientesTratados = cantidadDeClientesTratados;
	}
}
