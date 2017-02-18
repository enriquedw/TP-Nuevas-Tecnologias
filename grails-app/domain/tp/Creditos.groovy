package tp

class Creditos {
	Integer cantidad

    static belongsTo = [perfilColaborativo: PerfilColaborativo]

    static constraints = {
    	cantidad range: 0..10
    }
}
