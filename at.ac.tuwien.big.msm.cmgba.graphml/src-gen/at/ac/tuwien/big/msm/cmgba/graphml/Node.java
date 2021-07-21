/**
 */
package at.ac.tuwien.big.msm.cmgba.graphml;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.msm.cmgba.graphml.Node#getGraph <em>Graph</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends ConnectableElement {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' containment reference.
	 * @see #setGraph(Graph)
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getNode_Graph()
	 * @model containment="true"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.msm.cmgba.graphml.Node#getGraph <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' containment reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

} // Node
