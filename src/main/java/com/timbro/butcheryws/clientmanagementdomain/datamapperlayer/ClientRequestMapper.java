package com.timbro.butcheryws.clientmanagementdomain.datamapperlayer;



import com.timbro.butcheryws.clientmanagementdomain.datalayer.Client;
import com.timbro.butcheryws.clientmanagementdomain.presentationlayer.ClientRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clientIdentifier", ignore = true)
    Client requestModelToEntity(ClientRequestModel clientRequestModel);

}
