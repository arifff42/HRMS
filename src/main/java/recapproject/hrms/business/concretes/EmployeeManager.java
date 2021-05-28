package recapproject.hrms.business.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recapproject.hrms.business.MernisService.MernisServiceManager;
import recapproject.hrms.business.abstracts.EmployeeService;
import recapproject.hrms.core.utilities.results.DataResult;
import recapproject.hrms.core.utilities.results.ErrorResult;
import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessDataResult;
import recapproject.hrms.core.utilities.results.SuccessResult;
import recapproject.hrms.dataAccess.abstracts.EmployeeDao;
import recapproject.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	MernisServiceManager mernisServiceManager = new MernisServiceManager();

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {

		this.employeeDao = employeeDao;
	}

	@Override
	public Result add(Employee employee) {

		// System.out.println(mernisServiceManager.TCKNValidation(employee.getNationalIdentity(),
		// employee.getFirstName(),
		// employee.getLastName(), employee.getDateOfYear()));

		this.employeeDao.save(employee);
		return new SuccessResult("Kişi Eklendi.");

		/*
		 * if (mernisServiceManager.TCKNValidation(employee.getNationalIdentity(),
		 * employee.getFirstName(), employee.getLastName(), employee.getDateOfYear())) {
		 * 
		 * this.employeeDao.save(employee); return new SuccessResult("Kişi Eklendi.");
		 * 
		 * } else {
		 * 
		 * return new ErrorResult("Kişi Eklenemedi."); }
		 */
	}

	// private static Employee employeInDB;

	@Override
	public Result update(Employee employee) {

		// public Result update(Employee employee) {

		Employee employeInDB = employeeDao.findById(employee.getId()).get();

		ArrayList<Object> arrayObject = new ArrayList<Object>();

		ArrayList<Employee> arrObject = new ArrayList<Employee>();

		Object[] getObjects = { employee.getFirstName(), employee.getLastName(), employee.getDateOfYear(),
				employee.getNationalIdentity() };

		// Object[] setObjects = {
		// employeInDB.setFirstName(CapitalizeFirstLetterofWord(employee.getFirstName())),
		// employeInDB.setLastName(), employeInDB.setDateOfYear(),
		// employeInDB.setNationalIdentity() };

		for (Object params : getObjects) {
			arrayObject.add(getObjects);
		}

		for (int i = 0; i < arrayObject.size(); i++) {

			if (getObjects[i] == null || getObjects[i] == "") {

				arrayObject.remove(getObjects);
			} else {

			}
		}

		//arrayObject.add(employeInDB.setFirstName(CapitalizeFirstLetterofWord(employee.getFirstName())));

		/*
		 * employeInDB.setFirstName(CapitalizeFirstLetterofWord(employee.getFirstName())
		 * ); employeInDB.setLastName(employee.getLastName().toUpperCase());
		 * employeInDB.setDateOfYear(employee.getDateOfYear());
		 * employeInDB.setNationalIdentity(employee.getNationalIdentity());
		 */

		this.employeeDao.save(employeInDB);

		// this.employeeDao.save(employee);

		return new SuccessResult("Ürün Güncellendi.");
	}

	@Override
	public Result delete(Employee employee) {

		this.employeeDao.delete(employee);

		return new SuccessResult("Ürün Silindi.");
	}

	@Override
	public DataResult<Employee> getById(int id) {

		return new SuccessDataResult<Employee>(employeeDao.getById(id), "Ürünler Listelendi.");
	}

	@Override
	public DataResult<List<Employee>> getAll() {

		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(), "Ürünler Listelendi.");
	}

	public String CapitalizeFirstLetterofSentence(String sentence) {

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
