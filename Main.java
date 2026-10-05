import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
//capturar directorios del sistema
        String SistemaOperativo=System.getProperty("os.name");
        String Comando="";
        //pantalla
        System.out.println("Sistema operativo: "+SistemaOperativo);

        if (SistemaOperativo=="Windows") {
            Comando="cmd /c dir";

        }

        else{
            Comando="sh -c ls";
        }


        try {
            String[] partes = Comando.split("\\s");
            ProcessBuilder processBuilder = new ProcessBuilder(partes);

            if (SistemaOperativo=="Windows"){
                processBuilder.directory(new File("c:/temp"));
            }

            else {
                processBuilder.directory(new File("/tmp"));
            }
        Process process = processBuilder.start();
            BufferedReader reader= new BufferedReader(new InputStreamReader(process.getInputStream()));
            reader.lines().forEach(System.out::println);
        }

        //Stream del proceso

        catch (Exception e){
            e.printStackTrace();
        }
    }
}

