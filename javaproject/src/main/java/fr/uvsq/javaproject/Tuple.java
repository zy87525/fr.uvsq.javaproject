package fr.uvsq.javaproject;

import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;

public class Tuple {
	private Resource Ressource;
	private Resource Predicat;
	private RDFNode Node;
	
	public Tuple(){}
	
	public Tuple(Resource ressource,Resource predicat,RDFNode node){
		this.Ressource = ressource;
		this.Predicat = predicat;
		this.Node = node;
	}
	
	
	public Resource getRessource() {
		return Ressource;
	}
	public void setRessource(Resource ressource) {
		this.Ressource = ressource;
	}
	public Resource getPredicat() {
		return Predicat;
	}
	public void setPredicat(Resource predicat) {
		this.Predicat = predicat;
	}
	public RDFNode getNode() {
		return Node;
	}
	public void setNode(RDFNode node) {
		this.Node = node;
	}
}
