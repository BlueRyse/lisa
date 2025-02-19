package it.unive.lisa.program.cfg.edge;

import it.unive.lisa.analysis.AbstractState;
import it.unive.lisa.analysis.AnalysisState;
import it.unive.lisa.analysis.SemanticException;
import it.unive.lisa.analysis.heap.HeapDomain;
import it.unive.lisa.analysis.lattices.ExpressionSet;
import it.unive.lisa.analysis.value.TypeDomain;
import it.unive.lisa.analysis.value.ValueDomain;
import it.unive.lisa.program.cfg.statement.Statement;
import it.unive.lisa.symbolic.SymbolicExpression;

/**
 * An edge connecting two statements, that is traversed when the condition
 * expressed in the source state holds. The abstract analysis state gets
 * modified by assuming that the statement where this edge originates does hold.
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public class TrueEdge extends Edge {

	/**
	 * Builds the edge.
	 * 
	 * @param source      the source statement
	 * @param destination the destination statement
	 */
	public TrueEdge(Statement source, Statement destination) {
		super(source, destination);
	}

	@Override
	public String toString() {
		return "[ " + getSource() + " ] -T-> [ " + getDestination() + " ]";
	}

	@Override
	public <A extends AbstractState<A, H, V, T>,
			H extends HeapDomain<H>,
			V extends ValueDomain<V>,
			T extends TypeDomain<T>> AnalysisState<A, H, V, T> traverse(
					AnalysisState<A, H, V, T> sourceState)
					throws SemanticException {
		ExpressionSet<SymbolicExpression> exprs = sourceState.getComputedExpressions();
		AnalysisState<A, H, V, T> result = sourceState.bottom();
		for (SymbolicExpression expr : exprs)
			if (sourceState.satisfies(expr, getSource()).mightBeTrue())
				result = result.lub(sourceState.assume(expr, getSource()));
		return result;
	}

	@Override
	public boolean isUnconditional() {
		return false;
	}

	@Override
	public TrueEdge newInstance(Statement source, Statement destination) {
		return new TrueEdge(source, destination);
	}
}
