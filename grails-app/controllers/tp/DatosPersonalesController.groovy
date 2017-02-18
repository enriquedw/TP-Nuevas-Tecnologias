package tp

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DatosPersonalesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DatosPersonales.list(params), model:[datosPersonalesCount: DatosPersonales.count()]
    }

    def show(DatosPersonales datosPersonales) {
        respond datosPersonales
    }

    def create() {
        respond new DatosPersonales(params)
    }

    @Transactional
    def save(DatosPersonales datosPersonales) {
        if (datosPersonales == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (datosPersonales.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond datosPersonales.errors, view:'create'
            return
        }

        datosPersonales.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'datosPersonales.label', default: 'DatosPersonales'), datosPersonales.id])
                redirect datosPersonales
            }
            '*' { respond datosPersonales, [status: CREATED] }
        }
    }

    def edit(DatosPersonales datosPersonales) {
        respond datosPersonales
    }

    @Transactional
    def update(DatosPersonales datosPersonales) {
        if (datosPersonales == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (datosPersonales.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond datosPersonales.errors, view:'edit'
            return
        }

        datosPersonales.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'datosPersonales.label', default: 'DatosPersonales'), datosPersonales.id])
                redirect datosPersonales
            }
            '*'{ respond datosPersonales, [status: OK] }
        }
    }

    @Transactional
    def delete(DatosPersonales datosPersonales) {

        if (datosPersonales == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        datosPersonales.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'datosPersonales.label', default: 'DatosPersonales'), datosPersonales.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'datosPersonales.label', default: 'DatosPersonales'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
