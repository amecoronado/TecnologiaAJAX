/* 
    Created on : sep-2020
    Author     : ame_coronado
*/


let alumnos = ["Anita","Pedro"];
var mensajeExito = " felicidades, estás inscrito";
var mensajeRechazo = ", aún no estás inscrito";
var mensajeError= "Los campos no pueden quedar vacíos";
var inscritos = 0;



function checarRegistro(){
    let nuevoNombre = document.getElementsByName('nombre')[0].value;
    var mostrarInscritos= true;
    if(nuevoNombre == "")
        alert(mensajeError);
    else{
        if(alumnos.includes(nuevoNombre))
            alert(nuevoNombre+ mensajeExito);
        else
            alert(nuevoNombre+ mensajeRechazo); 
        while(mostrarInscritos) {
            alert("Hay "+ inscritos+ " inscritos");
            mostrarInscritos=false;
        }
    }
        
    
};

for(var inscritos in alumnos){
        inscritos ++;
    }
    





    




