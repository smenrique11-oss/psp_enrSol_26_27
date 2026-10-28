package impresoras;

public  class mainImpresora {
    public static void main(String[] args){



        //Lanzar varios hilos
        //for (int i=0;i<5;i++){
        //  new Thread(myRunnable).start();
        //}

        //Creo 2 objetos cuentaAtras
        Thread impresora01=new Thread(new impresora(3,"nokia"));
        Thread impresora02=new Thread(new impresora(5,"hp"));
        Thread impresora03=new Thread(new impresora(4,"de alex"));

        //Lanzo hilos
        impresora01.start();
        impresora02.start();
        impresora03.start();

    }
}