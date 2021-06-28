package recapproject.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.abstracts.UserService;
import recapproject.hrms.entities.concretes.Candidate;
import recapproject.hrms.adapters.mernis.MernisVerificationManager;
import recapproject.hrms.business.abstracts.CandidateService;
import recapproject.hrms.core.utilities.business.BusinessRules;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.ErrorResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.core.validation.UserValidation;
import recapproject.hrms.dataAccess.abstracts.CandidateDao;
import recapproject.hrms.entities.concretes.User;

@Service
public class CandidateManager implements CandidateService {

	private final CandidateDao candidateDao;
	private UserService userService;
	
	UserValidation userValidation = new UserValidation(new MernisVerificationManager());
	
	//MernisVerificationManager mernisVerificationManager = new MernisVerificationManager();

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserService userService) {

		this.candidateDao = candidateDao;
		this.userService = userService;
	}

	@Override
	public Result add(Candidate candidate) {

		Candidate candidateAddInDB = new Candidate();

		candidateAddInDB.setFirstName(this.userValidation.CapitalizeFirstLetterofWord(candidate.getFirstName()));

		candidateAddInDB.setLastName(candidate.getLastName().toUpperCase());

		candidateAddInDB.setDateOfBirth(candidate.getDateOfBirth());

		candidateAddInDB.setNationalId(candidate.getNationalId());

		candidateAddInDB.setEmail(candidate.getEmail());
		
		candidateAddInDB.setPassword(candidate.getPassword());
		
		candidateAddInDB.setPasswordAgain(candidate.getPasswordAgain());
		
		candidateAddInDB.setCreatedAt(candidate.getCreatedAt());
		
		candidateAddInDB.setDeleted(candidate.isDeleted());
		
		candidateAddInDB.setVerified(candidate.isVerified());
		

		var result = BusinessRules.run(CheckUserExistsByNationalId(candidateAddInDB)
				,this.userValidation.checkMernisService(candidateAddInDB)
				,this.userValidation.checkIfRealPerson(candidateAddInDB)
				,this.userService.checkDBEmails(candidateAddInDB.getEmail())
				,this.userValidation.checkPasswords(candidateAddInDB.getPassword(), candidateAddInDB.getPasswordAgain()));

		if (!result.isSuccess()) {

			return new ErrorResult(result.getMessage());

		} else {

			this.candidateDao.save(candidateAddInDB);
			return new SuccessResult("Kişi Eklendi.");
		}
	}

	@Override
	public Result update(Candidate candidate) {

		Candidate candidateUpdateInDB = new Candidate();

		candidateUpdateInDB.setFirstName(this.userValidation.CapitalizeFirstLetterofWord(candidate.getFirstName()));

		candidateUpdateInDB.setLastName(candidate.getLastName().toUpperCase());

		candidateUpdateInDB.setDateOfBirth(candidate.getDateOfBirth());

		candidateUpdateInDB.setNationalId(candidate.getNationalId());

		candidateUpdateInDB.setEmail(candidate.getEmail());

		candidateUpdateInDB.setPassword(candidate.getPassword());

		candidateUpdateInDB.setPasswordAgain(candidate.getPasswordAgain());

		candidateUpdateInDB.setCreatedAt(candidate.getCreatedAt());

		candidateUpdateInDB.setDeleted(candidate.isDeleted());

		candidateUpdateInDB.setVerified(candidate.isVerified());
		

		var result = BusinessRules.run(CheckUserExistsByNationalId(candidateUpdateInDB),
				this.userValidation.checkMernisService(candidateUpdateInDB),
				this.userValidation.checkIfRealPerson(candidateUpdateInDB));

		if (!result.isSuccess()) {

			return new ErrorResult(result.getMessage());

		} else {

			this.candidateDao.save(candidateUpdateInDB);
			return new SuccessResult("Kişi Eklendi.");
		}
	}

	@Override
	public Result delete(Candidate candidate) {

		this.candidateDao.delete(candidate);

		return new SuccessResult("Ürün Silindi.");
	}

	@Override
	public DataResult<Candidate> getById(int id) {

		return new SuccessDataResult<Candidate>(candidateDao.getById(id), "Ürünler Listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Ürünler Listelendi.");
	}

	@Override
	public DataResult<Candidate> getByNationalId(String nationalId) {

		return new SuccessDataResult<Candidate>(this.candidateDao.getByNationalId(nationalId), "getByNationalId Data Listelendi.");
	}
	private Result CheckUserExistsByNationalId(Candidate candidate) {

		List<Candidate> nationalIds = candidateDao.findAll();

		for (Candidate nationalId: nationalIds) {

			if (nationalId.getNationalId().equals(candidate.getNationalId())) {
				return new ErrorResult("Bu TCKN daha önce kullanılmış.");
			}
		}
		return new SuccessResult("CheckUserExistsByNationalId TCKN başarılı.");

		/*var candidateNationalId = getByNationalId(candidate.getNationalId());

		if (candidateNationalId.getData() != null) {

			new ErrorResult("Bu TCKN daha önce kullanılmış.");
		}

		return new SuccessResult("TCKN başarılı.");*/



	}
	

}
