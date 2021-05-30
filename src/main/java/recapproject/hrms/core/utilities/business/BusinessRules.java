package recapproject.hrms.core.utilities.business;

import recapproject.hrms.core.utilities.results.Result;
import recapproject.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {

	public static Result run(Result... logics) {
		
		for (Result logic : logics) {
			
			if (!logic.isSuccess()) {
				
				return logic;
			}
		}
		
		return new SuccessResult();
	}
}
