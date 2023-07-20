window.addEventListener('load', function () {

    (function(){
      //con fetch invocamos a la API de estudiantes con el método GET
      //nos devolverá un JSON con una colección de estudiantes
      const url = '/turnos';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         //recorremos la colección de estudiantes del JSON
         for(turno of data){
          //por cada turno armaremos una fila de la tabla
          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos
          //el turno

          var table = document.getElementById("turnoTable");
          var turnoRow =table.insertRow();
          let tr_id = 'tr_' + turno.id;
          turnoRow.id = tr_id;


                     const fechaHora = turno.date.split("T");
                     const fecha = fechaHora[0];
                     const horaCompleta = fechaHora[1];
                     const horaMinutos = horaCompleta.substring(0, 5); // Obtener solo los primeros 5 caracteres (HH:MM)


                     console.log(fecha); // Resultado: la parte de la fecha recibida
                     console.log(hora); // Resultado: la parte de la hora recibida


          //por cada estudiante creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar al estudiante
           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                                      ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-outline-danger">' +
                                      '&times' +
                                      '</button>';

           //por cada estudiante creamos un boton que muestra el id y que al hacerle clic invocará
           //a la función de java script findBy que se encargará de buscar al estudiante que queremos
           //modificar y mostrar los datos del mismo en un formulario.
          let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                      ' type="button" onclick="findBy('+turno.id+')" class="btn btn-outline-secondary">' +
                                      turno.id +
                                      '</button>';


          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del estudiante
          //como ultima columna el boton eliminar
         turnoRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_paciente_id\">' + turno.paciente.id + '</td>' +
                              '<td class=\"td_odontologo_id\">' + turno.odontologo.id + '</td>' +
                              '<td class=\"td_fecha\">' + fecha + '</td>' +
                              '<td class=\"td_fecha_hora\">' + horaMinutos + '</td>' +
                              '<td>' + deleteButton + '</td>';

        }}

)
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/turnos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})