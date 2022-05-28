const url = "https://rickandmortyapi.com/api/character";
        const data = fetch(url)
            .then(response => response.json())
            .then(data => showData(data.results))
            .catch(error => console.log(error));


        const statusColor = (status) => {
            const x = {
                "Alive": "success",
                "Dead": "danger",
                "unknown": "warning",
            }

            return `badge-${x[status]}`;
        }

        const showData = (data) => {

            const elementHtml = document.getElementById('tbody');

            data.forEach(it => {
                elementHtml.innerHTML += `
                    <tr>
                        <td>
                            <div class="d-flex align-items-center">
                                <img src="${it.image}" alt="${it.name}"
                                    style="width: 45px; height: 45px" class="rounded-circle" />
                                <div class="ms-3">
                                    <p class="fw-bold mb-1">${it.name}</p>
                                    <p class="text-muted mb-0">ID: ${it.id}</p>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="fw-normal mb-1">${it.species}</p>
                            <p class="text-muted mb-0">${it.gender}</p>
                        </td>
                
                        <td>
                            <span class="badge ${statusColor(it.status)} rounded-pill d-inline">${it.status}</span>
                        </td>
                        <td>${it.origin.name}</td>
                    </tr>
                `;
            });
        }
/* Inputs */

const nombreInput = document.querySelector('#nombre_cliente'); //Convertir variables desde el index
const apellidoInput = document.querySelector('#apellido_cliente');
const emailInput = document.querySelector('#email_cliente');
const telefonoInput = document.querySelector('#telefono_cliente');
/*const url = 'localhost:8070/clientes/';


async function client(e) {
    
    const userData = {
        "telefono_cliente": telefonoInput.value,
        "nombre_cliente": nombreInput.value,
        "apellido_cliente": apellidoInput.value,
        "email_cliente": emailInput.value
    };

    try {
        const token = "dkjsfjasdkl";
        const { data } = await axios.post(`http://localhost:8070/clientes/`, userData);
        
        if (data) {
            alert('El cliente se subió a la base de datos correctamente');
        }
        
    } catch (error) {
        alert('Hubo un error');
    }

}*/