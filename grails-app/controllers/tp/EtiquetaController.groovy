package tp

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EtiquetaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Etiqueta.list(params), model:[etiquetaCount: Etiqueta.count()]
    }

    def show(Etiqueta etiqueta) {
        respond etiqueta
    }

    def create() {
        respond new Etiqueta(params)
    }

    @Transactional
    def save(Etiqueta etiqueta) {
        if (etiqueta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (etiqueta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond etiqueta.errors, view:'create'
            return
        }

        etiqueta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'etiqueta.label', default: 'Etiqueta'), etiqueta.id])
                redirect etiqueta
            }
            '*' { respond etiqueta, [status: CREATED] }
        }
    }

    def edit(Etiqueta etiqueta) {
        respond etiqueta
    }

    @Transactional
    def update(Etiqueta etiqueta) {
        if (etiqueta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (etiqueta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond etiqueta.errors, view:'edit'
            return
        }

        etiqueta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'etiqueta.label', default: 'Etiqueta'), etiqueta.id])
                redirect etiqueta
            }
            '*'{ respond etiqueta, [status: OK] }
        }
    }

    @Transactional
    def delete(Etiqueta etiqueta) {

        if (etiqueta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        etiqueta.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'etiqueta.label', default: 'Etiqueta'), etiqueta.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'etiqueta.label', default: 'Etiqueta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
