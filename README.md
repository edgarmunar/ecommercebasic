# E-Commerce Basic for Edgar Munar

## Este es un proyecto sencillo de e-commerce con una arquitectura monolitica modular, donde vamos a tener 2 servicios principales
- Catalogo de Productos
- Gestion de pedidos

## Backend

## Clonar Repositorio

Para clonar este repositorio en tu maquina local, usa el siguiente comando

```bash
https://github.com/edgarmunar/ecommercebasic.git
```

Puedes descargar este repositorio como un archivo ZIP desde el siguiente enlace:

[Descargar ZIP](https://github.com/edgarmunar/ecommercebasic/archive/refs/heads/main.zip)

-Se entrega el codigo del proyecto con 2 modulos, Catalogos de Productos y Gestion de Pedidos
-Se encuentra una coleccion de Postman, para probar el proyecto. (https://github.com/edgarmunar/ecommercebasic/blob/main/PruebasPostmanEcommerceEdgarMunar.postman_collection.json)
- El proyecto tiene en la carpeta resoruces un archivo data.sql que tiene unos insert de prueba, cuando se ejecuta el proyecto se crean automaticamente las tablas y se ejecutan los insert
- en el archivo properties esta la configuracion de la base de datos, para ajustarla a disposición

## Bases de Datos
- Se realiza con motor de base de datos Mysql
- Se crearon 4 tablas, producto, cliente, pedido y pedidoProducto
- La administracion de los datos las realiza springboot jpa, se crearon unas clases entities y desde ahí se administra la persistencia de las mismas

## DevOps

Se encuentra un pipeline llamado ci-cd.yml en (https://github.com/edgarmunar/ecommercebasic/blob/main/.github/workflows/ci-cd.yml), 
este archivo se configuro con Github Action y detro de él esta la explicacion de los pasos
  



