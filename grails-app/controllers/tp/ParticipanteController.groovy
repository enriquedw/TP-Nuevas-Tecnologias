package tp

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ParticipanteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Participante.list(params), model:[participanteCount: Participante.count()]
    }

    def show(Participante participante) {
        respond participante
    }
    

    def create() {      
        respond new Participante()
    }

    @Transactional
    def save(Participante participante) {

        participante = new Participante(new DatosPersonales(params))

        if (participante == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (participante.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond participante.errors, view:'create'
            return
        }

        
        participante.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'participante.label', default: 'Participante'), participante.id])
                redirect participante
            }
            '*' { respond participante, [status: CREATED] }
        }
    }

    def edit(Participante participante) {
        respond participante
    }

    @Transactional
    def update(Participante participante) {
        if (participante == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (participante.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond participante.errors, view:'edit'
            return
        }

        participante.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'participante.label', default: 'Participante'), participante.id])
                redirect participante
            }
            '*'{ respond participante, [status: OK] }
        }
    }

    @Transactional
    def delete(Participante participante) {

        if (participante == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        participante.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'participante.label', default: 'Participante'), participante.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'participante.label', default: 'Participante'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
