from Producto import Producto


class Alimento(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, fecha_caducidad):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.fecha_caducidad = fecha_caducidad

    def obtener_datos_alimento(self):
        return f"{super().obtener_informacion()}, fecha de caducidad: {self.fecha_caducidad}"
