package tp

class Participante {

    ArrayList documentos


	static hasOne = [datosPersonales: DatosPersonales, perfilColaborativo: PerfilColaborativo]
	static hasMany = [documentos: Documento]
	static constraints = {}
    
    Participante(){
    	datosPersonales = new DatosPersonales()
        perfilColaborativo = new PerfilColaborativo()
        documentos = new ArrayList()
    }

    
    Participante(DatosPersonales datos){
    	datosPersonales = datos
    	perfilColaborativo = new PerfilColaborativo()
        documentos = new ArrayList()
    }
    
}
