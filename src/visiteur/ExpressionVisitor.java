package visiteur;

import operation.*;
import valeur.*;

public interface ExpressionVisitor {

	public Object visit(Constante c);
	public Object visit(Variable var);

	public Object visit(Addition add);
	public Object visit(Soustraction sou);
	public Object visit(Multiplication mult);
	public Object visit(Division div);
}
