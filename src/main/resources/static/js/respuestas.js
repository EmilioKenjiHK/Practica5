const perro = document.getElementById("perro");

const getData = async() => {
    let request = await fetch("/cuestionario");

    //Caso de exito
    if(request.status == 200) {
        const div = document.getElementById("respuestas");
        const fin = document.getElementById("final");
        let dato = await request.json();
        for(i = 0; i<dato.length; i++)
        {
            const para = document.createElement("pre");
            para.className = "opinion";

            const name = document.createTextNode("Nombre: " + dato[i].name + "\n");
            const lname = document.createTextNode("Apellido: " + dato[i].lname + "\n");
            const gender = document.createTextNode("Sexo: " + dato[i].genero + "\n");
            const opinion = document.createTextNode("Opinion: " + dato[i].opinion);

            para.appendChild(name);
            para.appendChild(lname);
            para.appendChild(gender);
            para.appendChild(opinion);

            div.insertBefore(para,fin);
        }
    }
}

const getPic = async() => {
    let peticion = await fetch("/dogs",
    {    method: "GET",
    });

    let error = "Error de peticion"; // Si no se ha cargado bien la imagen

    if(peticion.status === 200)
    {
        let info = await peticion.json();
        if(info.status === "success")
        {
            imagen = info.message;
        }
    }
    else{
        imagen = error;
    }
};

const setPic = async () => {
    const img = document.createAttribute("src");

    await getPic();
    //console.log(imagen);
    img.value = imagen; 
    perro.setAttributeNode(img);
};

$(document).ready(() => {
    getData();
    setPic();
})