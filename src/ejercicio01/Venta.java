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
	
	public Venta(String nombreCliente, LocalDate fecha, Double montoTotal, tipoProducto tipoProducto) 
	{
		this.nombreCliente = nombreCliente;
		this.fecha = fecha;
		this.montoTotal = montoTotal;
		this.tipoProducto = tipoProducto;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
