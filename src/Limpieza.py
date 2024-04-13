
from Producto import Producto

class Limpieza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, marca):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.__marca = marca

    def obtener_informacion(self):
        return f"{super().obtener_informacion()}, marca: {self.__marca}"