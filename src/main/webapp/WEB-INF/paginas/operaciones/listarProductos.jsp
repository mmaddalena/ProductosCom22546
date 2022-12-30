<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="productos">
    <div class="container">
        <div class="row row-cols-1 row-cols-md-3 g-4 mb-4">
            <c:forEach var="producto" items="${productos}">
                <div class="col">
                    <div class="card h-100">
                        <img src="${producto.imagen}" class="card-img-top" alt="Imagen de Producto" style="height: 20rem;">
                        <div class="card-body">
                            <h5 class="card-title border-bottom border-top border-dark p-4 text-center">${producto.nombre}</h5>
                            <p class="card-text text-center fw-light fs-5">${producto.descripcion}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item fs-4 text-center">
                                <i class="fa-light fa-dollar-sign text-center"></i> ${producto.precio}<br>
                            </li>
                            <li class="list-group-item text-center fw-semibold border-dark p-4">
                                Unidades Disponibles: ${producto.cantidad}<br>
                            </li>
                        </ul>
                            
                        <div class="card-footer bg-light text-center">
                            <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idProducto=${producto.idproducto}">
                                <button type="button" class="btn btn-light rounded-circle"><i class="fa-solid fa-pen"></i></button>  
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach> 
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarProducto.jsp"/>