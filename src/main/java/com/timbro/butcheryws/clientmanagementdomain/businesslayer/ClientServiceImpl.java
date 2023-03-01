package com.timbro.butcheryws.clientmanagementdomain.businesslayer;


import com.timbro.butcheryws.clientmanagementdomain.datalayer.Address;
import com.timbro.butcheryws.clientmanagementdomain.datalayer.Client;
import com.timbro.butcheryws.clientmanagementdomain.datalayer.ClientRepository;
import com.timbro.butcheryws.clientmanagementdomain.datamapperlayer.ClientRequestMapper;
import com.timbro.butcheryws.clientmanagementdomain.datamapperlayer.ClientResponseMapper;
import com.timbro.butcheryws.clientmanagementdomain.presentationlayer.ClientRequestModel;
import com.timbro.butcheryws.clientmanagementdomain.presentationlayer.ClientResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ClientResponseMapper clientResponseMapper;
    private ClientRequestMapper clientRequestMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientResponseMapper clientResponseMapper, ClientRequestMapper clientRequestMapper) {
        this.clientRepository = clientRepository;
        this.clientResponseMapper = clientResponseMapper;
        this.clientRequestMapper = clientRequestMapper;
    }

    @Override
    public List<ClientResponseModel> getClients() {
//        List<Client> clients = clientRepository.findAll();
//        return clientResponseMapper.entityListToResponseModelList(clients);
        return clientResponseMapper.entityListToResponseModelList(clientRepository.findAll());

    }

    @Override
    public ClientResponseModel getClientByClientId(String clientId) {
        return clientResponseMapper.entityToResponseModel(clientRepository.findClientByClientIdentifier_ClientId(clientId));
    }

    @Override
    public ClientResponseModel addClient(ClientRequestModel clientRequestModel) {
        //return clientRepository.save(client);
        // return clientRequestMapper.requestModelToEntity(clientRepository.save(clientRequestModel.clientRequestModel));
        Address address = new Address(clientRequestModel.getStreetAddress(), clientRequestModel.getCity(),
                clientRequestModel.getProvince(), clientRequestModel.getCountry(), clientRequestModel.getPostalCode());
        Client client = clientRequestMapper.requestModelToEntity(clientRequestModel);
        client.setAddress(address);

        return clientResponseMapper.entityToResponseModel(clientRepository.save(client));
    }

    @Override
    public ClientResponseModel updateClient(ClientRequestModel clientRequestModel, String clientId) {

        Client existingClient = clientRepository.findClientByClientIdentifier_ClientId((clientId));
        if (existingClient == null) {
            return null; //later throw exception
        }

        Address address = new Address(clientRequestModel.getStreetAddress(), clientRequestModel.getCity(),
                clientRequestModel.getProvince(), clientRequestModel.getCountry(), clientRequestModel.getPostalCode());
        Client client = clientRequestMapper.requestModelToEntity(clientRequestModel);
        client.setAddress(address);


        client.setId(existingClient.getId());
        client.setClientIdentifier(existingClient.getClientIdentifier());

        return clientResponseMapper.entityToResponseModel(clientRepository.save(client));
    }

    @Override
    public void removeClient(String clientId) {
        Client existingClient = clientRepository.findClientByClientIdentifier_ClientId((clientId));
        if (existingClient == null) {
            return; //later throw exception
        }
        clientRepository.delete(existingClient);
    }

}
