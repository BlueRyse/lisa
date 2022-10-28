package it.unive.lisa.symbolic.value.operator.binary;

import it.unive.lisa.symbolic.value.BinaryExpression;
import it.unive.lisa.symbolic.value.operator.LogicalOperator;
import it.unive.lisa.type.BooleanType;

/**
 * Given two expressions that both evaluate to Boolean values, a
 * {@link BinaryExpression} using this operator computes the logical disjunction
 * of those values, without short-circuiting.<br>
 * <br>
 * First argument expression type: {@link BooleanType}<br>
 * Second argument expression type: {@link BooleanType}<br>
 * Computed expression type: {@link BooleanType}
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public class LogicalOr extends LogicalOperation {

	/**
	 * The singleton instance of this class.
	 */
	public static final LogicalOr INSTANCE = new LogicalOr();

	private LogicalOr() {
	}

	@Override
	public String toString() {
		return "||";
	}

	@Override
	public LogicalOperator opposite() {
		return LogicalAnd.INSTANCE;
	}
}