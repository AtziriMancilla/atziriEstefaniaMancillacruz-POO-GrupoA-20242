class Persona:
    def __init__(self, nombre, apellido, direccion):
        self.__nombre = nombre
        self.__apellido = apellido
        self.__direccion = direccion

    def mostrar_info(self):
        return f"Nombre: {self.__nombre}, Apellido: {self.__apellido}, Direccion: {self.__direccion}"
