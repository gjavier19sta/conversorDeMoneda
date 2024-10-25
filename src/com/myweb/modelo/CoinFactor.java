package com.myweb.modelo;

// es una Anotación, y es necesaria para la anotacion @SerializedName()
// @SerializedName("USD")
import com.google.gson.annotations.SerializedName;


public class CoinFactor {
//    @SerializedName("USD")
    private float dolar ;
    private float pesoArgentino;
    private float realBrasil;
    private float pesoColombiano;

    public CoinFactor(float dolar, float pesoArgentino, float realBrasil, float pesoColombiano) {
        this.dolar = dolar;
        this.pesoArgentino = pesoArgentino;
        this.realBrasil = realBrasil;
        this.pesoColombiano = pesoColombiano;
    }

    public CoinFactor(CoinFactorExchangerateApi coinFactorExchangerateApi) {
        this.dolar =  Float.parseFloat(coinFactorExchangerateApi.usd());
        this.pesoArgentino = Float.parseFloat(coinFactorExchangerateApi.ars());
        this.realBrasil = Float.parseFloat(coinFactorExchangerateApi.brl());
        this.pesoColombiano = Float.parseFloat(coinFactorExchangerateApi.cop());
    }



    public float getDolar() {
        return dolar;
    }

    public void setDolar(float dolar) {
        this.dolar = dolar;
    }

    public float getPesoArgentino() {
        return pesoArgentino;
    }

    public void setPesoArgentino(float pesoArgentino) {
        this.pesoArgentino = pesoArgentino;
    }

    public float getRealBrasil() {
        return realBrasil;
    }

    public void setRealBrasil(float realBrasil) {
        this.realBrasil = realBrasil;
    }

    public float getPesoColombiano() {
        return pesoColombiano;
    }

    public void setPesoColombiano(float pesoColombiano) {
        this.pesoColombiano = pesoColombiano;
    }

    @Override
    public String toString() {
        return "CoinFactor{" +
                "dolar=" + dolar +
                ", pesoArgentino=" + pesoArgentino +
                ", realBrasil=" + realBrasil +
                ", pesoColombiano=" + pesoColombiano +
                '}';
    }
}

