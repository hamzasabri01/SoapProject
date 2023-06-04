package com.example.soapapp;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class CountryInfoService {

    private static final String NAMESPACE = "http://www.oorsprong.org/websamples.countryinfo";
    private static final String URL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
    private static final String METHOD_NAME = "CapitalCity";

    public static String getCapitalCity(String countryCode) throws IOException {
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("sCountryISOCode", countryCode);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = true;

        HttpTransportSE transport = new HttpTransportSE(URL);
        transport.call("", envelope);

        if (envelope.getResponse() != null) {
            return envelope.getResponse().toString();
        } else {
            throw new IOException("No response from server");
        }
    }
}

