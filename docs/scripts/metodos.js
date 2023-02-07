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
          <p>Código: ${pelicula.codigo}</p>
          <p>Nombre: ${pelicula.nombre}</p>
          <p>Sinopsis: ${pelicula.sipnosis}</p>
          <iframe width="560" height="315" src="${pelicula.url_Trailer}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          <!--<p>URL del trailer: ${pelicula.url_Trailer}</p>-->
          <img src="${pelicula.url_Imagen}" alt="Image">
          <!--<p>URL de la imagen: ${pelicula.url_Imagen}</p>-->
          <p>Estado: ${pelicula.estado}</p>
          <p>Reparto: ${pelicula.reparto}</p>
          <br>
        `;
      });
      responseContainer.innerHTML = resultados;
    })
    .catch(error => {
      console.error('Ha ocurrido un error:', error);
    });

  });