package kz.aitu.oop.Erasyl_Kassymkhan.Transport.OOP.repositories;

import kz.aitu.oop.Erasyl_Kassymkhan.Transport.OOP.models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
}
