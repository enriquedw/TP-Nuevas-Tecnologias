package tp

class Documento {

	static TIPOS_CANTIDAD = 2
	static TIPOS_NOMBRES = ["Machete", "Notas"]
	static TIPOS_DESC = ["sasa1", "sasa2"]
	
	Participante participante
	private Integer tipo
	String nombre
	String descripcion
	String archivo_path

	static hasMany = [etiquetas: Etiqueta]

    static constraints = {
    	
    }

    Documento DocumentoBuilder(String tipo_doc, unas_etiquetas){
    	def doc
    	switch ( tipo_doc ) {
	    	case TIPOS_NOMBRES[0]:
    	    	doc = new Documento(tipo: 0, etiquetas: unas_etiquetas)
        		break;
        	case TIPOS_NOMBRES[1]:
    	    	doc = new Documento(tipo: 1, etiquetas: unas_etiquetas)
        		break;
        	default:
        		doc = null
        }

        return doc
    }

}
