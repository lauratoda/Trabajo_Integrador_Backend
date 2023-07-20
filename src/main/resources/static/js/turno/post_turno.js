window.addEventListener('load', function () {

     //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
     //los datos que el usuario cargará del nuevo estudiante
    const formulario = document.querySelector('#add_new_turno');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {

        //creamos un JSON que tendrá los datos del nuevo estudiante

        // Formatea la fecha y hora en el formato esperado por tu API
        const fecha = document.querySelector('#fecha').value;
        const hora = document.querySelector('#hora').value;

        // Formatea la fecha y hora en el formato esperado por tu API
//        const formattedDateTime = fecha.replace(/\/g, '-') + 'T' + hora + ':00';
        const formattedDateTime = fecha + 'T' + hora + ':00';


        const formData = {
          paciente: {
            id: document.querySelector('#paciente_id').value
          },
          odontologo: {
            id: document.querySelector('#odontologo_id').value
          },
          date: formattedDateTime
        };

//        const formData = {
//            paciente_id: document.querySelector('#paciente_id').value,
//            odontologo_id: document.querySelector('#odontologo_id').value,
//            date: (document.querySelector('#fecha').value) + "T" + (document.querySelector('#hora').value)
//        };

        //invocamos utilizando la función fetch la API estudiantes con el método POST
        //que guardará al estudiante que enviaremos en formato JSON
        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> turno agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 //se dejan todos los campos vacíos por si se quiere ingresar otro estudiante
                 resetUploadForm();

            })
            .catch(error => {
                 //Si hay algun error se muestra un mensaje diciendo que el estudiante
                 //no se pudo guardar y se intente nuevamente
                  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                   document.querySelector('#response').innerHTML = errorAlert;
                   document.querySelector('#response').style.display = "block";
                   //se dejan todos los campos vacíos por si se quiere ingresar otro estudiante
                   resetUploadForm();})
    });

    function resetUploadForm(){
        document.querySelector('#paciente_id').value = "";
        document.querySelector('#odontologo_id').value = "";
        document.querySelector('#fecha').value = "";
        document.querySelector('#hora').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/turnos.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});