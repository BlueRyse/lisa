package it.unive.lisa.program.cfg.statement;

import it.unive.lisa.analysis.AbstractState;
import it.unive.lisa.analysis.AnalysisState;
import it.unive.lisa.analysis.SemanticException;
import it.unive.lisa.analysis.StatementStore;
import it.unive.lisa.analysis.heap.HeapDomain;
import it.unive.lisa.analysis.value.TypeDomain;
import it.unive.lisa.analysis.value.ValueDomain;
import it.unive.lisa.interprocedural.InterproceduralAnalysis;
import it.unive.lisa.program.cfg.CFG;
import it.unive.lisa.program.cfg.CodeLocation;
import it.unive.lisa.symbolic.SymbolicExpression;
import it.unive.lisa.symbolic.value.Identifier;
import it.unive.lisa.symbolic.value.Variable;

/**
 * Returns an expression to the caller CFG, terminating the execution of the CFG
 * where this statement lies. For terminating CFGs that do not return any value,
 * use {@link Ret}.
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public class Return extends UnaryStatement implements MetaVariableCreator {

	/**
	 * Builds the return, returning {@code expression} to the caller CFG,
	 * happening at the given location in the program.
	 * 
	 * @param cfg        the cfg that this statement belongs to
	 * @param location   the location where this statement is defined within the
	 *                       program
	 * @param expression the expression to return
	 */
	public Return(CFG cfg, CodeLocation location, Expression expression) {
		super(cfg, location, expression);
	}

	@Override
	public final String toString() {
		return "return " + getExpression();
	}

	@Override
	public boolean stopsExecution() {
		return true;
	}

	@Override
	public final Identifier getMetaVariable() {
		Expression e = getExpression();
		String name = "ret_value@" + getCFG().getDescriptor().getName();
		Variable var = new Variable(e.getStaticType(), name, getLocation());
		return var;
	}

	@Override
	public <A extends AbstractState<A, H, V, T>,
			H extends HeapDomain<H>,
			V extends ValueDomain<V>,
			T extends TypeDomain<T>> AnalysisState<A, H, V, T> semantics(
					AnalysisState<A, H, V, T> entryState,
					InterproceduralAnalysis<A, H, V, T> interprocedural,
					StatementStore<A, H, V, T> expressions)
					throws SemanticException {
		AnalysisState<A, H, V, T> exprResult = getExpression().semantics(entryState, interprocedural, expressions);
		expressions.put(getExpression(), exprResult);

		AnalysisState<A, H, V, T> result = entryState.bottom();
		Identifier meta = getMetaVariable();
		for (SymbolicExpression expr : exprResult.getComputedExpressions()) {
			AnalysisState<A, H, V, T> tmp = exprResult.assign(meta, expr, this);
			result = result.lub(tmp);
		}

		if (!getExpression().getMetaVariables().isEmpty())
			result = result.forgetIdentifiers(getExpression().getMetaVariables());
		return result;
	}
}
