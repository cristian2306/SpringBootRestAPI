package edu.eci.escuelaing.ieti.userapi.dto;

import java.util.Date;

public class TokenDto
{

    private String token;

    private Date expirationDate;

    

    public TokenDto() {
    }

    public TokenDto( String token, Date expirationDate )
    {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public String getToken()
    {
        return token;
    }

    public Date getExpirationDate()
    {
        return expirationDate;
    }
}
