from datetime import date
from Persona import Persona


class Cliente(Persona):
    def __init__(self, nombre, apellido, direccion, fecha_registro):
        super().__init__(nombre, apellido, direccion)
        self.fecha_registro = fecha_registro

    def mostrar_info_con_fecha(self):
        return f"{super().mostrar_info()}, Fecha de registro: {self.fecha_registro}"