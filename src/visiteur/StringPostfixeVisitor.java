package visiteur;

import patron.Expression;

public class StringPostfixeVisitor extends StringVisitor {

	@Override
	protected String visit(Expression expr, String concat) {
		if (this.iterator == null) {
			concat = "";
			for(this.iterator = expr.getPostfixeIterator(); this.iterator.hasNext();) {
				if(concat.equals("")) {
					concat = (String)this.iterator.next().accept(this);
				}
				else {
					concat += "\n" + (String)this.iterator.next().accept(this);
				}
			}
			this.iterator = null;
		}
		return concat;
	}
	
}