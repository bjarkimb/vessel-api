package vesselapi;

import java.util.List;
import java.util.Date;
import java.lang.Math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class VesselController {

	private final VesselRepository repository;

	private static final Logger log = LoggerFactory.getLogger(VesselController.class);

	VesselController(VesselRepository repository) {
		this.repository = repository;
	}


	@GetMapping("/vessels")
	List<Vessel> all() {
		return repository.findAll();
	}

	@GetMapping("/vessels/{id}")
	Vessel one(@PathVariable String id) {
		return repository.findById(id)
			.orElse(null);
	}

	@PostMapping("/vessels")
	Vessel newVessel(@RequestBody Vessel newVessel) {

		Vessel formattedVessel = formatVessel(newVessel);
		
		return repository.save(formattedVessel);
	}

	@PutMapping("vessels/{id}")
	Vessel replaceVessel(@RequestBody Vessel newVessel, @PathVariable String id) {
		return repository.findById(id)
				.map(vessel -> {
					vessel.setName(newVessel.getName());
					vessel.setPosition(newVessel.getPosition());
					vessel.getPosition().setSpeed(vessel.getPosition().getSpeed()*0.514);
					vessel.getPosition().setLatitude(Math.toRadians(vessel.getPosition().getLatitude()));
					vessel.getPosition().setLongitude(Math.toRadians(vessel.getPosition().getLongitude()));
					vessel.getPosition().setReceivedDate(new Date());
					return repository.save(vessel);
				})
				.orElse(null);
	}
	

	@DeleteMapping("/vessels/{id}")
	void deleteVessel(@PathVariable String id) {
		repository.deleteById(id);
	}

	private static Vessel formatVessel(Vessel newVessel) {
		double latRad = Math.toRadians(newVessel.getPosition().getLatitude());
		double longRad = Math.toRadians(newVessel.getPosition().getLongitude());
		double speedMS = newVessel.getPosition().getSpeed()*0.514;

		return new Vessel(newVessel.getName(), new Position(newVessel.getPosition().getDate(), new Date(), latRad, longRad, speedMS));
	}
}