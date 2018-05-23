package cz.api.markup.client.pojos.api;


import javax.xml.bind.annotation.XmlRootElement;

/**
 *  Pojo object, which exist to hold information about application API.
 *
 *  @author Filip Snajdr, fsnajdr86(at)gmail.com
 */
@XmlRootElement(name = "parameter")
public class ParameterPojo {

    private String name;

    private String type;

    private Boolean optional;

    public ParameterPojo() {
    }

    public ParameterPojo(String name, String type, Boolean optional) {
        this.name = name;
        this.type = type;
        this.optional = optional;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }
}
