package tp

class PerfilColaborativo {
	static List cualidades = [new Cualidad(nombre: 'Productividad', descripcion: "sarasa"), 
		new Cualidad(nombre: 'Asertividad', descripcion: "sarasa2")]
	
	Participante participante
	Integer[] cualidadesValores

    static constraints = {
    	cualidadesValores maxSize: 2
    }

    PerfilColaborativo(){
    	cualidadesValores = [0, 0]
    }

}
