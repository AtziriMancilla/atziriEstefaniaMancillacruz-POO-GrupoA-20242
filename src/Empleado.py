from Persona import Persona

class Empleado(Persona):
    def __init__(self, nombre, apellido, direccion, rol):
        super().__init__(nombre, apellido, direccion)
        self.rol = rol

    def mostrar_info_con_rol(self):
        return f"{super().mostrar_info()}, rol: {self.rol}"
