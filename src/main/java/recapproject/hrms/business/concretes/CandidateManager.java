package recapproject.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.experimental.var;
import recapproject.hrms.entities.concretes.Candidate;
import recapproject.hrms.adapters.mernis.MernisVerificationManager;
import recapproject.hrms.business.abstracts.CandidateService;
import recapproject.hrms.core.utilities.business.BusinessRules;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.ErrorResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.dataAccess.abstracts.CandidateDao;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	MernisVerificationManager mernisVerificationManager = new MernisVerificationManager();

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {

		this.candidateDao = candidateDao;
	}

	@Override
	public Result add(Candidate candidate) {

		// System.out.println(mernisServiceManager.TCKNValidation(employee.getNationalIdentity(),
		// employee.getFirstName(),
		// employee.getLastName(), employee.getDateOfYear()));

		Candidate candidateAddInDB = new Candidate();

		candidateAddInDB.setFirstName(CapitalizeFirstLetterofWord(candidate.getFirstName()));

		candidateAddInDB.setLastName(candidate.getLastName().toUpperCase());

		candidateAddInDB.setDateOfBirth(candidate.getDateOfBirth());

		candidateAddInDB.setNationalId(candidate.getNationalId());

		// this.candidateDao.save(candidateAddInDB);

		// return new SuccessResult("Kişi Eklendi.");

		var result = BusinessRules.run(checkUserExistsByNationalId(candidate),
				this.mernisVerificationManager.checkIfRealPerson(candidate));

		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}

		// if (mernisVerificationManager.checkIfRealPerson(candidate) == new
		// SuccessResult()) {

		if (mernisVerificationManager.checkMernisService(candidate)) {

			this.candidateDao.save(candidate);

			return new SuccessResult("Kişi Eklendi.");

		} else {

			return new ErrorResult("Mernis Sistemine Kayıtlı Değil.");
		}
		
		//this.candidateDao.save(candidate);
		//return new SuccessResult("Kişi Eklendi.");
	}

	// private static Employee employeInDB;

	@Override
	public Result update(Candidate candidate) {

		Candidate candidateUpdateInDB = candidateDao.findById(candidate.getCandidateId()).get();

		candidateUpdateInDB.setFirstName(CapitalizeFirstLetterofWord(candidate.getFirstName()));

		candidateUpdateInDB.setLastName(candidate.getLastName().toUpperCase());

		candidateUpdateInDB.setDateOfBirth(candidate.getDateOfBirth());

		candidateUpdateInDB.setNationalId(candidate.getNationalId());

		this.candidateDao.save(candidateUpdateInDB);

		// this.employeeDao.save(employee);

		return new SuccessResult("Ürün Güncellendi.");
	}

	@Override
	public Result delete(Candidate employee) {

		this.candidateDao.delete(employee);

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

		return new SuccessDataResult<Candidate>(candidateDao.findByNationalId(nationalId));

	}

	public String CapitalizeFirstLetterofSentence(String sentence) {

		if (sentence == null || sentence == "") {
			return null;
		}

		String words[] = sentence.split("\\s");
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

	private Result checkUserExistsByNationalId(Candidate candidate) {

		var candidateNationalId = getByNationalId(candidate.getNationalId());
		if (candidateNationalId.getData() != null) {
			
			new ErrorResult("This identification number has been used before.");
		}

		return new SuccessResult();

	}

}
