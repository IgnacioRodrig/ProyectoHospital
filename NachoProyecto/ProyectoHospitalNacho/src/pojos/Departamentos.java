package pojos;




public class Departamentos {
	/**
	 * 
	 */

	private int id;
	private String nombre;
	private int numEmpleados;
	
	public Departamentos(String nombre, int numEmpleados) {
		this.nombre = nombre;
		this.numEmpleados = numEmpleados;
	}
	
	
	public Departamentos() {
		// TODO Auto-generated constructor stub
	}


	public int getNumEmpleados() {
		return numEmpleados;
	}
	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamentos other = (Departamentos) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Departamentos [id=" + id + ", nombre=" + nombre + ", numEmpleados=" + numEmpleados + "]";
	}
}