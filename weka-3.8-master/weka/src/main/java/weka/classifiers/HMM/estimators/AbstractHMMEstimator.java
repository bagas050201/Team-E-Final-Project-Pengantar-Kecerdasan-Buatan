package weka.estimators;

import java.io.Serializable;

public class AbstractHMMEstimator implements Serializable {

	private static final long serialVersionUID = -4206735703010212439L;
	
	
	protected Estimator m_state0Estimator;
	protected Estimator m_stateEstimators[];
	protected int m_NumStates;
	protected boolean m_Laplace;

	public AbstractHMMEstimator(){
		this(6, false);
	}
	
	public AbstractHMMEstimator(int numStates, boolean laplace) {
		super();
		
		m_Laplace = laplace;
		setNumStates(numStates);
		
	}
	
	public AbstractHMMEstimator(AbstractHMMEstimator a) throws Exception
	{	
		setNumStates(a.getNumStates());
		
		m_state0Estimator = Estimator.makeCopy(a.m_state0Estimator);

		for (int s = 0; s < a.getNumStates(); s++)
		{
			m_stateEstimators[s] = Estimator.makeCopy(a.m_stateEstimators[s]);
		}
	}

	public int getNumStates() {
		return m_NumStates;
	}

	public void setNumStates(int NumStates) {
		this.m_NumStates = NumStates;
		
		m_state0Estimator = new DiscreteEstimator(getNumStates(), m_Laplace);
		m_stateEstimators = new Estimator[getNumStates()];
		for (int s = 0; s < getNumStates(); s++)
		{
			m_stateEstimators[s] = new DiscreteEstimator(getNumStates(), m_Laplace);
		}
	}
	
	public int getNumOutputs() {
		return -1;
	}

	public void setNumOutputs(int NumOutputs) throws Exception {
		throw new Exception("Tidak dapat mengatur jumlah keluaran pada Estimator HMM non-nominal");
	}


	public int getOutputDimension() {
		// TODO Auto-generated method stub
		return 1;
	}

	public String  toString() {
	    String s = "";

	    s = s + "Step 0 state estimator " + m_state0Estimator.toString() + "\n";
	    
	    for (int i = 0; i < m_stateEstimators.length; i++)
	    	s = s + "State Estimator, keadaan sebelumnya " + i + " " + m_stateEstimators[i].toString() + "\n";
	    
	    return s;
	}

}