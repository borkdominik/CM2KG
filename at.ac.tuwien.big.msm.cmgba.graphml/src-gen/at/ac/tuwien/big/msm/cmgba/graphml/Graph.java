/**
 */
package at.ac.tuwien.big.msm.cmgba.graphml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.msm.cmgba.graphml.Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link at.ac.tuwien.big.msm.cmgba.graphml.Graph#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends ConnectableElement {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.msm.cmgba.graphml.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.msm.cmgba.graphml.Edge}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getGraph_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

} // Graph
