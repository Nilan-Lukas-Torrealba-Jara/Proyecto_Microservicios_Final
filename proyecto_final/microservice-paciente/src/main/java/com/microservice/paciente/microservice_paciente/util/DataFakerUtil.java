
package com.microservice.paciente.microservice_paciente.util;

import com.microservice.paciente.microservice_paciente.model.Paciente;
import net.datafaker.Faker;

public class DataFakerUtil {

    private static final Faker faker = new Faker();

    public static Paciente generarPacienteFalso() {
        return new Paciente(
            null,
            faker.name().firstName(),
            faker.name().lastName(),
            faker.idNumber().valid()
        );
    }
}
