package kz.aitu.oop.Erasyl_Kassymkhan.Transport.OOP.controllers;

import kz.aitu.oop.Erasyl_Kassymkhan.Transport.OOP.models.Bus;
import kz.aitu.oop.Erasyl_Kassymkhan.Transport.OOP.services.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buses")
public class BusController {
    private final TransportService service;

    @Autowired
    public BusController(TransportService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Bus> getAllBuses() {
        return service.getAllBuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        Optional<Bus> bus = service.getBusById(id);
        return bus.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
        Bus savedBus = service.addBus(bus);
        return ResponseEntity.ok(savedBus);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus updatedBus) {
        try {
            Bus updated = service.updateBus(id, updatedBus);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        service.deleteBus(id);
        return ResponseEntity.noContent().build();
    }
}
