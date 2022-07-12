package br.projeto.aplicado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projeto.aplicado.dto.ClientDTO;

import br.projeto.aplicado.exception.ClientException;
import br.projeto.aplicado.model.ClientModel;

import br.projeto.aplicado.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public ClientDTO modelToDTO(ClientModel clienteModel) {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setLoginEmail(clienteModel.getLoginEmail());
		clientDTO.setPassword(clienteModel.getPassword());
		return clientDTO;
	}

	public ClientModel dtoToModel(ClientDTO clientDTO) {
		ClientModel clientModel = new ClientModel();
		clientModel.setLoginEmail(clientDTO.getLoginEmail());
		clientModel.setPassword(clientDTO.getPassword());
		return clientModel;
	}

	public String save(ClientDTO clientDTO) {
		ClientModel clientModel = dtoToModel(clientDTO);
		clientRepository.save(clientModel);
		return "Client id " + clientModel.getId() + " created";

	}

	public ClientDTO searchById(int idClient) throws ClientException {
		Optional<ClientModel> savedClient = clientRepository.findById(idClient);
		if (savedClient.isPresent()) {
			ClientModel clientModel = savedClient.get();
			ClientDTO clientDTO = modelToDTO(clientModel);
			return clientDTO;
		}
		throw new ClientException("Client with the id " + idClient + "has not been found");

	}

	public String delete(Integer idClient) {
		clientRepository.deleteById(idClient);
		return "client with the id " + idClient + " has been deleted";
	}

	public String update(int idClient, ClientDTO clientDTO) throws ClientException {
		Optional<ClientModel> savedClient = clientRepository.findById(idClient);
		if (savedClient.isPresent()) {
			ClientModel clientModel = savedClient.get();

			if (clientModel.getLoginEmail() != null) {
				clientModel.setLoginEmail(clientDTO.getLoginEmail());
			}
			if (clientModel.getPassword() != null) {
				clientModel.setPassword(clientDTO.getPassword());
			}
			clientRepository.save(clientModel);
			return "Client id " + idClient + " has been updated";

		} else {
			throw new ClientException("Client with id " + idClient + " does not exist!");
		}

	}

	public List<ClientDTO> searchAll() {
		List<ClientModel> clientList = clientRepository.findAll();
		List<ClientDTO> clientDTOList = new ArrayList<>();
		ClientDTO clientDTO = new ClientDTO();
		for (ClientModel clientModel : clientList) {
			modelToDTO(clientModel);
			clientDTOList.add(clientDTO);
		}
		return clientDTOList;
	}

	public String postClientList(List<ClientDTO> listClientDTO) {
		List<ClientModel> listClient = new ArrayList<>();

		for (ClientDTO clientDTO : listClientDTO) {
			ClientModel clientModel = dtoToModel(clientDTO);
			listClient.add(clientModel);
		}
		clientRepository.saveAll(listClient);
		return "List added";
	}

}
