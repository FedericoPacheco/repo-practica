package isi.died.parcial01.ejercicio02.dominio;

public class InscripcionNoPudoRealizarseException extends Exception 
{
	public InscripcionNoPudoRealizarseException()
	{
		super("Error. La inscripcion no pudo llevarse a cabo. Intente nuevamente.");
	}
}
