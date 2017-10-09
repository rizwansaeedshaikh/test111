package com.rizwan.datastructures.array.factory;

import com.rizwan.datastructures.array.FindPair;
import com.rizwan.datastructures.array.solutions.FindPairNaive;

public class FindPairWithGivenSumArrayFactory {

	public static FindPair produce(String typeOfImpl) {
		
		if(typeOfImpl.equals("naive"))
			return new FindPairNaive();
		
		else 
			throw new UnsupportedOperationException(typeOfImpl);
	}
}
