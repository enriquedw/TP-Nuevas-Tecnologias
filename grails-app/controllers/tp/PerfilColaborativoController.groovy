package tp

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PerfilColaborativoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PerfilColaborativo.list(params), model:[perfilColaborativoCount: PerfilColaborativo.count()]
    }

    def show(PerfilColaborativo perfilColaborativo) {
        respond perfilColaborativo
    }

    def create() {
        respond new PerfilColaborativo(params)
    }

    @Transactional
    def save(PerfilColaborativo perfilColaborativo) {
        if (perfilColaborativo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (perfilColaborativo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond perfilColaborativo.errors, view:'create'
            return
        }

        perfilColaborativo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'perfilColaborativo.label', default: 'PerfilColaborativo'), perfilColaborativo.id])
                redirect perfilColaborativo
            }
            '*' { respond perfilColaborativo, [status: CREATED] }
        }
    }

    def edit(PerfilColaborativo perfilColaborativo) {
        respond perfilColaborativo
    }

    @Transactional
    def update(PerfilColaborativo perfilColaborativo) {
        if (perfilColaborativo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (perfilColaborativo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond perfilColaborativo.errors, view:'edit'
            return
        }

        perfilColaborativo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'perfilColaborativo.label', default: 'PerfilColaborativo'), perfilColaborativo.id])
                redirect perfilColaborativo
            }
            '*'{ respond perfilColaborativo, [status: OK] }
        }
    }

    @Transactional
    def delete(PerfilColaborativo perfilColaborativo) {

        if (perfilColaborativo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        perfilColaborativo.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'perfilColaborativo.label', default: 'PerfilColaborativo'), perfilColaborativo.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'perfilColaborativo.label', default: 'PerfilColaborativo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
