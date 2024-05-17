function eliminar(id) {
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: "btn btn-success",
            cancelButton: "btn btn-danger"
        },
        buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
        title: "¿Estás seguro de eliminar este producto?",
        text: "¡No podrás revertir esto!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: "Sí, eliminarlo",
        cancelButtonText: "No, cancelar",
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            // Realizar la eliminación del producto mediante una petición AJAX
            $.ajax({
                url: "/eliminar/" + id,
                success: function (res) {
                    console.log(res);
                    // Mostrar alerta de éxito después de eliminar
                    swalWithBootstrapButtons.fire({
                        title: "¡Eliminado!",
                        text: "El producto ha sido eliminado.",
                        icon: "success"
                    }).then(() => {
                        // Redireccionar a la página de listar después de cerrar la alerta
                        location.href = "/listar";
                    });
                }
            });
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            // Mostrar alerta de cancelación si el usuario decide no eliminar el producto
            swalWithBootstrapButtons.fire({
                title: "Cancelado",
                text: "Tu producto está a salvo :)",
                icon: "error"
            });
        }
    });
}
