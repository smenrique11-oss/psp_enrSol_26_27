package impresoras;

public class impresora implements Runnable{

    private int numeroPaginas;
    private String nombre;

    public impresora(int numeroPaginas, String nombre) {
        this.numeroPaginas = numeroPaginas;
        this.nombre = nombre;
    }

    @Override
    public void run() {

        for (int i=0; i<numeroPaginas; i++){
            System.out.println("Impresora "+nombre+ " Pagina "+ i +" de " +numeroPaginas);

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("finalizado el conteo de la impresora "+nombre);

    }
}
