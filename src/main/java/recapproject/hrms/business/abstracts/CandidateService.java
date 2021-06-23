package recapproject.hrms.business.abstracts;

import java.util.List;

import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.entities.concretes.Candidate;

public interface CandidateService {

	Result add(Candidate candidate);

	Result update(Candidate candidate);

	Result delete(Candidate candidate);

	DataResult<List<Candidate>> getAll();

	DataResult<Candidate> getById(int id);

	DataResult<Candidate> getByNationalId(String nationalId);
}
