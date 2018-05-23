package cz.api.markup.client.pojos.api;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  Pojo object, which exist to hold information about application API.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@XmlRootElement(name = "endpoint")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(ParameterPojo.class)
public class EndpointPojo {

    // GET,PUT,POST,DELETE...
    private String httpMethod;

    private String path;

    private String methodName;

    private String description;

    @XmlElementWrapper(name = "produce")
    private String[] produceType;

    @XmlElementWrapper(name = "parameters")
    @XmlElement(name = "parameter")
    private List<ParameterPojo> parameters = new ArrayList<>();

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ParameterPojo> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterPojo> parameters) {
        this.parameters = parameters;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String[] getProduceType() {
        return produceType;
    }

    public void setProduceType(String[] produceType) {
        this.produceType = produceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
