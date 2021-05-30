package recapproject.hrms.adapters.mernis;

import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.Candidate;

public interface MernisVerificationService {

    Result checkIfRealPerson(Candidate candidate);
}
