package recapproject.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.adapters.mernis.MernisVerificationManager;
import recapproject.hrms.business.abstracts.EmployerService;
import recapproject.hrms.business.abstracts.UserService;
import recapproject.hrms.core.utilities.business.BusinessRules;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.ErrorResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.core.validation.UserValidation;
import recapproject.hrms.dataAccess.abstracts.EmployerDao;
import recapproject.hrms.entities.concretes.Employer;
import recapproject.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService {

	private final EmployerDao employerDao;
	private UserService userService;
	
	UserValidation userValidation = new UserValidation(new MernisVerificationManager());

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService) {

		this.employerDao = employerDao;
		this.userService = userService;
	}

	@Override
	public Result add(Employer employer) {
		
		Employer  employerAddInDB = new Employer();

		employerAddInDB.setCompanyName(CapitalizeFirstLetterofWord(employer.getCompanyName()));

		employerAddInDB.setEmail(employer.getEmail());
		
		employerAddInDB.setWebAddress(employer.getWebAddress());

		employerAddInDB.setPhoneNumber(employer.getPhoneNumber());
		
		employerAddInDB.setPassword(employer.getPassword());
		
		employerAddInDB.setPasswordAgain(employer.getPasswordAgain());
		
		employerAddInDB.setCreatedAt(employer.getCreatedAt());
		
		employerAddInDB.setDeleted(employer.isDeleted());
		
		employerAddInDB.setVerified(employer.isVerified());
		
		var result = BusinessRules.run(this.userValidation.checkEmail(employerAddInDB)
				,this.userValidation.checkPasswords(employerAddInDB.getPassword(), employerAddInDB.getPasswordAgain())
				,this.userService.checkDBEmails(employerAddInDB.getEmail()));

		if (!result.isSuccess()) {

			return new ErrorResult(result.getMessage());

		} else {

			this.employerDao.save(employerAddInDB);
			return new SuccessResult("Ki??i Eklendi deneme.");
		}
	}

	@Override
	public Result update(Employer employer) {

		this.employerDao.save(employer);

		return new SuccessResult("??r??n G??ncellendi.");
	}

	@Override
	public Result delete(Employer employer) {

		this.employerDao.delete(employer);

		return new SuccessResult("??r??n Silindi.");
	}

	@Override
	public DataResult<Employer> getById(int id) {

		return new SuccessDataResult<Employer>(employerDao.getById(id), "??r??nler Listelendi.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "??r??nler Listelendi.");
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



}
