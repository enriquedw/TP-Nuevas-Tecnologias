package tp

class ParticipanteController {

	static scaffold = Participante

	def index() {
		[participanteList: Participante.list(params), participanteTotal: Participante.count()]
	}
	

	def show() {
	    [participante: Participante.get(params.id)]
	}

	def create() {
		[participante: new Participante()]
	}

	def save() {
		
	    def unParticipante = new Participante(new DatosPersonales(params))
		if (unParticipante.save()) {
			redirect(action: "show", id: unParticipante.id)	
		}
		return
	}

	def showDatos(){
		[participante: Participante.get(params.id)]
	}

	def showPerfil(){
		[participante: Participante.get(params.id)]
	}

	def createDoc(){
		[participante: Participante.get(params.id), documento: new Documento(), etiqueta: new Etiqueta(referencia: "Hola")]
	}

	def listDocs(){
		[participante: Participante.get(params.id)]
	}

	def searchDocs(){
		[participante: Participante.get(params.id)]
	}

	
}
