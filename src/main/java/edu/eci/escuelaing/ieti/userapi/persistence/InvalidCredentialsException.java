package edu.eci.escuelaing.ieti.userapi.persistence;

import javax.ws.rs.InternalServerErrorException;

import org.springframework.http.HttpStatus;

import edu.eci.escuelaing.ieti.userapi.dto.ServerErrorResponseDto;
import edu.eci.escuelaing.ieti.userapi.entities.enums.ErrorCodeEnum;

public class InvalidCredentialsException extends InternalServerErrorException
{
   public InvalidCredentialsException() {

      super(String.valueOf(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND)));

   }
}
