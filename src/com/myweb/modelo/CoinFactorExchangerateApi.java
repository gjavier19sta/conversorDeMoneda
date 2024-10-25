/*
* DTO son las siglas de data transfer Object, y lo idea es tener un objeto intermedíario para realizar
* la conversion del json a la clase, para que este sea el encargado de convertir el json en clase
* si es que al usar otra api, camibar los nombres por ejemplo de las monedas. para dejar mas claro.
* en la Api que estamos usando el dolar lo devuelve como USD, pero podríamos usar otra que devolviera
* U$D y entonces ya no podría armar la clase. y para solucionar esto sin tener que modificar
* el codigo completo, uso este objeto itnermedio.
*
* Un record es similar a una clase, solo que es mucho más simple y está hecho con el objetivo
* de poder almacenar datos y ver esos datos de manera rápida. Además, por ejemplo, tiene los
* getters y setters ya incluidos en ese record y tiene un toString específico para este record
* que vamos a crear. Entonces, tiene varias ventajas cuando queremos usar una estructura solo
* para guardar información y obtener información de allí.
*
* Sería similiar a crear una clase que solo tenga variables sus getter y setters, y ademas
* el metodo toString() y el metodo equals() y que no se pueda modificar una vez creada.
* entonces esta clase se reemplaza directamente creando un record donde se agregan las variables
* y nada mas. intermamente java ya hace lo demas. entonces es mas simple de leer.
*
* de esta forma es como que hacemos una nueva clase que solo maneja los datos de la api
* ExchangerateApi
*
* */
package com.myweb.modelo;

/* No lo voy a usar pero así me queda el concepto guardado*/
public record CoinFactorExchangerateApi(String usd, String ars, String brl, String cop) {
}
