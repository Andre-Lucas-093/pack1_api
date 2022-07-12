package br.projeto.aplicado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projeto.aplicado.dto.SpaceDTO;
import br.projeto.aplicado.exception.SpaceException;
import br.projeto.aplicado.model.SpaceModel;
import br.projeto.aplicado.repository.SpaceRepository;

@Service
public class SpaceService {

	@Autowired
	SpaceRepository spaceRepository;

	public SpaceDTO modelToDTO(SpaceModel space, SpaceDTO spaceDTO) {
		spaceDTO.setId(space.getId());
		spaceDTO.setAvailable(space.getAvailable());
		spaceDTO.setVaccantSlots(space.getVaccantSlots());

		return spaceDTO;
	}

	public SpaceModel dtoToModel(SpaceModel space, SpaceDTO spaceDTO) {
		space.setAvailable(spaceDTO.getAvailable());
		space.setVaccantSlots(spaceDTO.getVaccantSlots());

		return space;
	}

	public String save(SpaceDTO spaceDTO) throws SpaceException {
		SpaceModel space = new SpaceModel();
		dtoToModel(space, spaceDTO);
		spaceRepository.save(space);
		return "" + space.getId();
	}

	public SpaceDTO searchById(Integer idSpace) throws SpaceException {
		Optional<SpaceModel> space = spaceRepository.findById(idSpace);
		SpaceModel spaceModel = new SpaceModel();
		SpaceDTO spaceDTO = new SpaceDTO();
		if (space.isPresent()) {
			spaceModel = space.get();
			modelToDTO(spaceModel, spaceDTO);
			return spaceDTO;
		}
		// TODO Adicionar o id do espaco
		throw new SpaceException("Space not found");
	}

	public void delete(Integer idSpace) {
		spaceRepository.deleteById(idSpace);
	}

	public String update(Integer idSpace, SpaceDTO spaceDTO) throws SpaceException {
		Optional<SpaceModel> space = spaceRepository.findById(idSpace);
		SpaceModel spaceModel = new SpaceModel();
		if (space.isPresent()) {
			spaceModel = space.get();
			if (spaceDTO.getAvailable() != null) {
				spaceModel.setAvailable(spaceDTO.getAvailable());
			}

			if (spaceDTO.getVaccantSlots() != null) {
				spaceModel.setVaccantSlots(spaceDTO.getVaccantSlots());
			}

			spaceRepository.save(spaceModel);
			return "Created space at" + spaceModel.getId();
		}
		throw new SpaceException("");
	}

	public List<SpaceDTO> searchAll() {
		List<SpaceModel> spaceList = spaceRepository.findAll();
		List<SpaceDTO> spaceDTOList = new ArrayList<>();
		for (SpaceModel space : spaceList) {
			SpaceDTO spaceDTO = new SpaceDTO();
			modelToDTO(space, spaceDTO);
			spaceDTOList.add(spaceDTO);
		}
		return spaceDTOList;
	}

	public void saveList(List<SpaceDTO> listSpaceDTO) throws SpaceException {
		List<SpaceModel> listSpace = new ArrayList<>();

		for (SpaceDTO spaceDTO : listSpaceDTO) {
			SpaceModel space = new SpaceModel();
			dtoToModel(space, spaceDTO);
			listSpace.add(space);
		}
		spaceRepository.saveAll(listSpace);
	}
}
