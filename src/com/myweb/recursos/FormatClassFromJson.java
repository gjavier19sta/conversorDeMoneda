package com.myweb.recursos;
//import gson;

import com.google.gson.*;
import com.myweb.modelo.CoinFactorExchangerateApi;
import com.myweb.modelo.ExchangeRates;

public class FormatClassFromJson {

    public static CoinFactorExchangerateApi obtenerValoresDelJson (String gjsonString ) {
/*      Un JsonObject es una clase de la biblioteca Gson que representa un objeto JSON como
        una estructura en la que puedes acceder y manipular datos específicos por sus claves.
        Cuando trabajas con JSON en Gson, un JsonObject es útil para manipular el JSON en un
        formato de "árbol", lo que significa que puedes acceder a nodos específicos del JSON
        (como un objeto o un valor específico) antes de deserializar completamente el JSON a
        una clase. Esto es especialmente útil cuando quieres trabajar con una parte específica
        de un JSON complejo sin necesidad de deserializarlo todo.*/
        JsonObject jsonObject = JsonParser.parseString(gjsonString).getAsJsonObject();
        JsonObject convRate = jsonObject.getAsJsonObject("conversion_rates");
        // ahora convRate contiene solo el nuevo json que solo contiene los conversion_rates
        // que no tiene ramificaciones
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES).create();
        // Con la linea anterior le decimos que los argumentos van estar en mayusculas para que pueda convertirolos
        // a los variables de ConiFactorExchangerateApi que en la clase enstan en minusculas.
        return gson.fromJson(convRate, CoinFactorExchangerateApi.class);
    }




}
