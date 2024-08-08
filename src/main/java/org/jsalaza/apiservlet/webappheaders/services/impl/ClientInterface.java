package org.jsalaza.apiservlet.webappheaders.services.impl;
import java.util.List;
import org.jsalaza.apiservlet.webappheaders.modelo.Client;

public interface ClientInterface {
    void saveClient(Client client);
    int getIndexClient();
    List<Client> getClientByProinces(String provinces);

}
