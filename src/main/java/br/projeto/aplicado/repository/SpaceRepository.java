package br.projeto.aplicado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.aplicado.model.SpaceModel;

@Repository
public interface SpaceRepository extends JpaRepository <SpaceModel, Integer> {

}
