package recapproject.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class CandidateManager implements CandidateService {

	private final CandidateDao candidateDao;
	
	UserValidation userValidation = new UserValidation(new MernisVerificationManager());
	
	//MernisVerificationManager mernisVerificationManager = new MernisVerificationManager();

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {

		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(Candidate candidate) {

		Candidate candidateAddInDB = new Candidate();

		candidateAddInDB.setFirstName(CapitalizeFirstLetterofWord(candidate.getFirstName()));

		candidateAddInDB.setLastName(candidate.getLastName().toUpperCase());

		candidateAddInDB.setDateOfBirth(candidate.getDateOfBirth());

		candidateAddInDB.setNationalId(candidate.getNationalId());
		
		candidateAddInDB.setEmail(candidate.getEmail());
		
		candidateAddInDB.setPassword(candidate.getPassword());
		
		candidateAddInDB.setPasswordAgain(candidate.getPasswordAgain());
		
		candidateAddInDB.setCreatedAt(candidate.getCreatedAt());
		
		candidateAddInDB.setDeleted(candidate.isDeleted());
		
		candidateAddInDB.setVerified(candidate.isVerified());
		

		var result = BusinessRules.run(checkUserExistsByNationalId(candidateAddInDB),
				this.userValidation.checkMernisService(candidateAddInDB),
				this.userValidation.checkIfRealPerson(candidateAddInDB));

		if (!result.isSuccess()) {

			return new ErrorResult(result.getMessage());

		} else {

			this.candidateDao.save(candidateAddInDB);
			return new SuccessResult("Kişi Eklendi.");
		}
	}

	@Override
	public Result update(Candidate candidate) {

		Candidate candidateAddInDB = new Candidate();

		candidateAddInDB.setFirstName(CapitalizeFirstLetterofWord(candidate.getFirstName()));

		candidateAddInDB.setLastName(candidate.getLastName().toUpperCase());

		candidateAddInDB.setDateOfBirth(candidate.getDateOfBirth());

		candidateAddInDB.setNationalId(candidate.getNationalId());
		
		candidateAddInDB.setEmail(candidate.getEmail());
		
		candidateAddInDB.setPassword(candidate.getPassword());
		
		candidateAddInDB.setPasswordAgain(candidate.getPasswordAgain());
		
		candidateAddInDB.setCreatedAt(candidate.getCreatedAt());
		
		candidateAddInDB.setDeleted(candidate.isDeleted());
		
		candidateAddInDB.setVerified(candidate.isVerified());
		

		var result = BusinessRules.run(checkUserExistsByNationalId(candidateAddInDB),
				this.userValidation.checkMernisService(candidateAddInDB),
				this.userValidation.checkIfRealPerson(candidateAddInDB));

		if (!result.isSuccess()) {

			return new ErrorResult(result.getMessage());

		} else {

			this.candidateDao.save(candidateAddInDB);
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
	
	
	public String CapitalizeFirstLetterofSentence(String sentence) {

		if (sentence == null || sentence == "") {

			return null;
		}

		String[] words = sentence.split("\\s");
		String capitalizeStr = "";

		for (String word : words) {
			// Capitalize first letter
			String firstLetter = word.substring(0, 1);
			// Get remaining letter
			String remainingLetters = word.substring(1);
			capitalizeStr += firstLetter.toUpperCase() + remainingLetters + " ";
		}

		return capitalizeStr;
	}

	public String CapitalizeFirstLetterofWord(String word) {

		if (word == null || word == "") {
			return null;
		}

		// get First letter of the string
		String firstLetStr = word.substring(0, 1);
		// Get remaining letter using substring
		String remLetStr = word.substring(1);

		// convert the first letter of String to uppercase
		firstLetStr = firstLetStr.toUpperCase();

		// concantenate the first letter and remaining string
		String firstLetterCapitalizedName = firstLetStr + remLetStr;

		return firstLetterCapitalizedName;
	}

	public String UpperAllLetters(String letter) {

		if (letter == null || letter == "") {
			return null;
		}

		String result = letter.toUpperCase();

		return result;
	}

	private Result checkUserExistsByNationalId(Candidate candidate) {

		var candidateNationalId = getByNationalId(candidate.getNationalId());

		if (candidateNationalId.getData() != null) {

			new ErrorResult("Bu TCKN daha önce kullanılmış.");
		}

		return new SuccessResult("TCKN başarılı.");
	}
}
