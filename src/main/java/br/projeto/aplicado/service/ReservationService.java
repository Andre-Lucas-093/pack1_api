package br.projeto.aplicado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projeto.aplicado.dto.ReservationDTO;
import br.projeto.aplicado.exception.ReservationException;
import br.projeto.aplicado.model.ReservationModel;
import br.projeto.aplicado.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	public ReservationDTO modelToDTO(ReservationModel reservation, ReservationDTO reservationDTO) {
		reservationDTO.setId(reservation.getId());
		reservationDTO.setReservedSession(reservation.getReservedSession());
		
		return reservationDTO;
	}
	
	public ReservationModel dtoToModel(ReservationModel reservation, ReservationDTO reservationDTO) {
		reservation.setReservedSession(reservationDTO.getReservedSession());
		
		return reservation;
	}
	
	public String save(ReservationDTO reservationDTO) throws ReservationException {
		ReservationModel reservation = new ReservationModel();
		dtoToModel(reservation, reservationDTO);
		reservationRepository.save(reservation);
		return "" + reservation.getId();
	}
	
	public ReservationDTO searchById(Integer idReservation) throws ReservationException {
		Optional<ReservationModel> reservation = reservationRepository.findById(idReservation);
		ReservationModel reservationModel = new ReservationModel();
		ReservationDTO reservationDTO = new ReservationDTO();
		if(reservation.isPresent()) {
			reservationModel = reservation.get();
			modelToDTO(reservationModel, reservationDTO);
			return reservationDTO;
		}
		throw new ReservationException("");
	}
	
	public void delete(Integer idReservation) {
		reservationRepository.deleteById(idReservation);
	}
	
	public String update(Integer idReservation, ReservationDTO reservationDTO) throws ReservationException {
		Optional<ReservationModel> reservation = reservationRepository.findById(idReservation);
		ReservationModel reservationModel = new ReservationModel();
		if(reservation.isPresent()) {
			reservationModel = reservation.get();
			if(reservationDTO.getReservedSession() != null) {
				reservationModel.setReservedSession(reservationDTO.getReservedSession());
			}
			
			reservationRepository.save(reservationModel);
			return "" + reservationModel.getId();
		}
		throw new ReservationException("");
	}
	
	public List<ReservationDTO> searchAll() {
		List<ReservationModel> reservationList = reservationRepository.findAll();
		List<ReservationDTO> reservationDTOList = new ArrayList<>();
		for(ReservationModel reservation : reservationList) {
			ReservationDTO reservationDTO = new ReservationDTO();
			modelToDTO(reservation, reservationDTO);
			reservationDTOList.add(reservationDTO);
		}
		return reservationDTOList;
	}
	
	public void saveList(List<ReservationDTO> listReservationDTO) throws ReservationException {
		List<ReservationModel> listReservation = new ArrayList<>();
		
		for(ReservationDTO reservationDTO : listReservationDTO) {
			ReservationModel reservation = new ReservationModel();
			dtoToModel(reservation, reservationDTO);
			listReservation.add(reservation);
		}
		reservationRepository.saveAll(listReservation);
	}
	
}
