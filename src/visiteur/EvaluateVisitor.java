package visiteur;

import java.util.Observable;
import java.util.Observer;

import operation.*;
import patron.Contexte;
import valeur.*;

public class EvaluateVisitor implements ExpressionVisitor, Observer {

	Contexte tds;
	
	public EvaluateVisitor(Contexte tds) {
		this.tds = tds;
		this.tds.addObserver(this);
	}
	
	@Override
	public Integer visit(Constante c) {
		return c.getValeur();
	}

	@Override
	public Integer visit(Variable var) {
		return this.tds.getTds().get(var.getNom());
	}

	@Override
	public Integer visit(Addition add) {
		return (Integer)add.getLeftSon().accept(this) + (Integer)add.getRightSon().accept(this);
	}

	@Override
	public Integer visit(Soustraction sou) {
		return (Integer)sou.getLeftSon().accept(this) - (Integer)sou.getRightSon().accept(this);
	}

	@Override
	public Integer visit(Multiplication mult) {
		return (Integer)mult.getLeftSon().accept(this) * (Integer)mult.getRightSon().accept(this);
	}

	@Override
	public Integer visit(Division div) {
		return (Integer)div.getLeftSon().accept(this) / (Integer)div.getRightSon().accept(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.tds = (Contexte)o;
	}

}