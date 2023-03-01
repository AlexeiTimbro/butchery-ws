package com.timbro.butcheryws.clientmanagementdomain.businesslayer;


import com.timbro.butcheryws.clientmanagementdomain.presentationlayer.ClientRequestModel;
import com.timbro.butcheryws.clientmanagementdomain.presentationlayer.ClientResponseModel;

import java.util.List;

public interface ClientService {

    //List<Client> getClients();
    List<ClientResponseModel> getClients();

    ClientResponseModel getClientByClientId(String clientId);

    ClientResponseModel addClient(ClientRequestModel clientRequestModel);

    ClientResponseModel updateClient(ClientRequestModel client, String clientId);

    void removeClient(String clientId);


}
