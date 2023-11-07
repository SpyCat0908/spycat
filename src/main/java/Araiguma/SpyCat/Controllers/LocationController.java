package Araiguma.SpyCat.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Araiguma.SpyCat.Models.Location;
import Araiguma.SpyCat.Services.LocationService;
import Araiguma.SpyCat.dtos.LocationInpuDTO;
import Araiguma.SpyCat.dtos.LocationOutputDTO;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired

    private LocationService service;
    
    @PostMapping
    public ResponseEntity<LocationOutputDTO> create(@Valid @RequestBody LocationInpuDTO location){
        LocationOutputDTO LocationCriado = service.create(location);
        return new ResponseEntity<LocationOutputDTO>(LocationCriado, HttpStatus.CREATED);
    }
    @PutMapping
        public ResponseEntity<Location> update(@Valid @RequestBody Location location){
        Location locationUpdate = service.update(location);
        return new ResponseEntity<>(locationUpdate, HttpStatus.OK);
    }
    @GetMapping("/{id}")
        public ResponseEntity<Location> read (@PathVariable Long id){
            Location locationBuscado = service.read(id);
            return new ResponseEntity<Location>(locationBuscado,HttpStatus.OK);
    }
    @GetMapping
        public ResponseEntity<List<Location>> list(){
            List<Location> listLocations = service.list();
            return new ResponseEntity<List<Location>>(listLocations, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<Location> delete( @PathVariable Long id){
            service.delete(id);
            return new ResponseEntity<Location>(HttpStatus.NO_CONTENT);
        }
}
