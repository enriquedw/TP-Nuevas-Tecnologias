package tp

class Creditos {
	Integer cantidad
	Participante participante

    static constraints = {
    	cantidad range: 0..10
    	participante nullable: true
    }
}
