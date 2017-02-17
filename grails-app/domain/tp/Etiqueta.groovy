package tp

class Etiqueta {
	static def CATEGORIAS = ["Universidad", "Materia", "Otra"]
	static String getCategorias() {
		return this.Categorias
	}
	String categoria
	String referencia
    static constraints = {
    }


}
