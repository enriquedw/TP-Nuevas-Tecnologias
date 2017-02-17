package tp

class DatosPersonales {
	String nombre
	String apellido
	String email
	String genero
    Participante participante

    static constraints = {
    	nombre matches:  "[A-Za-z]+"
    	apellido matches: "[A-Za-z]+"
    	email email: true
    	genero matches: "[MF]"
    }

}
