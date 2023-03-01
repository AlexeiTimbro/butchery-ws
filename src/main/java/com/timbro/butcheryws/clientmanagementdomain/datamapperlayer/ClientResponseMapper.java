package com.timbro.butcheryws.clientmanagementdomain.datamapperlayer;

import com.timbro.butcheryws.clientmanagementdomain.datalayer.Client;
import com.timbro.butcheryws.clientmanagementdomain.presentationlayer.ClientResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ClientResponseMapper {

    @Mapping(expression = "java(client.getClientIdentifier().getClientId())", target = "clientId")
    @Mapping(expression = "java(client.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(client.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(client.getAddress().getProvince())", target = "province")
    @Mapping(expression = "java(client.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(client.getAddress().getPostalCode())", target = "postalCode")
    ClientResponseModel entityToResponseModel(Client client);

    List<ClientResponseModel> entityListToResponseModelList(List<Client> clients);

}
