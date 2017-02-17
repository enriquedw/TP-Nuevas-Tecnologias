package tp

class Participante {
	DatosPersonales datosPersonales
	Creditos creditos
	PerfilColaborativo perfilColaborativo

	static hasOne = [datosPersonales: DatosPersonales, creditos: Creditos, perfilColaborativo: PerfilColaborativo]
	static hasMany = [documentos: Documento]
	static constraints = {
        datosPersonales unique: true
    }

    Participante(){
    	datosPersonales = new DatosPersonales()
    	creditos = new Creditos()
    }
    Participante(DatosPersonales datos){
    	datosPersonales = datos
    	creditos = new Creditos(cantidad: 3)
    	perfilColaborativo = new PerfilColaborativo()
    }
}
