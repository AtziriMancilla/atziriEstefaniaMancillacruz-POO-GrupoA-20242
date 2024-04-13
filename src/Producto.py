
class Producto:
    CANTIDAD_PRODUCTOS = 0

    def __init__(self, nombre, precio, fecha_importacion, stock):
        self.numero_serie = Producto.CANTIDAD_PRODUCTOS
        Producto.CANTIDAD_PRODUCTOS += 1
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.stock = stock

    def get_precio(self):
        return self.precio

    def get_stock(self):
        return self.stock

    def comprar_producto(self, cant):
        self.stock -= cant

    def obtener_informacion(self):
        return f"Nombre: {self.nombre}, precio: {self.precio}, fecha de importación: {self.fecha_importacion}, stock: {self.stock}"

    def agregar_stock(self, cantidad):
        self.stock += cantidad

    def quitar_de_stock(self, cantidad):
        self.stock -= cantidad