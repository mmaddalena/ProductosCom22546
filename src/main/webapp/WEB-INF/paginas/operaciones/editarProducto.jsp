<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/68e677f6ef.js" crossorigin="anonymous"></script>
        <title>Editar Producto</title>
    </head>
    <body>
        <jsp:include page="../comunes/cabecera.jsp"/>

        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idProducto=${producto.idproducto}" method="POST" class="was-validated">
            <jsp:include page="../comunes/botonesNavegacionEditar.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Modificar Producto</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" value="${producto.nombre}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Precio</label>
                                        <input type="currency" class="form-control" name="precio" value="${producto.precio}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="cantidad">Cantidad</label>
                                        <input type="number" class="form-control" name="cantidad" value="${producto.cantidad}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="descripcion">Descripcion</label>
                                        <input type="text" class="form-control" name="descripcion" value="${producto.descripcion}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="imagen">Imagen</label>
                                        <input type="text" class="form-control" name="imagen" value="${producto.imagen}" required/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <jsp:include page="../comunes/pieDePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
