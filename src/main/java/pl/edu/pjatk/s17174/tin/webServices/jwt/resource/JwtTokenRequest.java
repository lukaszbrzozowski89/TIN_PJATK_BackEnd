package pl.edu.pjatk.s17174.tin.webServices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;

//    {
//        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxMjY3NTMwOSwiaWF0IjoxNjEyNjM0ODI5fQ.a08pVxOD0AeacmQPLdQl7aFHO_XWN1ovPbuXGMlv-YUqtwHraGS_Z58hxPXhODV_kuhSjRzVqDbZGwyw6xeqvg"
//    }

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
