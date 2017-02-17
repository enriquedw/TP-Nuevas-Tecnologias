package tp

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DatosPersonales)
class DatosPersonalesSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test validaciones"() {
		// los cuatro parametros tienen errores
        def p = new DatosPersonales(nombre: '3#', apellido: '&&/', email:"cualquiera", genero: "U")
	    !p.validate()
        p.hasErrors()
        p.errors.errorCount == 4

		//Solo el nombre es correcto
        p = new DatosPersonales(nombre: 'Jeff', apellido: '&&/', email:"cualquiera", genero: "U")
        !p.validate()
        p.hasErrors()
        p.errors.errorCount == 3

		//Solo el nombre y el apellido son correctos
        p = new DatosPersonales(nombre: 'Jeff', apellido: 'Bridges', email:"cualquiera", genero: "U")
        !p.validate()
        p.hasErrors()
        p.errors.errorCount == 2

		//Solo el genero es incorrecto
        p = new DatosPersonales(nombre: 'Jeff', apellido: 'Bridges', email:"JeffBridges@hotmail.com", genero: "U")
        !p.validate()
        p.hasErrors()
        p.errors.errorCount == 1

		//No hay errores
        p = new DatosPersonales(nombre: 'Jeff', apellido: 'Bridges', email:"JeffBridges@hotmail.com", genero: "M")
        p.validate()
        !p.hasErrors()
        p.errors.errorCount == 0


    }

}
