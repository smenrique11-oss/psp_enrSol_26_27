package estadosDeUnProceso;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class estadosDeUnProceso {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("ping", "localhost");
        Process procesoPing = null;

        try {

            // inicio el rpoceso
            procesoPing=processBuilder.start();


            //PID y ver si el proceso esta vivo nada mas iniciarlo
            System.out.println("El proceso esta vivo?: "+procesoPing.isAlive());
            System.out.println("PID del proceso: "+procesoPing.pid());

            //ProcessHandle.Info para consultar los metadatos
            ProcessHandle.Info informacionProceso=procesoPing.info();

            System.out.println("Coamndo: "+informacionProceso.command().orElse("No disponible"));
            System.out.println("Argumentos: " + (informacionProceso.arguments().isPresent() ? Arrays.toString(informacionProceso.arguments().get()) : "No disponibles"));
            System.out.println("Usuario: " + informacionProceso.user().orElse("No disponible"));

            //capturar el resultado y mostrarlo por pantalla
            BufferedReader lectorSalidaEstandar=new BufferedReader(new InputStreamReader(procesoPing.getInputStream()));
            BufferedReader lectorSalidaError=new BufferedReader(new InputStreamReader(procesoPing.getErrorStream()));


            //mostrar resultados
            System.out.println("SALIDA ESTANDAR:");
            lectorSalidaEstandar.lines().forEach(System.out::println);
            //resultado con error
            System.out.println("SALIDA CON ERROR:");
            lectorSalidaError.lines().forEach(System.out::println);

            int codigoSalida= procesoPing.waitFor();

            System.out.println("ESTADO TRAS FINALIZAR:");
            System.out.println(codigoSalida);

            System.out.println("CONTINUA VIVO EL PROCESO?:"+procesoPing.isAlive());
            //control de errores
        } catch (IOException e) {
            System.out.println("Error de salida al leer o iniciar el proceso: "+e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Error de salida al leer o iniciar el proceso: "+e.getMessage());
            e.printStackTrace();
        }

    }
}