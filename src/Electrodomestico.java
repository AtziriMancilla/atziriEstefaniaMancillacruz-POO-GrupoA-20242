public class Electrodomestico extends Producto {
        private String marca;
        private double voltaje;
        public Electrodomestico(String nombre, double precio, String fechaImportacion, int stock, String marca,double voltaje) {
            super(nombre, precio, fechaImportacion, stock);
            this.marca = marca;
            this.voltaje=voltaje;
        }

        @Override
        public String obtenerInformacion() {
            return super.obtenerInformacion() + ", marca:" + marca+ ", voltaje:"+voltaje;
        }
}
