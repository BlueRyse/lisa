package it.unive.lisa.symbolic.value.operator.binary;

import it.unive.lisa.symbolic.value.BinaryExpression;
import it.unive.lisa.type.BooleanType;
import it.unive.lisa.type.StringType;
import it.unive.lisa.type.Type;
import it.unive.lisa.type.common.BoolType;

/**
 * Given two expressions that both evaluate to string values, a
 * {@link BinaryExpression} using this operator checks if the string from the
 * first argument is suffixed by the one of the second argument.<br>
 * <br>
 * First argument expression type: {@link StringType}<br>
 * Second argument expression type: {@link StringType}<br>
 * Computed expression type: {@link BooleanType}
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public class StringEndsWith extends StringOperation {

	/**
	 * The singleton instance of this class.
	 */
	public static final StringEndsWith INSTANCE = new StringEndsWith();

	private StringEndsWith() {
	}

	@Override
	public String toString() {
		return "strends";
	}

	@Override
	protected Type resultType() {
		return BoolType.INSTANCE;
	}
}