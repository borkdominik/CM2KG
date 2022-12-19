/**
 */
package at.ac.tuwien.big.msm.cmgba.graphml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph ML</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.msm.cmgba.graphml.GraphML#getGraphs <em>Graphs</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getGraphML()
 * @model
 * @generated
 */
public interface GraphML extends EObject {
	/**
	 * Returns the value of the '<em><b>Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.msm.cmgba.graphml.Graph}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphs</em>' containment reference list.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getGraphML_Graphs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Graph> getGraphs();

} // GraphML
