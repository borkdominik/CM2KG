/**
 */
package at.ac.tuwien.big.msm.cmgba.graphml;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.msm.cmgba.graphml.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link at.ac.tuwien.big.msm.cmgba.graphml.Edge#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends Element {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ConnectableElement)
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getEdge_Source()
	 * @model
	 * @generated
	 */
	ConnectableElement getSource();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.msm.cmgba.graphml.Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ConnectableElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ConnectableElement)
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlPackage#getEdge_Target()
	 * @model
	 * @generated
	 */
	ConnectableElement getTarget();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.msm.cmgba.graphml.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ConnectableElement value);

} // Edge
