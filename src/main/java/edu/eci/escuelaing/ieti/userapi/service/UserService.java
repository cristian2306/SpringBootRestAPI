package edu.eci.escuelaing.ieti.userapi.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import edu.eci.escuelaing.ieti.userapi.entities.User;

public interface UserService
{
    /**
     * Crea un usuario
     * @param user Objeto usuario a crear
     * @return
     */
    User create( User user );

    /**
     * Busca el usuario por su id
     * @param id id del usuario a buscar
     * @return
     */
    User findById( String id );
    
    /**
     * Obtiene todos los usuarios registrados
     * @return Usuarios obtenidos
     */
    List<User> getAll();

    /**
     * Elimina el usuario por el id dado
     * @param id Id del usuario a eliminar
     */
    void deleteById( String id );

    /**
     * Actializa el usuario dado su id
     * @param user Nueva informacion del usuario
     * @param userId Id del usuario a actualizar
     * @return
     */
    User update( User user, String userId );

    List<User> findUsersWithNameOrLastNameLike(String name, String LastName);
    
    List<User> findUsersCreatedAfter(Date startDate);
}  