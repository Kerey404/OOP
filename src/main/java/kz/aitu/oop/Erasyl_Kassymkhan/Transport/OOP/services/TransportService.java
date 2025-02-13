package kz.aitu.oop.Erasyl_Kassymkhan.Transport.OOP.services;

import kz.aitu.oop.Erasyl_Kassymkhan.Transport.OOP.models.Bus;
import kz.aitu.oop.Erasyl_Kassymkhan.Transport.OOP.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportService {
    private final BusRepository busRepository;

    @Autowired
    public TransportService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Optional<Bus> getBusById(Long id) {
        return busRepository.findById(id);
    }

    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    public Bus updateBus(Long id, Bus updatedBus) {
        return busRepository.findById(id).map(bus -> {
            bus.setModel(updatedBus.getModel());
            bus.setCapacity(updatedBus.getCapacity());
            return busRepository.save(bus);
        }).orElseThrow(() -> new RuntimeException("Bus with ID " + id + " not found"));
    }

    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }
}
