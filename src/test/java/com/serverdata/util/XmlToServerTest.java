package com.serverdata.util;

import com.serverdata.model.to.ServerTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

public class XmlToServerTest {

    @Test
    public void testXmlToServer() throws JAXBException, FileNotFoundException {
        File file = ResourceUtils.getFile(this.getClass().getResource("/server_definition.xml"));
        JAXBContext jaxbContext = JAXBContext.newInstance(ServerTO.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        ServerTO server = (ServerTO) unmarshaller.unmarshal(file);

        Assert.assertEquals(server.getName(), "ServerNameEx");
        Assert.assertEquals(server.getDescription(), "ServerDescEx");
    }
}
