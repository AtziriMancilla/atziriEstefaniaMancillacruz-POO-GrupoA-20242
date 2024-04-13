from datetime import date

class Compra:
    def __init__(self, cliente, productos, fecha_compra):
        self.cliente = cliente
        self.productos = productos
        self.fecha_compra = fecha_compra

    def get_cliente(self):
        return self.cliente

    def get_fecha_compra(self):
        return self.fecha_compra

    def get_productos(self):
        return self.productos

    def mostrar_productos(self):
        print("\tCant\tProducto")
        for carrito in self.productos:
            print("\t{}\t{}".format(carrito.get_cantidad(), carrito.get_producto().obtener_informacion()))

    def total_compra(self):
        total = 0
        for carrito in self.productos:
            total += carrito.subtotal()
        return total

    def mostrar_compra(self):
        print("Cliente: " + self.cliente.mostrar_info_con_fecha())
        print("Fecha de compra: " + str(self.fecha_compra))
        self.mostrar_productos()
        print("Total: " + str(self.total_compra()))