# ms-peliculas-favoritos-backend
Microservicio de películas favoritas para el curso de Docker y Kubernetes Intermedio

## Requerimientos
- [ms-peliculas-backend](https://github.com/anthonyponte/ms-peliculas-backend) - Microservicio de películas para el curso de Docker y Kubernetes Intermedio

## Instalacion
Ejecutar los siguientes comandos para desplegar el microservicio:
```
kubectl apply -f ms-peliculas-favoritos-backend-configmap.yml
kubectl apply -f ms-peliculas-favoritos-backend-deployment.yml
kubectl apply -f ms-peliculas-favoritos-backend-service.yml
```

## Uso
| Metodo | Url                                           | Descripción                                                |
|--------|-----------------------------------------------|------------------------------------------------------------|
| GET    | /api/v1/favoritos?idUsuario={número}          | Listar todos los favoritos cuyo idUsuario sea ```número``` |
| POST   | /api/v1/favoritos                             | Crear favorito                                             |
| DELETE | /api/v1/favoritos/{id}                        | Eliminar favorito por ```id```                             |
| DELETE | /api/v1/favoritos/eliminar-todos/{idPelicula} | Eliminar todos los favoritos por ```id```                  |
| GET    | /api/v1/perfiles                              | Listar todos los perfiles                                  |
| GET    | /api/v1/perfiles/{id}                         | Obtener perfil por ```id```                                |
| POST   | /api/v1/perfiles                              | Crear perfil.                                              |
| PUT    | /api/v1/perfiles/{id}                         | Actualizar perfil por ```id```                             |
| DELETE | /api/v1/perfiles/{id}                         | Eliminar perfil por ```id```                               |
| GET    | /api/v1/usuarios                              | Listar todos los usuarios                                  |
| GET    | /api/v1/usuarios/{id}                         | Obtener usuario por ```id```                               |
| POST   | /api/v1/usuarios                              | Crear usuario.                                             |
| PUT    | /api/v1/usuarios/{id}                         | Actualizar usuario por ```id```                            |
| DELETE | /api/v1/usuarios/{id}                         | Eliminar usuario por ```id```                              |
