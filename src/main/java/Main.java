import domain.entities.Vehiculo;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Si tienes un array de "n" vehículos, cómo haces para arrancarlos todos. Usando reflexión.

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.print("Ingrese el número de objetos creados en tiempo de ejecución: ");
        int numberOfObjects = System.in.read();

        final String className = "domain.entities.Vehiculo";

        try {
            List<Object> vehiculos = new ArrayList<>();
            Binding binding = new Binding();
            List<String> groovyCode = new ArrayList<>();


            //Refleccion
            Class<?> vehiculoClass = Class.forName(className);
            Constructor<?> constructor = vehiculoClass.getConstructor();
            Method encenderMethod = vehiculoClass.getDeclaredMethod("encender");

            for (int i = 0; i < numberOfObjects; i++) {
                Object vehiculo = constructor.newInstance();
                vehiculos.add(vehiculo);
                binding.setVariable("vehiculo" + i, vehiculo);
                groovyCode.add("""
                        def output = 'marca' + vehiculo.getMarca() '\\n'\n
                        """);
//                groovyCode.add("def output = ''\n" +
//                        "output += 'Marca: ' + vehiculo.getMarca + '\\n'\n" +
//                        "output += 'Modelo: ' + vehiculo.getModelo + '\\n'\n" +
//                        "output += 'Galones: ' + vehiculo.getGalonesGasolina + '\\n'\n" +
//                        "output '\\n'\n");
            }

//            for (Object vehiculo : vehiculos) {
//                encenderMethod.invoke(vehiculo);
//            }

            //Ejecucion de Groovy
            GroovyShell shell = new GroovyShell(binding);
            List<String> outputs = new ArrayList<>();

            for(String code : groovyCode) {
                outputs.add(shell.evaluate(code).toString());
            }

            System.out.println("Respuesta del motor de ejecución de Groovy:");
            outputs.forEach(System.out::println);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}