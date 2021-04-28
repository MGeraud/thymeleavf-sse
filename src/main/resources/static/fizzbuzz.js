window.addEventListener('load' , function (e){
    var fizzbuzzblock = document.getElementById('updateBlock'); //récup en variable de l'élément (fragment de thymeleaf)
    var eventSource = new EventSource('https://fuzzbizz.herokuapp.com/fizzbuzz-stream'); // recup de la source du flux
    eventSource.addEventListener('message' , function (update){
        fizzbuzzblock.innerHTML = update.data;
    });
})