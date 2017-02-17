<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'participante.label', default: 'Participante')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-participante" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link action="showDatos" params="${params}">Ver datos personales</g:link></li>
            </ul>
        </div>
        <div id="show-participante" class="content scaffold-show" role="main">
            <h1>${participante.datosPersonales.nombre}</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <ul>
                <li><g:link action="showPerfil" params="${params}">Ver perfil colaborativo</g:link></li>
                <li><g:link action="showDatos" params="${params}">Ver datos personales</g:link></li>
                <li><g:link action="createDoc" params="${params}">Subir un documento</g:link></li>
                <li><g:link action="listDocs" params="${params}">Ver Lista de documentos</g:link></li>
                <li><g:link action="searchDocs" params="${params}">Buscar documentos</g:link></li>
            </ul>
        </div>
    </body>
</html>
