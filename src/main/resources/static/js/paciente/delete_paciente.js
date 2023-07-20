function deleteBy(id)
    {
           //con fetch invocamos a la API de estudiantes con el método DELETE
           //pasandole el id en la URL
          const url = '/pacientes/'+ id;
          const settings = {
              method: 'DELETE'
          }
//          fetch(url,settings)
//          .then(response => response.json())
            fetch(url, settings)
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error("Error al eliminar el paciente");
                    }
                })
                .then(data => {
                    // Manejar la respuesta JSON aquí
                    console.log(data.message); // Imprimir el mensaje de éxito
                    // O realizar otras acciones según sea necesario
                })
                .catch(error => {
                    console.error(error);
                    // Manejar errores de la petición
                });


          //borrar la fila del estudiante eliminado
          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();

}