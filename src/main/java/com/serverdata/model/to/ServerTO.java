package com.serverdata.model.to;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Object used to transport data from the XML file to Model
 *
 */
@XmlRootElement(name = "server")
public class ServerTO {

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
