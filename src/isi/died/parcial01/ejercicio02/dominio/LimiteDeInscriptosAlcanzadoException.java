package isi.died.parcial01.ejercicio02.dominio;

@SuppressWarnings("serial")
public class LimiteDeInscriptosAlcanzadoException extends Exception
{
	public LimiteDeInscriptosAlcanzadoException()
	{
		super("Error. El limite de inscriptos ha sido alcanzado.");
	}
}
