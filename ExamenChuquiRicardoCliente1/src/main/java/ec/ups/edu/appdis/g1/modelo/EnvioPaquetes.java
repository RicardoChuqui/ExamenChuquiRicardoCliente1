package ec.ups.edu.appdis.g1.modelo;

import java.io.Serializable;

public class EnvioPaquetes implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String apellido;
	private String direccionRemitente;
	private String direccionDestino;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccionRemitente() {
		return direccionRemitente;
	}
	public void setDireccionRemitente(String direccionRemitente) {
		this.direccionRemitente = direccionRemitente;
	}
	public String getDireccionDestino() {
		return direccionDestino;
	}
	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
