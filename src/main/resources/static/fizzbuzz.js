window.addEventListener('load' , function (e){
    var fizzbuzzblock = document.getElementById('updateBlock'); //récup en variable de l'élément (fragment de thymeleaf)
    var eventSource = new EventSource('http://localhost:8080/fizzbuzz-stream'); // recup de la source du flux
    eventSource.addEventListener('message' , function (update){
        fizzbuzzblock.innerHTML = update.data;
    });
})