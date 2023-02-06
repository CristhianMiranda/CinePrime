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

  document.getElementById("api").addEventListener("click", function(event) {
    event.preventDefault();
    let searchTerm = document.getElementById("searchTerm").value;
    axios.get(`http://localhost:8080/api/browser/${searchTerm}`, {mode: 'no-cors'})
      .then(response => {
        let responseContainer = document.getElementById("response");
        responseContainer.innerText = JSON.stringify(response.data);
      })
      .catch(error => {
        console.error('Ha ocurrido un error:', error);
      });
  });
