




document.getElementById("api").addEventListener("click", function(event) {
  event.preventDefault();
  let searchTerm = document.getElementById("searchTerm").value;
  axios.get(`http://localhost:8080/api/browser/${searchTerm}`)
  .then(response => {
    document.getElementById("determinado").style.display="none";  
    let responseContainer = document.getElementById("response");
    let peliculas = response.data;
    let resultados = '';
    peliculas.forEach(pelicula => {
      resultados += `
        <div id="diseno-pelicula">
        <!--<p class="estilo">Estado: ${pelicula.estado}</p>-->
        <img id = "miniatura-pelicula"src="${pelicula.url_Imagen}" alt="Image">
        
        <p class="titulo-pelicula">${pelicula.nombre}</p>
        <p class="sipnosis-pelicula">${pelicula.sipnosis}</p>
        
       <!--<p class="estilo">Reparto: ${pelicula.reparto}</p>-->
        <br>
        </div>
      `;
    });
    responseContainer.innerHTML = resultados;

    let randomColor = function () {
      let r = Math.floor(Math.random() * 256);
      let g = Math.floor(Math.random() * 256);
      let b = Math.floor(Math.random() * 256);
      return "rgb(" + r + "," + g + "," + b + ")";
    };

    let images = document.querySelectorAll("#miniatura-pelicula");
    images.forEach(function(image) {
      image.style.boxShadow = "0px 255px 183px 12px " + randomColor();
    });
  })
  .catch(error => {
    console.error('Ha ocurrido un error:', error);
  });

});




















































/*
  document.addEventListener("DOMContentLoaded", function () {
    let randomColor = function () {
      let r = Math.floor(Math.random() * 256);
      let g = Math.floor(Math.random() * 256);
      let b = Math.floor(Math.random() * 256);
      return "rgb(" + r + "," + g + "," + b + ")";
    };
  
    document.getElementById("miniatura-pelicula").style.boxShadow =
      "0 209px 87px 10px " + randomColor();
  });


*/


  


/*document.getElementById("api").addEventListener("click", function(event) {
    event.preventDefault();
    let searchTerm = document.getElementById("searchTerm").value;
    fetch(`http://localhost:8080/api/browser/${searchTerm}`, {mode: 'no-cors'})
      .then(response => response.json())
      .then(data => {
        let responseContainer = document.getElementById("response");
        responseContainer.innerText = JSON.stringify(data);
      })
      .catch(error => {
        console.error('Ha ocurrido un error:', error);
      });
  });
  */
/*
  document.getElementById("api").addEventListener("click", function(event) {
    event.preventDefault();
    let searchTerm = document.getElementById("searchTerm").value;
    axios.get(`http://localhost:8080/api/browser/${searchTerm}`)
      .then(response => {
        let responseContainer = document.getElementById("response");
        responseContainer.innerText = JSON.stringify(response.data);
      })
      .catch(error => {
        console.error('Ha ocurrido un error:', error);
      });
  });

*/








/*
import ColorThief from 'colorthief';

document.addEventListener("DOMContentLoaded", function () {
  let images = document.querySelectorAll("#miniatura-pelicula");
  images.forEach(async (img) => {
    let colorThief = new ColorThief();
    let dominantColor = await colorThief.getColor(img.src);
    img.style.boxShadow = `0 209px 87px 10px rgb(${dominantColor[0]},${dominantColor[1]},${dominantColor[2]})`;
  });
});





  document.getElementById("api").addEventListener("click", function(event) {
    event.preventDefault();
    let searchTerm = document.getElementById("searchTerm").value;
    axios.get(`http://localhost:8080/api/browser/${searchTerm}`)
    .then(response => {
      let responseContainer = document.getElementById("response");
      let peliculas = response.data;
      let resultados = '';
      peliculas.forEach(pelicula => {
        resultados += `
          <div id="diseno-pelicula">
          <!--<p class="estilo">Estado: ${pelicula.estado}</p>-->
          <img id = "miniatura-pelicula"src="${pelicula.url_Imagen}" alt="Image">
          
          <p class="titulo-pelicula">${pelicula.nombre}</p>
          <p class="sipnosis-pelicula">${pelicula.sipnosis}</p>
          
         <!--<p class="estilo">Reparto: ${pelicula.reparto}</p>-->
          <br>
          </div>
        `;
      });
      responseContainer.innerHTML = resultados;
    })
    .catch(error => {
      console.error('Ha ocurrido un error:', error);
    });

  });

*/