package tp

class DatosPersonales {
    enum Genero {Masculino, Femenino, Otro}

	String nombre
	String apellido
	String email
	Genero genero

    static belongsTo = [participante: Participante]

    static constraints = {
    	nombre matches:  "[A-Za-z]+"
    	apellido matches: "[A-Za-z]+"
    	email email: true
    }

}
