package cz.api.markup.client.pojos.api;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 *  Pojo object, which exist to hold information about application API.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@XmlRootElement(name = "api")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({EndpointPojo.class,ParameterPojo.class})
public class ApiPojo {

    @XmlElement(name = "endpoint")
    private List<ParameterPojo> endPoints;


    public List<ParameterPojo> getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(List<ParameterPojo> endPoints) {
        this.endPoints = endPoints;
    }
}
