from Tienda import Tienda


class Sistema:
    CONTRASENA_SEGURA = "1234"

    def __init__(self):
        self.tienda = Tienda()

    def ejecutar_programa(self):
        es_contrasena_valida = False
        self.tienda.tester()
        while not es_contrasena_valida:
            print("\n*** BIENVENIDO ***")
            contrasena = input("Ingresa la contraseña: ")
            if contrasena == self.CONTRASENA_SEGURA:
                es_contrasena_valida = True
                self.ejecutar_menu_sistema()
            else:
                print("\nContraseña incorrecta, intenta de nuevo")

    def ejecutar_menu_sistema(self):
        opcion = 0
        while opcion != 11:
            print("\n** BIENVENIDO AL SISTEMA **")
            print("1. Registrar Producto")
            print("2. Registrar Cliente")
            print("3. Mostrar Productos")
            print("4. Mostrar Clientes")
            print("5. Eliminar Producto")
            print("6. Eliminar Cliente")
            print("7. Añadir a stock")
            print("8. Eliminar del stock")
            print("9. Realizar compra")
            print("10. Ver compras")
            print("11. Salir")
            opcion = int(input("Seleccione una opción: "))
            if opcion == 1:
                print("\nSeleccionaste Registrar Producto")
                print("Ingresa el tipo de producto")
                print("1. Limpieza")
                print("2. Alimento")
                print("3. Electrodomestico")
                print("4. Maquillaje")
                opcion_producto = int(input("Selecciona una opción: "))
                if opcion_producto == 1:
                    self.tienda.registrar_producto_limpieza()
                elif opcion_producto == 2:
                    self.tienda.registrar_producto_alimento()
                elif opcion_producto == 3:
                    self.tienda.registrar_producto_electrodomestico()
                elif opcion_producto == 4:
                    self.tienda.registrar_producto_belleza()
                else:
                    print("Opción no válida")
            elif opcion == 2:
                self.tienda.registrar_cliente()
            elif opcion == 3:
                self.tienda.mostrar_productos()
            elif opcion == 4:
                self.tienda.mostrar_clientes()
            elif opcion == 5:
                self.tienda.eliminar_producto()
            elif opcion == 6:
                self.tienda.eliminar_cliente()
            elif opcion == 7:
                self.tienda.anadir_stock()
            elif opcion == 8:
                self.tienda.eliminar_stock()
            elif opcion == 9:
                self.tienda.realizar_compra()
            elif opcion == 10:
                self.tienda.mostrar_compras()
            elif opcion == 11:
                print("Gracias por usar la tienda")