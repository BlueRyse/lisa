package it.unive.lisa.symbolic.value.operator.binary;

import it.unive.lisa.symbolic.value.BinaryExpression;
import it.unive.lisa.symbolic.value.operator.MultiplicationOperator;
import it.unive.lisa.symbolic.value.operator.OverflowingOperator;
import it.unive.lisa.type.NumericType;

/**
 * Given two expressions that both evaluate to numeric values, a
 * {@link BinaryExpression} using this operator computes the arithmetic
 * multiplication of those values. Both arguments and results are expected to be
 * 8-bits numbers, and this operation thus can overflow/underflow.<br>
 * <br>
 * First argument expression type: {@link NumericType} (8-bit)<br>
 * Second argument expression type: {@link NumericType} (8-bit)<br>
 * Computed expression type: {@link NumericType} (8-bit)
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public class Numeric8BitMul extends NumericOperation
		implements MultiplicationOperator, OverflowingOperator {

	/**
	 * The singleton instance of this class.
	 */
	public static final Numeric8BitMul INSTANCE = new Numeric8BitMul();

	/**
	 * Builds the operator. This constructor is visible to allow subclassing:
	 * instances of this class should be unique, and the singleton can be
	 * retrieved through field {@link #INSTANCE}.
	 */
	protected Numeric8BitMul() {
	}

	@Override
	public String toString() {
		return "*";
	}
}
