package br.projeto.aplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.aplicado.model.ReservationModel;

@Repository
public interface ReservationRepository extends JpaRepository <ReservationModel, Integer> {

}
