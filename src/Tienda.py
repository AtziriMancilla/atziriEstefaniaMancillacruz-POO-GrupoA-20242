from datetime import date
from Alimento import Alimento
from Belleza import Belleza
from Carrito import Carrito
from Cliente import Cliente
from Compra import Compra
from Electrodomestico import Electrodomestico
from Limpieza import Limpieza

class Tienda:
    def __init__(self):
        self.__productos_limpieza = []
        self.__productos_alimento = []
        self.__productos_electrodomestico = []
        self.__productos_belleza = []
        self.__compras = []
        self.__clientes = []

    def __registrar_datos_comun(self):
        datos_comun = []
        nombre = input("Ingresa el nombre: ")
        datos_comun.append(nombre)
        precio = float(input("Ingresa el precio: "))
        datos_comun.append(str(precio))
        fecha_importacion = input("Ingresa la fecha de importación (YYYY-MM-DD): ")
        datos_comun.append(fecha_importacion)
        stock = int(input("Ingresa el stock: "))
        datos_comun.append(str(stock))
        return datos_comun
    
    def registrar_producto_limpieza(self):
        print("\n** Registro Producto Limpieza **")
        datos = self.__registrar_datos_comun()
        nombre = datos[0]
        precio = float(datos[1])
        fecha_importacion = datos[2]
        stock = int(datos[3])
        marca = input("Ingresa la marca: ")
        limpieza = Limpieza(nombre, precio, fecha_importacion, stock, marca)
        self.__productos_limpieza.append(limpieza)
        print("\nProducto Registrado")
        
    def registrar_producto_alimento(self):
        print("\n** Registro Producto Alimento **")

        datos = self.__registrar_datos_comun()
        nombre = datos[0]
        precio = float(datos[1])
        fecha_importacion = datos[2]
        stock = int(datos[3])
        fecha_caducidad = input("Ingresa la fecha de caducidad (YYYY-MM-DD): ")
        alimento = Alimento(nombre, precio, fecha_importacion, stock, fecha_caducidad)
        self.__productos_alimento.append(alimento)
        print("\nProducto Registrado")
        
    def registrar_producto_belleza(self):
        print("\n** Registro Producto Belleza **")
        datos = self.__registrar_datos_comun()
        nombre = datos[0]
        precio = float(datos[1])
        fecha_importacion = datos[2]
        stock = int(datos[3])
        marca = input("Ingresa la marca: ")
        contenido_ml = float(input("Ingresa el total de ml: "))
        belleza = Belleza(nombre, precio, fecha_importacion, stock, marca, contenido_ml)
        self.__productos_belleza.append(belleza)
        print("\nProducto Registrado")
        
    def registrar_producto_electrodomestico(self):
        print("\n** Registro Producto Electrodomestico **")
        datos = self.__registrar_datos_comun()
        nombre = datos[0]
        precio = float(datos[1])
        fecha_importacion = datos[2]
        stock = int(datos[3])
        marca = input("Ingresa la marca: ")
        voltaje = float(input("Ingresa el voltaje: "))
        electrodomestico = Electrodomestico(nombre, precio, fecha_importacion, stock, marca, voltaje)
        self.__productos_electrodomestico.append(electrodomestico)
        print("\nProducto Registrado")
    def registrar_cliente(self):
        print("\n** Registro Cliente **")
        nombre = input("Ingrese el nombre:")
        apellido = input("Ingrese el apellido:")
        direccion = input("Ingrese la dirección:")
        fecha_registro = date.today()
        self.__clientes.append(Cliente(nombre, apellido, direccion, fecha_registro))

    def mostrar_productos(self):
        print("** Lista de productos **")
        print("Productos limpieza:")
        self.__mostrar_limpieza()
        print("Alimentos:")
        self.__mostrar_alimentos()
        print("Productos belleza:")
        self.__mostrar_belleza()
        print("Electrodomésticos:")
        self.__mostrar_electrodomesticos()
        
    def __mostrar_alimentos(self):
        if not self.__productos_alimento:
            print("No hay alimentos")
        else:
            i = 1
            for alimento in self.__productos_alimento:
                print(f"{i}) {alimento.obtener_datos_alimento()}")
                i += 1

    def __mostrar_belleza(self):
        if not self.__productos_belleza:
            print("No hay productos de belleza")
        else:
            i = 1
            for belleza in self.__productos_belleza:
                print(f"{i}) {belleza.obtener_informacion()}")
                i += 1
                
    def __mostrar_electrodomesticos(self):
        if not self.__productos_electrodomestico:
            print("No hay alimentos")
        else:
            i = 1
            for electrodomestico in self.__productos_electrodomestico:
                print(f"{i}) {electrodomestico.obtener_informacion()}")
                i += 1

    def __mostrar_limpieza(self):
        if not self.__productos_limpieza:
            print("No hay productos de belleza")
        else:
            i = 1
            for limpieza in self.__productos_limpieza:
                print(f"{i}) {limpieza.obtener_informacion()}")
                i += 1
    def mostrar_clientes(self):
        if not self.__clientes:
            print("No hay clientes registrados")
        else:
            i = 1
            for cliente in self.__clientes:
                print(f"{i}) {cliente.mostrar_info_con_fecha()}")
                i += 1
    def eliminar_producto(self):
        print("**Eliminar producto**")
        opcion=int(input("1)Alimento\n2)Limpieza\n3)Belleza\n4)Electrodomestico"))
        if opcion==1:
            self.__mostrar_alimentos()
            opcion=int(input("Seleccione el alimento que desea eliminar: "))
            band=False
            for i in range(len(self.__compras)):
                for j in range(len(self.__compras[i].get_productos())):
                    if(self.__compras[i].get_productos()[j].get_producto()==self.__productos_alimento[opcion-1]):
                        band=True
                        break
            if band:
                print("No se puede Eliminar este producto")
            else:
                self.__productos_alimento.pop(opcion-1)
                print("Producto eliminado")
        elif opcion==2:
            self.__mostrar_limpieza()
            opcion=int(input("Seleccione el producto de limpieza que desea eliminar: "))
            band=False
            for i in range(len(self.__compras)):
                for j in range(len(self.__compras[i].get_productos())):
                    if(self.__compras[i].get_productos()[j].get_producto()==self.__productos_limpieza[opcion-1]):
                        band=True
                        break
            if band:
                print("No se puede Eliminar este producto")
            else:
                self.__productos_limpieza.pop(opcion-1)
                print("Producto eliminado")
        elif opcion==3:
            self.__mostrar_belleza()
            opcion=int(input("Seleccione el producto de belleza que desea eliminar: "))
            band=False
            for i in range(len(self.__compras)):
                for j in range(len(self.__compras[i].get_productos())):
                    if(self.__compras[i].get_productos()[j].get_producto()==self.__productos_belleza[opcion-1]):
                        band=True
                        break
            if band:
                print("No se puede Eliminar este producto")
            else:
                self.__productos_belleza.pop(opcion-1)
                print("Producto eliminado")
        elif opcion==4:
            self.__mostrar_electrodomesticos()
            opcion=int(input("Seleccione el electrodomestico que desea eliminar: "))
            band=False
            for i in range(len(self.__compras)):
                for j in range(len(self.__compras[i].get_productos())):
                    if(self.__compras[i].get_productos()[j].get_producto()==self.__productos_electrodomestico[opcion-1]):
                        band=True
                        break
            if band:
                print("No se puede Eliminar este producto")
            else:
                self.__productos_electrodomestico.pop(opcion-1)
                print("Producto eliminado")
                
    def eliminar_cliente(self):
        print("**Eliminar cliente**")
        self.mostrar_clientes()
        opcion=int(input("Seleccione una opcion"))
        band=False
        for compra in self.__compras:
            if(compra.get_cliente()==self.__clientes[opcion-1]):
                band=True
                break
        if band:
            print("No se puede eliminar este cliente")
        else:
            self.__clientes.pop(opcion-1)
            print("Cliente eliminado")
            
    def realizar_compra(self):
        print("**Realizar compra**")
        self.mostrar_clientes()
        opcion=int(input("Seleccione el cliente"))
        cliente=self.__clientes[opcion-1]
        band=True
        productos = []
        cantidad = 0
        while band:
            opcion=int(input("1)Alimentos\n2)Limpieza\n3)Belleza\n4)Electrodomesticos\n5)Salir"))
            if opcion == 1:
                print("**Alimentos**")
                self.__mostrar_alimentos()
                opcion = int(input("Seleccione el producto que desea agregar: "))
                cantidad=int(input("Seleccione la cantidad de articulos: "))
                if cantidad <= self.__productos_alimento[opcion-1].get_stock():
                    productos.append(Carrito(self.__productos_alimento[opcion-1],cantidad))
                    print("Producto agregado")
                else:
                    print("No se puede agregar esa cantidad")
            elif opcion==2:
                print("**Limpieza**")
                self.__mostrar_limpieza()
                opcion = int(input("Seleccione el producto que desea agregar: "))
                cantidad=int(input("Seleccione la cantidad de articulos: "))
                if cantidad <= self.__productos_limpieza[opcion-1].get_stock():
                    productos.append(Carrito(self.__productos_limpieza[opcion-1],cantidad))
                    print("Producto agregado")
                else:
                    print("No se puede agregar esa cantidad")
            elif opcion==3:
                print("**Belleza**")
                self.__mostrar_belleza()
                opcion = int(input("Seleccione el producto que desea agregar: "))
                cantidad=int(input("Seleccione la cantidad de articulos: "))
                if cantidad <= self.__productos_belleza[opcion-1].get_stock():
                    productos.append(Carrito(self.__productos_belleza[opcion-1],cantidad))
                    print("Producto agregado")
                else:
                    print("No se puede agregar esa cantidad")
            elif opcion==4:
                print("**Electrodomesticos**")
                self.__mostrar_electrodomesticos()
                opcion = int(input("Seleccione el producto que desea agregar: "))
                cantidad=int(input("Seleccione la cantidad de articulos: "))
                if cantidad <= self.__productos_electrodomestico[opcion-1].get_stock():
                    productos.append(Carrito(self.__productos_electrodomestico[opcion-1],cantidad))
                    print("Producto agregado")
                else:
                    print("No se puede agregar esa cantidad")
            elif opcion == 5:
                band=False
        fecha_compra=date.today
        self.__compras.append(Compra(cliente,productos,fecha_compra))
        print("Compra realizada con exito")
    
    def mostrar_compras(self):
        if not self.__compras:
            print("No hay compras registradas")
        else:
            i = 1
            for compra in self.__compras:
                print(f"Compra: {i}")
                compra.mostrar_compra()
                i += 1
    def anadir_stock(self):
        opcion=int(input("1)Alimentos\n2)Limpieza\n3)Belleza\n4)Electrodomesticos\n5)Salir"))
        if opcion == 1:
            self.__mostrar_alimentos()
            opcion=int(input("Ingrese el numero: "))
            cant=int(input("Ingrese la cantidad que desea agregar: "))
            self.__productos_alimento[opcion-1].agregar_stock(cant)
        elif opcion == 2:
            self.__mostrar_limpieza()
            opcion=int(input("Ingrese el numero: "))
            cant=int(input("Ingrese la cantidad que desea agregar: "))
            self.__productos_limpieza[opcion-1].agregar_stock(cant)
        elif opcion == 3:
            self.__mostrar_belleza()
            opcion=int(input("Ingrese el numero: "))
            cant=int(input("Ingrese la cantidad que desea agregar: "))
            self.__productos_belleza[opcion-1].agregar_stock(cant)
        elif opcion == 4:
            self.__mostrar_electrodomesticos()
            opcion=int(input("Ingrese el numero: "))
            cant=int(input("Ingrese la cantidad que desea agregar: "))
            self.__productos_electrodomestico[opcion-1].agregar_stock(cant)
                 
    def eliminar_stock(self):
        print("1)Alimentos\n2)Limpieza\n3)Belleza\n4)Electrodomesticos\n5)Salir")
        opcion=int(input("Seleccione el tipo de producto: "))
        if opcion == 1:
            self.__mostrar_alimentos()
            opcion=int(input("Ingrese el numero: ")) 
            cant=int(input("Ingrese la cantidad que desea eliminar: "))   
            if self.__validar_stock(self.__productos_alimento[opcion-1],cant):
                self.__productos_alimento[opcion-1].quitar_de_stock(cant)
            else:
                print("No se puede eliminar esa cantidad")
        elif opcion == 2:
            self.__mostrar_limpieza()
            opcion=int(input("Ingrese el numero: ")) 
            cant=int(input("Ingrese la cantidad que desea eliminar: "))   
            if self.__validar_stock(self.__productos_limpieza[opcion-1],cant):
                self.__productos_belleza[opcion-1].quitar_de_stock(cant)
            else:
                print("No se puede eliminar esa cantidad")  
        elif opcion == 3:
            self.__mostrar_belleza()
            opcion=int(input("Ingrese el numero: ")) 
            cant=int(input("Ingrese la cantidad que desea eliminar: "))   
            if self.__validar_stock(self.__productos_belleza[opcion-1],cant):
                self.__productos_belleza[opcion-1].quitar_de_stock(cant)
            else:
                print("No se puede eliminar esa cantidad")        
        elif opcion == 4:
            self.__mostrar_electrodomesticos()
            opcion=int(input("Ingrese el numero: ")) 
            cant=int(input("Ingrese la cantidad que desea eliminar: "))   
            if self.__validar_stock(self.__productos_electrodomestico[opcion-1],cant):
                self.__productos_electrodomestico[opcion-1].quitar_de_stock(cant)
            else:
                print("No se puede eliminar esa cantidad")
                      
    def __validar_stock(self, producto, cantidad):
        return producto.get_stock() >= cantidad
    

    def tester(self):
        alimento1 = Alimento("Papa", 15.5, "15/03/24", 15, "31/03/24")
        alimento2 = Alimento("Melon", 2, "15/03/24", 20, "31/03/24")
        cliente = Cliente("Andrea", "duran", "Morelia", date.today())
        self.__clientes.append(cliente)
        self.__productos_alimento.append(alimento1)
        self.__productos_alimento.append(alimento2)