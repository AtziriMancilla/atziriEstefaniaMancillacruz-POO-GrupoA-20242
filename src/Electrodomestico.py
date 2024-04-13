
from Producto import Producto
class Electrodomestico(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, marca, voltaje):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.__marca = marca
        self.__voltaje = voltaje

    def obtener_informacion(self):
        return f"{super().obtener_informacion()}, marca: {self.__marca}, voltaje: {self.__voltaje}"
