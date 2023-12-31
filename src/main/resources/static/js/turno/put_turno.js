window.addEventListener('load', function () {

    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del estudiante
    const formulario = document.querySelector('#update_turno_form');
    formulario.addEventListener('submit', function (event) {
        let turnoId = document.querySelector('#turno_id').value;

        //creamos un JSON que tendrá los datos del estudiante
        //a diferencia de un estudiante nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo

        const fecha = document.querySelector('#fecha').value;
        const hora = document.querySelector('#hora').value;

        // Formatea la fecha y hora en el formato esperado por tu API
        const formattedDateTime = fecha + 'T' + hora + ':00';

        const formData = {
             id: document.querySelector('#turno_id').value,
             paciente: {
                id: document.querySelector('#paciente_id').value
             },
             odontologo: {
                id: document.querySelector('#odontologo_id').value
             },
             date: formattedDateTime
//           date: document.querySelector('#fecha').value + 'T' + document.querySelector('#hora').value
             };


        //invocamos utilizando la función fetch la API estudiantes con el método PUT
        //que modificará al estudiante que enviaremos en formato JSON
        const url = '/turnos/actualizar';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de un estudiante del listado
    //se encarga de llenar el formulario con los datos del estudiante
    //que se desea modificar
    function findBy(id) {
          const url = '/turnos/'+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
          console.log(data);
              let turno = data;
              const fechaHora = turno.date.split("T");
              const fecha = fechaHora[0];
              const horaCompleta = fechaHora[1];
              const horaMinutos = horaCompleta.substring(0, 5);

              document.querySelector('#turno_id').value = turno.id;
              document.querySelector('#paciente_id').value = turno.paciente.id;
              document.querySelector('#odontologo_id').value = turno.odontologo.id;
              document.querySelector('#fecha').value = fecha;
              document.querySelector('#hora').value = horaMinutos;

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_turno_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }