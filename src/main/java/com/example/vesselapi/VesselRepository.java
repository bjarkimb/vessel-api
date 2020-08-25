package vesselapi;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VesselRepository extends MongoRepository<Vessel, String> {


}