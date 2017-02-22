package tp

class PerfilColaborativo {
	enum Cualidades { Productividad, Asertividad }
	
	Integer[] cualidadesValores
    Integer documentosPublicados
    

    static hasOne = [creditos: Creditos]
    static belongsTo = [participante: Participante]
    static constraints = {
    	cualidadesValores maxSize: 2
    }

    PerfilColaborativo(){
        creditos = new Creditos(perfilColaborativo: this, cantidad: 3)
    	cualidadesValores = [0, 0]
        documentosPublicados = 0
    }

}
