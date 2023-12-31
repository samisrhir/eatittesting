package eatitproject.eatitproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import eatitproject.eatitproject.models.Snack;



public interface SnackRepository extends JpaRepository<Snack,Long> {

}
