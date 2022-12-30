<div class="modal fade" id="agregarProductoModal" tabindex="-1" aria-labelledby="agregarProductoModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-light">
                <h5 class="modal-title">Agregar Producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required/>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="currency" class="form-control" name="precio" required/>
                    </div>
                    <div class="form-group">
                        <label for="cantidad">Cantidad</label>
                        <input type="number" class="form-control" name="cantidad" required/>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripcion</label>
                        <input type="text" class="form-control" name="descripcion" required/>
                    </div>
                    <div class="form-group">
                        <label for="imagen">Imagen</label>
                        <input type="text" class="form-control" name="imagen" required/>
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button class="btn btn-light" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>