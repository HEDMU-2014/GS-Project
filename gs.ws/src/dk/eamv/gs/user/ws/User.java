package dk.eamv.gs.user.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.5
 * 2016-03-29T20:17:25.871+02:00
 * Generated source version: 3.0.5
 * 
 */
@WebService(targetNamespace = "http://ws.user.gs.eamv.dk/", name = "User")
@XmlSeeAlso({ObjectFactory.class, dk.eamv.gs.ObjectFactory.class})
public interface User {

    @WebMethod
    @RequestWrapper(localName = "createUser", targetNamespace = "http://ws.user.gs.eamv.dk/", className = "dk.eamv.gs.user.ws.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://ws.user.gs.eamv.dk/", className = "dk.eamv.gs.user.ws.CreateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean createUser(
        @WebParam(name = "user", targetNamespace = "")
        dk.eamv.gs.User user
    );

    @WebMethod
    @RequestWrapper(localName = "getUser", targetNamespace = "http://ws.user.gs.eamv.dk/", className = "dk.eamv.gs.user.ws.GetUser")
    @ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://ws.user.gs.eamv.dk/", className = "dk.eamv.gs.user.ws.GetUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public dk.eamv.gs.User getUser(
        @WebParam(name = "email", targetNamespace = "")
        java.lang.String email
    );
}
