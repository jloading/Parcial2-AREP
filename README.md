# PARCIAL 2

### Demo del parcial: https://youtu.be/3h5ViI-fu4k

1. Clonar el repositorio
```
git clone https://github.com/jloading/Parcial2-AREP
```

2. Dentro del proyecto se instalan los paquetes
```
mvn clean install
```
### Ejecución en local

Se ejecuta la clase:
```
java -cp "target/classes;target/dependency/*" org.example.Server
```

Después de ejecutar las clases, se accede a
```
localhost:4567
```

Dado que en el código el servidor proxy se conecta a las clases SparkWebServer montadas en la instacia EC2, funcionará sin necesidad de ejecutar estas clases
![image](https://github.com/jloading/Parcial2-AREP/assets/65261708/7a5aa9ee-d591-4307-9e6f-b91dee8e1b13)

### Ejecución en AWS

Se ingresa a la dirección
```
http://ec2-3-81-119-176.compute-1.amazonaws.com:4567/
```

![image](https://github.com/jloading/Parcial2-AREP/assets/65261708/1c1dcce2-8a04-4b0d-ab40-782c6764364f)

### Hecho con

* Java: Lenguaje de programación de propósito general con enfoque a el paradigma de orientado a objetos, y con un fuerte tipado de variables.
* Git: Es un sistema de control de versiones distribuido (VCS).
* Maven: Es una herramienta que estandariza la configuración del ciclo de vida del proyecto.
* HTML: Es un lenguaje de marcado que estructura una página web y su contenido.
* JavaScript: Lenguaje de programación que los desarrolladores utilizan para hacer paginas web dinamicas.
* AWS: Es una colección de servicios de computación en la nube pública (también llamados servicios web) que en conjunto forman una plataforma de computación en la nube, ofrecidas a través de Internet por Amazon.com.

### Autor

* **Juan Carlos Acosta**

