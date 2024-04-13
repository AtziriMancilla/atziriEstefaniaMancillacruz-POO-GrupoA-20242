from Producto import Producto

class Belleza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, marca, contenido_ml):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.marca = marca
        self.contenido_ml = contenido_ml

    def obtener_informacion(self):
        return f"{super().obtener_informacion()}, marca: {self.marca}, Contenido ml: {self.contenido_ml}"
