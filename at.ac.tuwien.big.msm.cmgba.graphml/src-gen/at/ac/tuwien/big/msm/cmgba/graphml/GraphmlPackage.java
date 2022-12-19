/**
 */
package at.ac.tuwien.big.msm.cmgba.graphml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphmlFactory
 * @model kind="package"
 * @generated
 */
public interface GraphmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/graphml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "graphml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphmlPackage eINSTANCE = at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphMLImpl <em>Graph ML</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphMLImpl
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getGraphML()
	 * @generated
	 */
	int GRAPH_ML = 0;

	/**
	 * The feature id for the '<em><b>Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ML__GRAPHS = 0;

	/**
	 * The number of structural features of the '<em>Graph ML</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ML_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Graph ML</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_ML_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.ElementImpl
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__DATA_ATTRIBUTES = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.ConnectableElementImpl <em>Connectable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.ConnectableElementImpl
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getConnectableElement()
	 * @generated
	 */
	int CONNECTABLE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT__DATA_ATTRIBUTES = ELEMENT__DATA_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT__NAME = ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Connectable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Connectable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTABLE_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphImpl
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__DATA_ATTRIBUTES = CONNECTABLE_ELEMENT__DATA_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__ID = CONNECTABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NAME = CONNECTABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__EDGES = CONNECTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_OPERATION_COUNT = CONNECTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.NodeImpl
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DATA_ATTRIBUTES = CONNECTABLE_ELEMENT__DATA_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = CONNECTABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = CONNECTABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GRAPH = CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = CONNECTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.EdgeImpl
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 4;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__DATA_ATTRIBUTES = ELEMENT__DATA_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.DataImpl
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getData()
	 * @generated
	 */
	int DATA = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__KEY = 1;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.msm.cmgba.graphml.GraphML <em>Graph ML</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph ML</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphML
	 * @generated
	 */
	EClass getGraphML();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.msm.cmgba.graphml.GraphML#getGraphs <em>Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Graphs</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.GraphML#getGraphs()
	 * @see #getGraphML()
	 * @generated
	 */
	EReference getGraphML_Graphs();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.msm.cmgba.graphml.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.msm.cmgba.graphml.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.msm.cmgba.graphml.Graph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Graph#getEdges()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Edges();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.msm.cmgba.graphml.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.msm.cmgba.graphml.Node#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graph</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Node#getGraph()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Graph();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.msm.cmgba.graphml.ConnectableElement <em>Connectable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connectable Element</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.ConnectableElement
	 * @generated
	 */
	EClass getConnectableElement();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.msm.cmgba.graphml.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.msm.cmgba.graphml.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.msm.cmgba.graphml.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.msm.cmgba.graphml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.msm.cmgba.graphml.Element#getDataAttributes <em>Data Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Attributes</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Element#getDataAttributes()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_DataAttributes();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.msm.cmgba.graphml.Element#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Element#getId()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.msm.cmgba.graphml.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.msm.cmgba.graphml.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.msm.cmgba.graphml.Data#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Data#getValue()
	 * @see #getData()
	 * @generated
	 */
	EAttribute getData_Value();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.msm.cmgba.graphml.Data#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see at.ac.tuwien.big.msm.cmgba.graphml.Data#getKey()
	 * @see #getData()
	 * @generated
	 */
	EAttribute getData_Key();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphmlFactory getGraphmlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphMLImpl <em>Graph ML</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphMLImpl
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getGraphML()
		 * @generated
		 */
		EClass GRAPH_ML = eINSTANCE.getGraphML();

		/**
		 * The meta object literal for the '<em><b>Graphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_ML__GRAPHS = eINSTANCE.getGraphML_Graphs();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphImpl
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__EDGES = eINSTANCE.getGraph_Edges();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.NodeImpl
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__GRAPH = eINSTANCE.getNode_Graph();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.ConnectableElementImpl <em>Connectable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.ConnectableElementImpl
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getConnectableElement()
		 * @generated
		 */
		EClass CONNECTABLE_ELEMENT = eINSTANCE.getConnectableElement();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.EdgeImpl
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.ElementImpl
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Data Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__DATA_ATTRIBUTES = eINSTANCE.getElement_DataAttributes();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__ID = eINSTANCE.getElement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.msm.cmgba.graphml.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.DataImpl
		 * @see at.ac.tuwien.big.msm.cmgba.graphml.impl.GraphmlPackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA__VALUE = eINSTANCE.getData_Value();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA__KEY = eINSTANCE.getData_Key();

	}

} //GraphmlPackage
