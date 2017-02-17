package tp

class DocumentoController {

	static scaffold = Documento


    def index() { }


    def create() {
		[documento: new Documento(), etiqueta: new Etiqueta()]

    }

	def save() {
		
	    def unDocumento = new Documento(nombre: params.nombre, descripcion: params.descripcion)
		if (unDocumento.save()) {
			redirect(action: "show", id: unDocumento.id)	
		}
		return
	}

}
