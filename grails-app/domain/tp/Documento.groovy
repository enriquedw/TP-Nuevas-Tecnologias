package tp

class Documento {

    enum TIPOS_NOMBRES { Machete, Notas}
    enum ATRIBUTOS {Claridad, Efectividad}
    Participante participante
	TIPOS_NOMBRES tipo
	String nombre
	String descripcion
	String archivo_path

	static hasMany = [etiquetas: Etiqueta]
    static hasOne = [tipoDoc: TipoDoc]
    //static belongsTo = [participante: Participante]
  
    static constraints = {
    	etiquetas nullable: true
    }


/*
    Documento(Participante un_participante) {
        participante = un_participante
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
*/
}
