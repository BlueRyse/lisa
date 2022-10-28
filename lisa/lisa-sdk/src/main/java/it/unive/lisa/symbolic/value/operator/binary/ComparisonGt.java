package it.unive.lisa.symbolic.value.operator.binary;

import it.unive.lisa.symbolic.value.BinaryExpression;
import it.unive.lisa.symbolic.value.operator.ComparisonOperator;
import it.unive.lisa.type.BooleanType;
import it.unive.lisa.type.NumericType;

/**
 * Given two expressions that both evaluate to numeric values, a
 * {@link BinaryExpression} using this operator checks if the value of the first
 * argument is greater than the value of the second argument.<br>
 * <br>
 * First argument expression type: {@link NumericType}<br>
 * Second argument expression type: {@link NumericType}<br>
 * Computed expression type: {@link BooleanType}
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public class ComparisonGt extends NumericComparison {

	/**
	 * The singleton instance of this class.
	 */
	public static final ComparisonGt INSTANCE = new ComparisonGt();

	private ComparisonGt() {
	}

	@Override
	public String toString() {
		return ">";
	}

	@Override
	public ComparisonOperator opposite() {
		return ComparisonLe.INSTANCE;
	}
}
