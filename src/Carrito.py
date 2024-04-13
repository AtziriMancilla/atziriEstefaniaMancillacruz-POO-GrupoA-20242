class Carrito:
    def __init__(self, producto, cantidad):
        self.__producto = producto
        self.__cantidad = cantidad
        self.comprar(cantidad)

    def get_producto(self):
        return self.__producto

    def subtotal(self):
        return self.__producto.get_precio() * self.__cantidad

    def get_cantidad(self):
        return self.__cantidad

    def comprar(self, cantidad):
        self.__producto.comprar_producto(cantidad)