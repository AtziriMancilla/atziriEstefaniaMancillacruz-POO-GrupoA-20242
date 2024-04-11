public class Belleza extends Producto {
        private String marca;
        private double contenidoMl;
        public Belleza(String nombre, double precio, String fechaImportacion, int stock, String marca,double contenidoMl) {
            super(nombre, precio, fechaImportacion, stock);
            this.marca = marca;
            this.contenidoMl=contenidoMl;
        }

        @Override
        public String obtenerInformacion() {
            return super.obtenerInformacion() + ", marca: " + marca+",Contenido ml: "+contenidoMl;
        }

}
