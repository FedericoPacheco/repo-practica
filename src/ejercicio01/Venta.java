package ejercicio01;

import java.time.LocalDate;

public class Venta 
{
	public enum tipoProducto
	{
		VETERINARIO,
		AGROQUIMICO
	}
	
	private String nombreCliente;
	private LocalDate fecha;
	private Double montoTotal;
	private tipoProducto tipoProducto;
	
	public Venta() 
	{
		
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public tipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(tipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
}
