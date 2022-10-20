package it.unive.lisa.program.cfg;

import it.unive.lisa.program.ProgramValidationException;

/**
 * A signature control flow graph, that has no graph implementation but just its
 * signature<br>
 * <br>
 * Note that this class does not implement {@link #equals(Object)} nor
 * {@link #hashCode()} since all cfgs are unique.
 * 
 * @author <a href="mailto:vincenzo.arceri@unipr.it">Vincenzo Arceri</a>
 */
public class AbstractCFG implements ICFG {

	/**
	 * The descriptor of this signature control flow graph.
	 */
	private final CFGDescriptor descriptor;

	/**
	 * Builds the signature control flow graph.
	 * 
	 * @param descriptor the descriptor of this signature cfg
	 */
	public AbstractCFG(CFGDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public CFGDescriptor getDescriptor() {
		return descriptor;
	}

	@Override
	public void validate() throws ProgramValidationException {
		// nothing to do here
	}
}
