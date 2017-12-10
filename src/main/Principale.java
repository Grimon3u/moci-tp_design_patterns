package main;

import iterateur.*;
import operation.*;
import patron.*;
import valeur.*;
import visiteur.*;

public class Principale {

	public static void main(String[] args) {

		Contexte tds = new Contexte();
		EvaluateVisitor evalV = new EvaluateVisitor(tds);
		ExpressionVisitor sPostV = new StringPostfixeVisitor();
		ExpressionVisitor sInfV = new StringInfixeVisitor();
		ExpressionVisitor sPreV = new StringPrefixeVisitor();

		// ((a + b) * (a - c) + b + 4 - a) / 2
		Variable a = 				new Variable("a");
		Variable b = 				new Variable("b");
		Variable c = 				new Variable("c");
		Expression ab = 			new Addition(a, b);
		Expression ac = 			new Soustraction(a, c);
		Expression ab_ac = 			new Multiplication(ab, ac);
		Expression ab_ac_b = 		new Addition(ab_ac, b);
		Expression ab_ac_b_4 = 		new Addition(ab_ac_b, new Constante(4));
		Expression ab_ac_b_4_a = 	new Soustraction(ab_ac_b_4, a);
		Expression ab_ac_b_4_a_2 = 	new Division(ab_ac_b_4_a, new Constante(2));

		tds.add("a", 18);
		tds.add("b", 25);
		tds.add("c", 2);

		String barre = "-------------------------";

		// ÉVALUATION
		System.out.println(barre + "\n"
				+ "Évaluation" + "\n"
				+ barre + "\n"
				+ ab_ac_b_4_a_2.evaluate(tds) + "\n");

		// TOSTRING
		System.out.println(barre + "\n"
				+ "toString" + "\n"
				+ barre + "\n"
				+ ab_ac_b_4_a_2.toString() + "\n");

		// ITÉRATEURS
		System.out.println(barre + "\n"
				+ "Parcours préfixé" + "\n"
				+ barre);
		for (ExpressionIterator itPre = ab_ac_b_4_a_2.getPrefixeIterator() ; itPre.hasNext();) {
			System.out.println(itPre.next());
		}

		System.out.println(barre + "\n"
				+ "Parcours infixé" + "\n"
				+ barre);
		for (ExpressionIterator itInf = ab_ac_b_4_a_2.getInfixeIterator() ; itInf.hasNext();) {
			System.out.println(itInf.next());
		}

		System.out.println(barre + "\n"
				+ "Parcours postfixé" + "\n"
				+ barre);
		for (ExpressionIterator itPost = ab_ac_b_4_a_2.getPostfixeIterator() ; itPost.hasNext();) {
			System.out.println(itPost.next());
		}
		System.out.println();

		// VISITEURS
		System.out.println(barre + "\n"
				+ "Visiteur évaluateur" + "\n"
				+ barre + "\n"
				+ ab_ac_b_4_a_2.accept(evalV));

		System.out.println(barre + "\n"
				+ "Visiteur préfixé :" + "\n"
				+ barre + "\n"
				+ ab_ac_b_4_a_2.accept(sPreV));// ab_ac_b_4_a_2.accept(sPreV) + "\n");

		System.out.println(barre + "\n"
				+ "Visiteur infixé :" + "\n"
				+ barre + "\n"
				+ ab_ac_b_4_a_2.accept(sInfV) + "\n");

		System.out.println(barre + "\n"
				+ "Visiteur postfixé :" + "\n"
				+ barre + "\n"
				+ ab_ac_b_4_a_2.accept(sPostV));

	}

}